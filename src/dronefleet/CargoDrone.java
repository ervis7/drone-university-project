package dronefleet;

public class CargoDrone extends Drone {

    public CargoDrone(String id, DroneType droneType,
            FlightStrategy flightStrategy) {
        super(id, droneType, flightStrategy);
    }

    @Override
    public String getDroneCategory() {
        return "CargoDrone";
    }
}
