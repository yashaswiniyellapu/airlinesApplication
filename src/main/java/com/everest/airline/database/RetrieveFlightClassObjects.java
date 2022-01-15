package com.everest.airline.database;

import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.FlightClassData;
import com.everest.airline.views.SecondClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

enum FlightClassType {
    economic, first, second;
}

public class RetrieveFlightClassObjects {
    private Set<Map.Entry<String, FlightClassData>> flightClassInstances() {
        HashMap<String, FlightClassData> instances = new HashMap<>();
        instances.put("economic", new EconomicClass());
        instances.put("first", new FirstClass());
        instances.put("second", new SecondClass());
        return instances.entrySet();
    }

    public FlightClassData getFlightClassObjects(String classType) {
        return Stream.of(FlightClassType.values()).filter(values -> values.toString().equalsIgnoreCase(classType)).
                map(value -> flightClassInstances().stream().
                        filter(instance -> instance.getKey().equalsIgnoreCase(value.toString())).
                        map(Map.Entry::getValue).findFirst().orElse(null)).
                findFirst().orElse(null);
    }

}


