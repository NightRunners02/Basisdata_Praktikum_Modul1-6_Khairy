package Basisdatapraktikum.Modul1.Codelab.Codelab1;

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void display() {
        System.out.println("Box contains: " + value);
    }
}

public class Codelab1 {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(42);
        int intValue = integerBox.getValue();
        System.out.println("Integer value: " + intValue);

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics!");
        String stringValue = stringBox.getValue();
        System.out.println("String value: " + stringValue);
    }
}
