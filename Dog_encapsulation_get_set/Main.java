public class Main {
    public static void main(String[] args) {
    Dog one = new Dog();
    Dog two = new Dog();
    Dog three = new Dog();

    one.setSize(70);
    two.setSize(50);
    three.setSize(9);

    System.out.println("1я собака имеет размер " + one.getSize());
    System.out.println("2я собака имеет размер " + two.getSize());
    System.out.println("3я собака имеет размер " + three.getSize());

    one.bark();
    two.bark();
    three.bark();

    }
}