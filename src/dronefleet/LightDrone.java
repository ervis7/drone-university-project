package dronefleet;

public class LightDrone extends Drone {

    public LightDrone(String id, DroneType droneType,
            FlightStrategy flightStrategy) {
        super(id, droneType, flightStrategy);
    }

    @Override
    public String getDroneCategory() {
        return "LightDrone";
    }
}
