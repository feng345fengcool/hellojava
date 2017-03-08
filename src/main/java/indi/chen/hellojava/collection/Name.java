package indi.chen.hellojava.collection;

public class Name implements Comparable<Name> {

    // 对于所比较的内容 其不可变的类型是必须的
    private final String firstName, lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new NullPointerException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    // 如果指定的对象是null或者是不合适的类型 返回false 此情况下 compareTo方法抛出一个运行时的异常
    public boolean equals(Object o) {
        if (!(o instanceof Name)) {
            return false;
        }
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    // hashCode方法 被重新定义 对于重新定义了equals方法的任何类型都是必要的 相等的对象必须有相等的散列码
    public int hashCode() {
        return 31 * firstName.hashCode() + lastName.hashCode();
    }

    // 各种集合类型的toString方法依赖于他们的元素、键和值的toString方法
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    // 自然顺序 也就是 完整顺序 total order
    public int compareTo(Name n) {
        // 对于compareTo方法的行为有四个限制 请查阅API文档研究他们
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }
}
