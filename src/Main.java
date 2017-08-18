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
    public static List<Object> winner = new ArrayList <>();

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
            Truck.moveForAnHour(isRaining);
        }
    }


    public static void printRaceResults() {
        String name;
        int truckName;
        int distanceTraveled;
        int avgSpeed;

        System.out.println("");
        for (int i = 0; i < 10; i++) {

            // Car section
            winner.add(listOfCars.get(i));
            name = listOfCars.get(i).getName();
            distanceTraveled = listOfCars.get(i).getDistanceTraveled();
            avgSpeed = (listOfCars.get(i).getDistanceTraveled() / 50 );

            System.out.println(name + " belongs to the " + listOfCars.get(i).getClass() +
                               " and he/she traveled " + distanceTraveled + " km with an average speed of " +
                                avgSpeed + " km/h.");

            // Motorcycle section
            winner.add(listOfMotorcycles.get(i));
            name = listOfMotorcycles.get(i).getName();
            distanceTraveled = listOfMotorcycles.get(i).getDistanceTraveled();
            avgSpeed = (listOfMotorcycles.get(i).getDistanceTraveled() / 50 );

            System.out.println(name + " belongs to the " + listOfMotorcycles.get(i).getClass() +
                    " and he/she traveled " + distanceTraveled + " km with an average speed of " +
                    avgSpeed + " km/h.");

            // Truck section
            winner.add(listOfTrucks.get(i));
            truckName = listOfTrucks.get(i).getName();
            distanceTraveled = listOfTrucks.get(i).getDistanceTraveled();
            avgSpeed = (listOfTrucks.get(i).getDistanceTraveled() / 50 );

            System.out.println(truckName + " belongs to the " + listOfTrucks.get(i).getClass() +
                    " and he/she traveled " + distanceTraveled + " km with an average speed of " +
                    avgSpeed + " km/h.");


        }
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

        for(int i = 0; i < 10; i++) {
            Car myCar = new Car();
            listOfCars.add(myCar);
//            System.out.println(myCar.getName() + "'s speed is " + myCar.getNormalSpeed() + " km/s");

            motorName = "Motorcycle " + (i + 1);
            Motorcycle myMotorcycle = new Motorcycle(motorName);
            listOfMotorcycles.add(myMotorcycle);
//            System.out.println(myMotorcycle.getName() + "'s speed is " + myMotorcycle.getSpeed() + " km/s");

            int truckName = Truck.driverNames.get(i);
            Truck myTruck = new Truck(truckName);
            listOfTrucks.add(myTruck);

        }
    }
}
