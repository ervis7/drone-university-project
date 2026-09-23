package dronefleet;

import java.util.ArrayList;
import java.util.List;

/*
 * The Drone class contains the extrinsic state of a real drone.
 */
public abstract class Drone implements DroneObservable {

    private final String id;
    private final DroneType droneType;
    private int x;
    private int y;
    private int altitude;
    private int batteryLevel;
    private String currentMission;
    private DroneStatus status;
    private FlightStrategy flightStrategy;
    private final List<DroneObserver> observers = new ArrayList<>();

    public Drone(String id, DroneType droneType,
            FlightStrategy flightStrategy) {
        this.id = id;
        this.droneType = droneType;
        this.flightStrategy = flightStrategy;
        this.batteryLevel = 100;
        this.currentMission = "NO_MISSION";
        this.status = DroneStatus.READY;
    }

    public abstract String getDroneCategory();

    public void setPosition(int x, int y, int altitude) {
        this.x = x;
        this.y = y;
        this.altitude = altitude;
    }

    public void startMission(String mission) {
        this.currentMission = mission;
        this.status = DroneStatus.IN_MISSION;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException(
                    "Battery level must be between 0 and 100.");
        }

        this.batteryLevel = batteryLevel;

        // The low battery condition is checked only when this value changes.
        if (this.batteryLevel < 15) {
            this.status = DroneStatus.LOW_BATTERY;
            notifyObservers();
        }
    }

    public void setFlightStrategy(FlightStrategy flightStrategy) {
        this.flightStrategy = flightStrategy;
    }

    public void executeFlightStrategy() {
        if (flightStrategy == null) {
            System.out.println("No flight strategy has been selected.");
            return;
        }

        flightStrategy.executeFlight();
    }

    @Override
    public void attach(DroneObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(DroneObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DroneObserver observer : observers) {
            observer.update(this);
        }
    }

    public String getId() {
        return id;
    }

    public DroneType getDroneType() {
        return droneType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getCurrentMission() {
        return currentMission;
    }

    public void setCurrentMission(String currentMission) {
        this.currentMission = currentMission;
    }

    public DroneStatus getStatus() {
        return status;
    }

    public void setStatus(DroneStatus status) {
        this.status = status;
    }

    public FlightStrategy getFlightStrategy() {
        return flightStrategy;
    }
}
