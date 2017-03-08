package indi.chen.hellojava.basic;

public class Person {

    public static int count1;
    public static int count2 = 5;
    private static Person person = new Person();

    private Person() {
        count1++;
        count2++;
    }

    private static Person getInstance() {
        return person;
    }

    public static void main(String[] args) {
        Person person = Person.getInstance();
        System.out.println(count1);
        System.out.println(count2);
    }
}
