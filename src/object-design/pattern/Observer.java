import java.util.List;
import java.util.ArrayList;


// Subject class
class Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int st) {
        state = st;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for(Observer ob: observers) {
            ob.update();
        }
    }
}

// Observer class
public abstract class Observer {
    public abstract void update();
    protected Subject subject;
}

public class IntegerObserver extends Observer {
    public IntegerObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("subject integer value:" + subject.getState());
    }
}
