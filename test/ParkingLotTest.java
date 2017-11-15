import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void testParkingCarInParkingSlot(){
        ParkingLot parkingLot = new ParkingLot(20);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
    }

    @Test
    public void testShouldReturnFalseWhenSlotIsFull(){
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
        Vehicle anotherVehicle = new Vehicle("TN 01 CG 2847");
        Assert.assertFalse(parkingLot.parkVehicle(anotherVehicle));
    }

    @Test
    public void testShouldReturnTrueWhenSlotIsNotFull(){
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
        Vehicle anotherVehicle = new Vehicle("TN 01 CG 2847");
        Assert.assertTrue(parkingLot.parkVehicle(anotherVehicle));
    }

    @Test
    public void testShouldReturnTrueWhenUnparkingParkedVehicle(){
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
        Assert.assertTrue(parkingLot.unParkVehicle("TN 12 CG 2877"));
    }

    @Test
    public void testShouldReturnTrueWhenUnparkingParkedVehicle1(){
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
        Assert.assertTrue(parkingLot.unParkVehicle("TN 12 CG 2877"));
        Assert.assertTrue(parkingLot.parkVehicle(vehicle));
    }

//    @Test
//    public void testShouldReturnFalseWhenUnparkingUnparkedVehicle(){
//        ParkingLot parkingLot = new ParkingLot(10);
//        Assert.assertFalse(parkingLot.unParkVehicle("TN 12 CG 2877"));
//    }

    @Test
    public void testNotifiableWhenParkingLotIsFull(){
        ParkingLot parkingLot = new ParkingLot(1);
        Subscriber subscriber = new Subscriber();
        parkingLot.addSubscriber(subscriber);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");

        parkingLot.parkVehicle(vehicle);

        Assert.assertTrue(subscriber.isNotifiedFull());
    }

    @Test
    public void testNotifiableWhenParkingLotIsAvailable(){
        ParkingLot parkingLot = new ParkingLot(1);
        Subscriber subscriber = new Subscriber();
        parkingLot.addSubscriber(subscriber);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");

        parkingLot.parkVehicle(vehicle);

        parkingLot.unParkVehicle("TN 12 CG 2877");
        Assert.assertTrue(subscriber.isNotifiedAvailable());

    }




}
