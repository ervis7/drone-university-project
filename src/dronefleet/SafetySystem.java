package dronefleet;

public class SafetySystem implements DroneObserver {

    @Override
    public void update(Drone drone) {
        drone.setFlightStrategy(new SafeFlightStrategy());
        drone.setStatus(DroneStatus.RETURNING);
        System.out.println(
                "Safety System: SafeFlightStrategy selected and status changed to RETURNING.");
    }
}
