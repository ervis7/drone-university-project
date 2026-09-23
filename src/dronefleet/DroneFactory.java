package dronefleet;

/*
 * Factory for creating real drones.
 * The client does not create the concrete drone classes directly.
 */
public class DroneFactory {

    private DroneFactory() {
    }

    public static Drone createDrone(DroneKind kind, String id,
            FlightStrategy flightStrategy) {
        DroneType droneType = DroneTypeFactory.getDroneType(kind);

        switch (kind) {
            case LIGHT:
                return new LightDrone(id, droneType, flightStrategy);
            case CARGO:
                return new CargoDrone(id, droneType, flightStrategy);
            case SURVEILLANCE:
                return new SurveillanceDrone(id, droneType, flightStrategy);
            default:
                throw new IllegalArgumentException("Unknown drone type: " + kind);
        }
    }
}
