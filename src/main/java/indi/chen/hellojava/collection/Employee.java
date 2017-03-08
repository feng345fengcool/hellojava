package indi.chen.hellojava.collection;

import java.util.Date;

public class Employee {
    private Name name;
    private Integer number;
    private Date hireDate;

    public Employee(Name name, Integer number, Date hireDate) {
        super();
        this.name = name;
        this.number = number;
        this.hireDate = hireDate;
    }

    public Name name() {
        return name;
    }

    public Integer number() {
        return number;
    }

    public Date hireDate() {
        return hireDate;
    }
}
