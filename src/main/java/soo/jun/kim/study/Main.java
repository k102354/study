package soo.jun.kim.study;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.getName()); // Dog
        System.out.println(dog.getName().getClass().getSimpleName()); // Dat

        Animal cat = new Cat();
        System.out.println(cat.getName()); // Cat
        System.out.println(cat.getName().getClass().getSimpleName()); // Cat

    }
}
