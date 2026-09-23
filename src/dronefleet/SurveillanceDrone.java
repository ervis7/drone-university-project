package dronefleet;

public class SurveillanceDrone extends Drone {

    public SurveillanceDrone(String id, DroneType droneType,
            FlightStrategy flightStrategy) {
        super(id, droneType, flightStrategy);
    }

    @Override
    public String getDroneCategory() {
        return "SurveillanceDrone";
    }
}
