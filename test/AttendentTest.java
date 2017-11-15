import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AttendentTest {
    @Test
    public void attendentShouldParkTheVehicleInFirstFreeParkingLot(){
        ParkingLot parkingLot = new ParkingLot(2);
        Attendent attendent = new Attendent(parkingLot);
        assertTrue(attendent.park(new Vehicle("TN 12 DC213")));
        assertTrue(attendent.park(new Vehicle("TN 12 DC223413")));
        assertFalse(attendent.park(new Vehicle("TN 12 DC21erew3")));
    }

    @Test
    public void testSendNotificationToAttendentWhenHeSubscribesToParkingLotFullOrAvailable(){
        ParkingLot parkingLot = new ParkingLot(1);
        Subscriber subscriber = new Attendent(parkingLot);
        parkingLot.addSubscriber(subscriber);
        Vehicle vehicle = new Vehicle("TN 12 CG 2877");

        parkingLot.parkVehicle(vehicle);

        parkingLot.unParkVehicle("TN 12 CG 2877");
        Assert.assertTrue(subscriber.isNotifiedAvailable());
    }
}
