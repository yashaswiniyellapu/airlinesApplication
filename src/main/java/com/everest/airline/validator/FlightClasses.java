package com.everest.airline.validator;

import com.everest.airline.enums.ClassType;
import com.everest.airline.views.FlightClassType;

import java.util.HashMap;

public class FlightClasses {
    private static FlightClassType economicClass;
    private static FlightClassType firstClass;
    private static FlightClassType secondClass;

    public FlightClasses(FlightClassType economicClass, FlightClassType secondClass, FlightClassType firstClass) {
        this.economicClass = economicClass;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
    }
public static FlightClassType flightClassesData(String classType)
{
    HashMap<ClassType,FlightClassType> classes = new HashMap<>();
    classes.put(ClassType.economic,economicClass);
    classes.put(ClassType.second,secondClass);
    classes.put(ClassType.first,firstClass);
    return classes.get(ClassType.valueOf(classType));
}


}
