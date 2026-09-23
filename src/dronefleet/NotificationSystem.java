package dronefleet;

public class NotificationSystem implements DroneObserver {

    @Override
    public void update(Drone drone) {
        System.out.println("Low battery - Drone id: " + drone.getId());
    }
}
