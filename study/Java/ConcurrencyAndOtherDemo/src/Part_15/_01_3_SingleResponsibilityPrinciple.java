package Part_15;

public class _01_3_SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.runRoad("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("潜艇");
    }
}

class Vehicle {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + " 在路上跑...");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在空中飞...");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水里游...");
    }
}
