import java.lang.reflect.Array;
import java.util.*;

public class Car extends Main {

//    Car
//    // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed.
//    static setSpeedLimit(int limit) // Call this from the Main class!
//    normalSpeed // the normal speed of the car.
//    Set to a random number in the constructor between 80-110km/h.
//            name // Make a list from the words here:
//            http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
//    distanceTraveled // holds the current distance traveled.
//    moveForAnHour() // The vehicle travels for an hour.
//    It increases the distance traveled. Call this from the main class only!


    private ArrayList<String> carNames = new ArrayList<>(Arrays.asList("Surge",
                                                                        "Barrage",
                                                                        "Harmony",
                                                                        "Sanctuary",
                                                                        "Reflect",
                                                                        "Lightning",
                                                                        "Viper",
                                                                        "Guardian",
                                                                        "Eos",
                                                                        "Virtue",
                                                                        "Liberty",
                                                                        "Behemoth",
                                                                        "Legend",
                                                                        "Conqueror",
                                                                        "Motive",
                                                                        "Olympian",
                                                                        "Buffalo",
                                                                        "Sanctuary",
                                                                        "Capital",
                                                                        "Millenium"));

    private String name;
    private int normalSpeed;
    private int distanceTraveled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public void setNormalSpeed(int normalSpeed) {
        this.normalSpeed = normalSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Car() {
        Random randomizer = new Random();
        String firstName = this.carNames.get(randomizer.nextInt(this.carNames.size()));
        String secondName = this.carNames.get(randomizer.nextInt(this.carNames.size()));
        this.name = firstName + " " + secondName;
        this.normalSpeed = 0;
        this.distanceTraveled = 0;
    }

    public void setSpeedLimit(int limit) {
        this.normalSpeed = limit;
    }

    public void setRandomNormalSpeed() {
        this.normalSpeed = Main.randInt(80, 110);
    }

    public static void moveForAnHour(boolean isRaining) {
        int distance;
        if (isRaining) {
            System.out.println("");
            System.out.println("It is raining at the moment!");
            System.out.println("");
            for (Car myCar: listOfCars) {
                myCar.setSpeedLimit(70);
                System.out.println("The current speed for " + myCar.getName() + " is " + myCar.getNormalSpeed());
                distance = myCar.distanceTraveled + myCar.normalSpeed;
                myCar.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        } else {
            System.out.println("");
            System.out.println("The weather is LUCKY sunny right now!");
            System.out.println("");
            for (Car myCar: listOfCars) {
                myCar.setNormalSpeed(Main.randInt(80, 110));
                System.out.println("The current speed for " + myCar.getName() + " is " + myCar.getNormalSpeed());
                distance = myCar.distanceTraveled + myCar.normalSpeed;
                myCar.setDistanceTraveled(distance);
                System.out.println("And so far it's distance is: " + distance + " km.");
            }
        }
    }
}
