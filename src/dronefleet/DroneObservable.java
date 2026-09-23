package dronefleet;

/*
 * Observable interface.
 */
public interface DroneObservable {

    void attach(DroneObserver observer);

    void detach(DroneObserver observer);

    void notifyObservers();
}
