package dronefleet;

public class EcoFlightStrategy implements FlightStrategy {

    @Override
    public void executeFlight() {
        System.out.println(
                "Eco flight: priority is given to saving battery.");
    }
}
