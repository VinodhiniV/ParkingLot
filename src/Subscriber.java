public class Subscriber {
    private boolean isNotifiedFull = false;
    private boolean isNotifiedAvailable = false;

    public void lotNotifyFullAction(){
        this.isNotifiedFull = true;
    }

    public boolean isNotifiedFull() {
        return isNotifiedFull;
    }

    public void lotNotifyAvailableAction(){
        this.isNotifiedAvailable = true;
    }

    public boolean isNotifiedAvailable() {
        return isNotifiedAvailable;
    }
}
