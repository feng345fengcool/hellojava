package indi.chen.hellojava.basic;

/**
 * 型构 与 方法名、参数数量、类型、顺序有关
 * <p>
 * 也就是从方法名开始之后的内容如果相同就是相同的型构 不包括方法的返回值类型 访问权限修饰符
 */

interface Car {

    String getName();

    int getPrice();
}

class BMW implements Car {
    public String getName() {
        return "BMW";
    }

    public int getPrice() {
        return 300000;
    }
}

class CheryQQ implements Car {
    public String getName() {
        return "CheryQQ";
    }

    public int getPrice() {
        return 20000;
    }
}

public class CarShop {

    private int money = 0;

    public static void main(String[] args) {
        CarShop aShop = new CarShop();

        aShop.sellCar(new BMW());
        aShop.sellCar(new CheryQQ());
        System.out.println("总收入：" + aShop.getMoney());
    }

    public void sellCar(Car car) {
        System.out.println("车型：" + car.getName() + " 单价：" + car.getPrice());
        money += car.getPrice();
    }

    public int getMoney() {
        return money;
    }
}