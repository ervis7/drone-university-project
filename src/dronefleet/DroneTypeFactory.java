package dronefleet;

import java.util.HashMap;
import java.util.Map;

/*
 * Flyweight Factory.
 * Only one DroneType object is created for each DroneKind.
 */
public class DroneTypeFactory {

    private static final Map<DroneKind, DroneType> droneTypes = new HashMap<>();

    private DroneTypeFactory() {
    }

    public static DroneType getDroneType(DroneKind kind) {
        DroneType droneType = droneTypes.get(kind);

        if (droneType == null) {
            droneType = createDroneType(kind);
            droneTypes.put(kind, droneType);
        }

        return droneType;
    }

    private static DroneType createDroneType(DroneKind kind) {
        switch (kind) {
            case LIGHT:
                return new DroneType(
                        "LightDrone LD-100",
                        120.0,
                        5.0,
                        5000,
                        "Basic GPS sensors",
                        "images/light-drone.png",
                        "sounds/light-engine.wav");
            case CARGO:
                return new DroneType(
                        "CargoDrone CD-200",
                        80.0,
                        25.0,
                        10000,
                        "GPS and weight sensors",
                        "images/cargo-drone.png",
                        "sounds/cargo-engine.wav");
            case SURVEILLANCE:
                return new DroneType(
                        "SurveillanceDrone SD-300",
                        100.0,
                        2.0,
                        8000,
                        "Camera, thermal and night vision sensors",
                        "images/surveillance-drone.png",
                        "sounds/surveillance-engine.wav");
            default:
                throw new IllegalArgumentException("Unknown drone type: " + kind);
        }
    }

    public static int getNumberOfDroneTypes() {
        return droneTypes.size();
    }
}
