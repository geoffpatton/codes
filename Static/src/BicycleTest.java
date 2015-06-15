/**
 * Created by tua26762 on 6/10/2015.
 */
public class BicycleTest {

    private int cadence;
    private int gear;
    private int speed;

    private int id;



    static final int TOTAL_BIKES = 10;


    public static int numberOfBicycles = initializeClassVariable();
    private static int initializeClassVariable() {

        numberOfBicycles = 0;
        return numberOfBicycles;

    }



    public BicycleTest(int startCadence,
                   int startSpeed,
                   int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

        id = ++numberOfBicycles;
    }



    public static void main(String[] args){
        BicycleTest bike1 = new BicycleTest(1,1,1);
        BicycleTest bike2 = new BicycleTest(2,2,2);
        bike2.printStats();
        int x = BicycleTest.getNumberOfBicycles();
        System.out.println(x);

    }


    public int getID() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public int getGear(){
        return gear;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public int getSpeed() {
        return speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public void printStats(){
        System.out.println(this.getID());
    }




}