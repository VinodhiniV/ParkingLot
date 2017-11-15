import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Slot> slots;
    private List<Subscriber> subscribers = new ArrayList<>();

    private int availableSlots;

    public ParkingLot(int totalSlots) {
        this.slots = new ArrayList<>(totalSlots);
        for(int counter = 0; counter < totalSlots; counter++) {
            this.slots.add(new Slot());
        }
        this.availableSlots = totalSlots;
    }

    public boolean parkVehicle(Vehicle vehicle) {

        if(isFull()){
            return false;
        }
        assignFreeSlot(vehicle);
        this.availableSlots--;

        if(isFull()){
            lotNotifyFullObservers();
        }
        return true;
    }

    private void assignFreeSlot(Vehicle vehicle){
        for (Slot eachSlot:slots) {
            if(eachSlot.isFree()){
                eachSlot.assignVehicle(vehicle);
            }
        }
    }
    private void lotNotifyFullObservers() {
        for (Subscriber subscriber:subscribers) {
            subscriber.lotNotifyFullAction();
        }
    }



    public boolean isFull() {
        return this.availableSlots == 0;
    }

    public boolean unParkVehicle(String plateNumber) {
        for (Slot eachSlot:slots) {
            if(!eachSlot.isFree() && eachSlot.getVehicle().getVehicleNumber() == plateNumber){
               eachSlot.deassign();
               break;
            }
        }
        this.availableSlots++;
        if(slots.size() >= availableSlots){
            lotNotifyAvailableObservers();
        }

        return true;
    }

    private void lotNotifyAvailableObservers() {
        for (Subscriber subscriber:subscribers) {
            subscriber.lotNotifyAvailableAction();
        }
    }


    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }



}
