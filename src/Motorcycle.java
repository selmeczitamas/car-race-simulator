public class Motorcycle extends Main {

//    Motorcycle // speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
//    static nameNumber // The number of the instance created. Used for its name.
//            name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
//    distanceTraveled
//    moveForAnHour()


    private String name;
    private int speed;
    private int distanceTraveled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public Motorcycle(String name) {
        this.name = name;
        this.speed = 0;
        this.distanceTraveled = 0;

    }

    public static void moveForAnHour(boolean isRaining) {
        countingMotorHours++;
        int distance;
        if (isRaining) {
            System.out.println("");
            System.out.println("HOUR " + countingMotorHours + " for Motorcycles");
            System.out.println("It is raining at the moment!");
            System.out.println("");
            for (Motorcycle myMotor: Main.listOfMotorcycles) {
                myMotor.setSpeed(Main.randInt(50, 95));
                System.out.println("The average speed for " + myMotor.getName() + " is " + myMotor.getSpeed());
                distance = myMotor.getDistanceTraveled() + myMotor.getSpeed();
                myMotor.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        } else {
            System.out.println("");
            System.out.println("HOUR " + countingMotorHours + " for Motorcycles");
            System.out.println("The weather is LUCKY sunny right now!");
            System.out.println("");
            for (Motorcycle myMotor: Main.listOfMotorcycles) {
                myMotor.setSpeed(100);
                System.out.println("The average speed for " + myMotor.getName() + " is " + myMotor.getSpeed());
                distance = myMotor.getDistanceTraveled() + myMotor.getSpeed();
                myMotor.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        }
    }
}
