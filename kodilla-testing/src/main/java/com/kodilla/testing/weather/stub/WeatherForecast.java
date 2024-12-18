package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double temperature : temperatures.getTemperatures().values()) {
            sum += temperature;
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedian() {
        double median;
        List<Double> temperaturesValues = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperaturesValues);
        int middle = temperaturesValues.size() / 2;

        if (temperaturesValues.size() % 2 != 0) {
            median = temperaturesValues.get(middle);
        }
        else {
            median = temperaturesValues.get(middle - 1) + temperaturesValues.get(middle) / 2;
        }
        return median;
    }
}