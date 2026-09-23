package dronefleet;

public class FastFlightStrategy implements FlightStrategy {

    @Override
    public void executeFlight() {
        System.out.println(
                "Fast flight: priority is given to speed and more battery is consumed.");
    }
}
