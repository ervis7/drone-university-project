package dronefleet;

/*
 * Flyweight class.
 * It stores the intrinsic state shared by drones of the same type.
 */
public class DroneType {

    private final String modelName;
    private final double maxSpeed;
    private final double maxPayload;
    private final int batteryCapacity;
    private final String sensorPackage;
    private final String iconImagePath;
    private final String engineSoundPath;

    public DroneType(String modelName, double maxSpeed, double maxPayload,
            int batteryCapacity, String sensorPackage,
            String iconImagePath, String engineSoundPath) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
        this.maxPayload = maxPayload;
        this.batteryCapacity = batteryCapacity;
        this.sensorPackage = sensorPackage;
        this.iconImagePath = iconImagePath;
        this.engineSoundPath = engineSoundPath;
    }

    public String getModelName() {
        return modelName;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getSensorPackage() {
        return sensorPackage;
    }

    public String getIconImagePath() {
        return iconImagePath;
    }

    public String getEngineSoundPath() {
        return engineSoundPath;
    }
}
