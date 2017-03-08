package indi.chen.hellojava.serialize;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -181969854923775893L;
    private String name;
    private String address;
    private String sex;
    private int age;

    public Person(String name, String address, int age) {
        super();
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
