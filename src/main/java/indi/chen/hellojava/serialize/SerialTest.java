package indi.chen.hellojava.serialize;

import java.io.*;

public class SerialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Person person = new Person("chens", "hangzhou", 25);
        //writeObject(person);
        Person person = readObject();
        System.out.println(person.getAddress());

    }

    public static Person readObject() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/person"));
        Person person = (Person) ois.readObject();
        return person;
    }

    public static void writeObject(Person person) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/person"));
        oos.writeObject(person);
        oos.close();
    }

}
