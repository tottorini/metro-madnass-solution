package org.example.airport;

public class ExternalWeatherAPI implements WeatherService {
    public boolean isSafeToLand() {
        double fogProbability = fogAssesment();
        double rainProbability = rainAssesment();

        final double MAX_SAFE_PROBABILITY = 0.75;
        
        return (fogProbability < MAX_SAFE_PROBABILITY && rainProbability < MAX_SAFE_PROBABILITY);         
    }

    private double fogAssesment() {
        return Math.round(Math.random() * 100.0) / 100.0;
    }

    private double rainAssesment() {
        return Math.round(Math.random() * 100.0) / 100.0;
    }
}
