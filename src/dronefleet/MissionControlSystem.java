package dronefleet;

public class MissionControlSystem implements DroneObserver {

    @Override
    public void update(Drone drone) {
        drone.setCurrentMission("RETURN_TO_BASE");
        System.out.println(
                "Mission Control: current mission changed to RETURN_TO_BASE.");
    }
}
