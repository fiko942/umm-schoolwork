class Container<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}

public class Main {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.setContent(437); 
        System.out.println("Integer content: " + intContainer.getContent()); 

        Container<String> strContainer = new Container<>();
        strContainer.setContent("Test generic aja ini mah");
        System.out.println("String content: " + strContainer.getContent()); 
    }
}
