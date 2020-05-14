package Part_15;

public class _01_1_SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Vehicle1 vehicle = new Vehicle1();
        vehicle.run("汽车");
        vehicle.run("飞机");
        vehicle.run("潜艇");
    }
}


class Vehicle1 {
    public void run (String vehicle) {
        System.out.println(vehicle + " 在公路上运行...");
    }
}