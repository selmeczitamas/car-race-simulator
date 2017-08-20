import java.util.ArrayList;

public class Truck extends Main {

//    Truck // speed: 100km/h. 5% chance of breaking down for 2 hours.
//            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
//            breakdownTurnsLeft // holds how long its still broken down.
//    distanceTraveled
//    moveForAnHour()


    private int name;
    private int speed;
    private int distanceTraveled;
    private static boolean timeForRest;

    {
        timeForRest = false;
    }

    public static ArrayList<Integer> driverNames;


    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Truck(int name) {
        this.name = name;
        this.speed = 0;
        this.distanceTraveled = 0;
    }

    public static void createNames() {
        driverNames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            driverNames.add(Main.randInt(0,1000));
        }
    }

    public static void moveForAnHour() {
        countingTruckHours++;
        int distance;
        int chanceOfStop;

        if (timeForRest) {
            System.out.println("");
            System.out.println("HOUR " + countingTruckHours + " for Trucks");
            System.out.println("OMG!! It is resting time for the trucks!");
            System.out.println("");
            for (Truck myTruck: Main.listOfTrucks) {
                myTruck.setSpeed(0);
                System.out.println("The average speed for " + myTruck.getName() + " is " + myTruck.getSpeed());
                distance = myTruck.getDistanceTraveled() + myTruck.getSpeed();
                myTruck.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
            timeForRest = false;

        } else {
            chanceOfStop = Main.randInt(1, 100);
            if (chanceOfStop < 6) {
                System.out.println("");
                System.out.println("HOUR " + countingTruckHours + " for Trucks");
                System.out.println("OMG!! It is resting time for the trucks!");
                System.out.println("");
                for (Truck myTruck: Main.listOfTrucks) {
                    myTruck.setSpeed(0);
                    System.out.println("The average speed for " + myTruck.getName() + " is " + myTruck.getSpeed());
                    distance = myTruck.getDistanceTraveled() + myTruck.getSpeed();
                    myTruck.setDistanceTraveled(distance);
                    System.out.println("And so far it's distance is: " + distance + " km.");
                }
                timeForRest = true;

            } else {
                System.out.println("");
                System.out.println("HOUR " + countingTruckHours + " for Trucks");
                System.out.println("Who cares about the weather?");
                System.out.println("");
                for (Truck myTruck: Main.listOfTrucks) {
                    myTruck.setSpeed(100);
                    System.out.println("The average speed for " + myTruck.getName() + " is " + myTruck.getSpeed());
                    distance = myTruck.getDistanceTraveled() + myTruck.getSpeed();
                    myTruck.setDistanceTraveled(distance);
                    System.out.println("And so far it's distance is: " + distance + " km.");
                }
            }
        }
    }
}
