package Part_15;

public class _01_2_SingleResponsibilityPrinciple {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("潜艇");
    }
}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在路上跑...");
    }
}

class AirVehicle {
    public void run (String vehicle) {
        System.out.println(vehicle + " 在空中飞...");
    }
}

class WaterVehicle {
    public void run (String vehicle) {
        System.out.println(vehicle + " 在水里游...");
    }
}


