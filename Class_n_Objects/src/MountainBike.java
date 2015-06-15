/**
 * Created by tua26762 on 6/8/2015.
 */
public class MountainBike extends Bicycle {


    // the MountainBike subclass has
    // one field
    public int seatHeight;

    // the MountainBike subclass has
    // one constructor
    public MountainBike(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    public static void main (String[] args){
        MountainBike bike3 = new MountainBike(1,2,3,4);
        Bicycle bike4 = new Bicycle();

        bike3.printStates();
        bike4.printStates();
    }

    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

}