import com.sun.java.swing.plaf.motif.MotifOptionPaneUI;

import java.util.*;

public class Main {

//    Main
//    static isRaining //30% chance of rain every hour
//    createVehicles() // creates 10 cars, 10 trucks and 10 motorcycles
//    simulateRace() // simulates the race by calling moveForAnHour() on every vehicle 50 times
//    and setting whether its raining.
//    printRaceResults() // prints each vehicle's name, distance traveled ant type.


    public static ArrayList<Car> listOfCars = new ArrayList<>();
    public static ArrayList<Motorcycle> listOfMotorcycles = new ArrayList<>();
    public static ArrayList<Truck> listOfTrucks = new ArrayList<>();
    public static int countingCarHours;
    public static int countingMotorHours;
    public static int countingTruckHours;

    {
        countingCarHours = 0;
        countingMotorHours = 0;
        countingTruckHours = 0;
    }

    public static void main(String[] args) {

        createVehicles();
        simulateRace();
        printRaceResults();

    }

    public static void simulateRace() {
        boolean isRaining;
        for (int i = 0; i < 50; i++) {
            isRaining = isRaining();
            Car.moveForAnHour(isRaining);
            Motorcycle.moveForAnHour(isRaining);
            Truck.moveForAnHour();
        }
    }


    public static void printRaceResults() {
        printCarResult();
        printMotorcycleResult();
        printTruckResult();
    }


    public static boolean isRaining() {
        int chanceOfRain = randInt(1,100);
        boolean raining;
        if (chanceOfRain < 31) {
            raining = true;
        } else {
            raining = false;
        }
        return raining;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void createVehicles() {

        Truck.createNames();
        String motorName;
        int truckName;

        for(int i = 0; i < 10; i++) {
            Car myCar = new Car();
            listOfCars.add(myCar);

            motorName = "Motorcycle " + (i + 1);
            Motorcycle myMotorcycle = new Motorcycle(motorName);
            listOfMotorcycles.add(myMotorcycle);

            truckName = Truck.driverNames.get(i);
            Truck myTruck = new Truck(truckName);
            listOfTrucks.add(myTruck);

        }
    }

    public static void printCarResult() {
        String name;
        int distanceTraveled;
        int avgSpeed;
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Final results of the Car racers");
        System.out.println("-------------------------------");
        System.out.println("");

        for (Car myCar: listOfCars) {
            name = myCar.getName();
            distanceTraveled = myCar.getDistanceTraveled();
            avgSpeed = myCar.getDistanceTraveled() / 50;
            System.out.println(name + " belongs to the " + myCar.getClass() +
                    " and the driver traveled " + distanceTraveled + " km with an average speed of " +
                    avgSpeed + " km/h.");
        }
    }

    public static void printMotorcycleResult() {
        String name;
        int distanceTraveled;
        int avgSpeed;
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("Final results of the Motorcycle racers");
        System.out.println("--------------------------------------");
        System.out.println("");
        for (Motorcycle myMotor: listOfMotorcycles) {
            name = myMotor.getName();
            distanceTraveled = myMotor.getDistanceTraveled();
            avgSpeed = myMotor.getDistanceTraveled() / 50;
            System.out.println(name + " belongs to the " + myMotor.getClass() +
                    " and the driver traveled " + distanceTraveled + " km with an average speed of " +
                    avgSpeed + " km/h.");
        }
    }

    public static void printTruckResult() {
        int name;
        int distanceTraveled;
        int avgSpeed;
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("Final results of the Truck racers");
        System.out.println("---------------------------------");
        System.out.println("");
        for (Truck myTruck: listOfTrucks) {
            name = myTruck.getName();
            distanceTraveled = myTruck.getDistanceTraveled();
            avgSpeed = myTruck.getDistanceTraveled() / 50;
            System.out.println(name + " belongs to the " + myTruck.getClass() +
                    " and the driver traveled " + distanceTraveled + " km with an average speed of " +
                    avgSpeed + " km/h.");
        }
    }
}
