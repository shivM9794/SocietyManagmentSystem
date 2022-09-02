package app.societymanagementsystem.View.HelperClass;

public class EventHelperClass {

    int image;
    String eventName;

    public EventHelperClass(int image, String eventName) {
        this.image = image;
        this.eventName = eventName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
