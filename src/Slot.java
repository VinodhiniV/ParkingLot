public class Slot {
    private Vehicle vehicle;
    private boolean isFree = true;
    public boolean isFree() {
        return isFree;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree()) {
            this.vehicle = vehicle;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean deassign() {
        vehicle = null;
        isFree = true;
        return true;
    }
}
