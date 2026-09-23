package dronefleet;

public class DroneFleetDemo {

    public static void main(String[] args) {

        // Factory creates two drones of the same type and one different type.
        Drone lightDrone1 = DroneFactory.createDrone(
                DroneKind.LIGHT, "L-101", new FastFlightStrategy());
        Drone lightDrone2 = DroneFactory.createDrone(
                DroneKind.LIGHT, "L-102", new EcoFlightStrategy());
        Drone cargoDrone = DroneFactory.createDrone(
                DroneKind.CARGO, "C-201", new EcoFlightStrategy());

        lightDrone1.setPosition(10, 20, 50);
        lightDrone2.setPosition(30, 40, 60);
        cargoDrone.setPosition(50, 60, 40);

        lightDrone1.startMission("Deliver package A12");
        lightDrone2.startMission("Deliver package B15");
        cargoDrone.startMission("Deliver cargo C20");

        System.out.println("--- FLYWEIGHT ---");
        System.out.println(
                "The two LightDrones share the same DroneType: "
                + (lightDrone1.getDroneType()
                == lightDrone2.getDroneType()));
        System.out.println(
                "LightDrone and CargoDrone share the same DroneType: "
                + (lightDrone1.getDroneType()
                == cargoDrone.getDroneType()));
        System.out.println(
                "Number of DroneType objects: "
                + DroneTypeFactory.getNumberOfDroneTypes());

        System.out.println("\n--- STRATEGY ---");
        System.out.println("Initial strategy of " + lightDrone1.getId() + ":");
        lightDrone1.executeFlightStrategy();

        System.out.println("Changing strategy at runtime:");
        lightDrone1.setFlightStrategy(new EcoFlightStrategy());
        lightDrone1.executeFlightStrategy();

        // The three independent systems observe the first drone.
        lightDrone1.attach(new NotificationSystem());
        lightDrone1.attach(new MissionControlSystem());
        lightDrone1.attach(new SafetySystem());

        System.out.println("\n--- OBSERVER ---");
        System.out.println("Battery level becomes 10%:");
        lightDrone1.setBatteryLevel(10);

        System.out.println("\n--- FINAL DRONE STATE ---");
        System.out.println("Id: " + lightDrone1.getId());
        System.out.println(
                "Mission: " + lightDrone1.getCurrentMission());
        System.out.println("Status: " + lightDrone1.getStatus());
        System.out.println(
                "Strategy: "
                + lightDrone1.getFlightStrategy()
                        .getClass().getSimpleName());
    }
}
