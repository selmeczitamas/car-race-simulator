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

    public static void moveForAnHour(boolean isRaining) {
        int distance;
        if (isRaining) {
            System.out.println("");
            System.out.println("It is raining at the moment!");
            System.out.println("");
            for (Truck myTruck : Main.listOfTrucks) {
                myTruck.setSpeed(Main.randInt(50, 95));
                System.out.println("The current speed for " + myTruck.getName() + " is " + myTruck.getSpeed());
                distance = myTruck.getDistanceTraveled() + myTruck.getSpeed();
                myTruck.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        } else {
            System.out.println("");
            System.out.println("The weather is LUCKY sunny right now!");
            System.out.println("");
            for (Truck myTruck : Main.listOfTrucks) {
                myTruck.setSpeed(100);
                System.out.println("The current speed for " + myTruck.getName() + " is " + myTruck.getSpeed());
                distance = myTruck.getDistanceTraveled() + myTruck.getSpeed();
                myTruck.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        }
    }
}
