package org.example.airport;
import java.util.logging.Logger;


public class TrafficController {
    private RunwayRegistry runwayRegistry;
    private WeatherService weatherService;

    Logger logger = Logger.getLogger(getClass().getName());

    public static class NoAvailableRunwayException extends RuntimeException {
        public NoAvailableRunwayException(String message) {
                super(message);
        }
    }

    public static class PoorWeatherConditionsException extends RuntimeException {
        public PoorWeatherConditionsException(String message) {
            super(message);
        }
    }

    public TrafficController(RunwayRegistry registry, WeatherService weather) {
        this.runwayRegistry = registry;
        this.weatherService = weather;
    }

    public void addNewRunway(Runway runway) {
        runwayRegistry.addRunway(runway);    
    }

    public void removeRunway(int runwayId) {
        runwayRegistry.removeRunway(runwayId);    
    }

    public void newPlaneArriving() throws NoAvailableRunwayException, PoorWeatherConditionsException {
        if(!weatherService.isSafeToLand()) {
            throw new PoorWeatherConditionsException("Weather conditions are not safe for landindg!");
        }
        
        Runway runway = runwayRegistry.getAvailableRunway();
        if (runway == null) {
            throw new NoAvailableRunwayException("No runway is available!");
        }
        
        logger.info("Plane landed safely on runway " + runway.getId());
    }

}
