import javax.xml.transform.Result;

public class Attendent extends Subscriber {
    private final boolean isFull;
    private ParkingLot parkingLot;

    public Attendent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.isFull = false;
    }

    public boolean park(Vehicle vehicle) {
       return parkingLot.parkVehicle(vehicle);
    }

}
