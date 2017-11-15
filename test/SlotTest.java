import org.junit.Test;

import java.util.Vector;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlotTest {
    @Test
    public void testIsFreeWhenNoVehicleParked(){
        Slot slot = new Slot();
        assertTrue(slot.isFree());
    }

    @Test
    public void testIsFreeShouldReturnFalseWhenAssign(){
        Slot slot = new Slot();
        slot.assignVehicle(new Vehicle("TN 01 DF 1233"));
        assertFalse(slot.isFree());
    }

    @Test
    public void testShouldReturnTrueWhenVehichleIsAssigned(){
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("TN 02 AD 1232");
        assertTrue(slot.assignVehicle(vehicle));
    }



}
