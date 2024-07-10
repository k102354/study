package soo.jun.kim.study;

public class Animal<T> {
    private T name;

    public Animal(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}
