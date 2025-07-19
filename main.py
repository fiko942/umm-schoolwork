# IMPORTANT: RUN THIS CELL IN ORDER TO IMPORT YOUR KAGGLE DATA SOURCES,
# THEN FEEL FREE TO DELETE THIS CELL.
# NOTE: THIS NOTEBOOK ENVIRONMENT DIFFERS FROM KAGGLE'S PYTHON
# ENVIRONMENT SO THERE MAY BE MISSING LIBRARIES USED BY YOUR
# NOTEBOOK.
import kagglehub
jangedoo_utkface_new_path = kagglehub.dataset_download('jangedoo/utkface-new')

print('Data source import complete.')
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import cv2
import os
import glob
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, mean_absolute_error
import tensorflow as tf
from tensorflow.keras.models import Model
from tensorflow.keras.layers import Input, Conv2D, MaxPooling2D, Flatten, Dense, Dropout, BatchNormalization
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import EarlyStopping, ReduceLROnPlateau, ModelCheckpoint
import warnings
warnings.filterwarnings('ignore')

print("🚀 Bắt đầu dự đoán Giới tính & Độ tuổi với UTKFace")
print(f"Phiên bản TensorFlow: {tf.__version__}")

print("\n=== A. TẢI DỮ LIỆU & TIỀN XỬ LÝ ===")

# Đường dẫn dataset (tùy chỉnh cho Kaggle)
dataset_path = './DATASET'

# Tải dataset
def load_utkface_data(dataset_path, sample_size=None):
    """Load và preprocess UTKFace dataset"""
    
    # Lấy tất cả tệp ảnh
    image_files = glob.glob(os.path.join(dataset_path, '*.jpg'))
    
    if sample_size:
        image_files = image_files[:sample_size]
    
    print(f"📁 Tìm thấy {len(image_files)} ảnh")
    
    ages = []
    genders = []
    images = []
    
    for i, file_path in enumerate(image_files):
        try:
            # Phân tích tên file: [age]_[gender]_[race]_[date&time].jpg
            filename = os.path.basename(file_path)
            age, gender, race, _ = filename.split('_')
            
            # Load và preprocess image
            img = cv2.imread(file_path)
            img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)  # Convert to grayscale
            img = cv2.resize(img, (128, 128))  # Resize to 128x128
            img = img / 255.0  # Normalize
            
            ages.append(int(age))
            genders.append(int(gender))  # 0: Male, 1: Female
            images.append(img)
            
            if (i + 1) % 1000 == 0:
                print(f"Đã xử lý {i + 1}/{len(image_files)} ảnh")
                
        except Exception as e:
            print(f"Error processing {file_path}: {e}")
            continue
    
    return np.array(images), np.array(ages), np.array(genders)

# Tải dữ liệu
print("📊 Đang tải dataset UTKFace...")
images, ages, genders = load_utkface_data(dataset_path, sample_size=15000)  # Limit for memory

# Ensure all arrays have the same length
min_len = min(len(images), len(ages), len(genders))
images = images[:min_len]
ages = ages[:min_len]
genders = genders[:min_len]

print(f"✅ Đã tải {len(images)} mẫu")
print(f"📊 Kích thước ảnh: {images[0].shape}")
print(f"📊 Khoảng tuổi: {ages.min()} - {ages.max()}")
print(f"📊 Phân bố giới tính: Male={np.sum(genders==0)}, Female={np.sum(genders==1)}")

# Thay đổi kích thước ảnh cho CNN
images = images.reshape(-1, 128, 128, 1)

# Chuẩn hóa tuổi về khoảng [0, 1]
ages_normalized = ages / 100.0

print(f"✅ Hoàn tất tiền xử lý dữ liệu")
print(f"📊 Kích thước cuối - Images: {images.shape}, Ages: {ages_normalized.shape}, Genders: {genders.shape}")


print("\n=== B. PHÂN TÍCH KHÁM PHÁ DỮ LIỆU ===")

# Phân bố độ tuổi
plt.figure(figsize=(15, 5))

plt.subplot(1, 3, 1)
plt.hist(ages, bins=30, alpha=0.7, color='skyblue', edgecolor='black')
plt.title('Age Distribution')
plt.xlabel('Age')
plt.ylabel('Frequency')

plt.subplot(1, 3, 2)
gender_counts = pd.Series(genders).value_counts()
plt.pie(gender_counts.values, labels=['Male', 'Female'], autopct='%1.1f%%', colors=['lightblue', 'pink'])
plt.title('Gender Distribution')

plt.subplot(1, 3, 3)
plt.scatter(ages, genders, alpha=0.6, s=1)
plt.xlabel('Age')
plt.ylabel('Gender (0=Male, 1=Female)')
plt.title('Age vs Gender Distribution')

plt.tight_layout()
plt.show()

# Ảnh mẫu
plt.figure(figsize=(15, 8))
for i in range(12):
    plt.subplot(3, 4, i+1)
    plt.imshow(images[i].squeeze(), cmap='gray')
    plt.title(f'Age: {ages[i]}, Gender: {"Female" if genders[i]==1 else "Male"}')
    plt.axis('off')
plt.suptitle('Sample Images from UTKFace Dataset')
plt.tight_layout()
plt.show()