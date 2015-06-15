/**
 * Created by tua26762 on 6/8/2015.
 */
public class Bicycle {

    // the Bicycle class has
    // three fields
    private int cadence;
    private int gear;
    private int speed;

    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    public Bicycle(){
        gear = 1;
        cadence = 0;
        speed = 0;
    }

    public Bicycle seeFastest(Bicycle bike_a, Bicycle bike_b){
        Bicycle fastest;

        fastest = bike_a;

        return fastest;

    }


    public static void main (String[] args){

        Bicycle bike1 = new Bicycle(1,2,3);
        bike1.printStates();
        System.out.println(" SPEED UP");
        bike1.setCadence(4);
        bike1.speedUp(7);
        bike1.setGear(4);
        bike1.printStates();

        Bicycle bike2 = new Bicycle();
        bike2.printStates();


        int y = bike1.getSpeed();

        System.out.println(y);

        double MPH = calculateMPH(500,10);
        System.out.println(MPH);


        bike1.draw(y);
        bike1.draw(MPH);


        Bicycle bike3 = new Bicycle().seeFastest(bike1,bike2);
        bike1.printStates();
        bike3.printStates();




    }


    // the Bicycle class has
    // four methods
    public int getCadence() {
        return cadence;
    }
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public int getGear() {
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

    public void printStates() {
        System.out.println("cadence=" + cadence + " gear="+ gear + " speed="+ speed);
    }

    public static double calculateMPH(int distance, int time) {
       double speed = distance / time;
        return speed;
    }

    public void draw(int i){
        System.out.print("INT");

    }
    public void draw(double x){
        System.out.print("DOUBLE");
    }



}