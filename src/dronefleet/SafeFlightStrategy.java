package dronefleet;

public class SafeFlightStrategy implements FlightStrategy {

    @Override
    public void executeFlight() {
        System.out.println(
                "Safe flight: priority is given to safety.");
    }
}
