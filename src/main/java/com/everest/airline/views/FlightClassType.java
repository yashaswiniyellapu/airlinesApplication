package com.everest.airline.views;

<<<<<<< HEAD:src/main/java/com/everest/airline/views/FlightClassData.java
public interface FlightClassData {
    static FlightClassData classInstance = null;
||||||| da26066 (Had public constructor for flightClasses):src/main/java/com/everest/airline/views/FlightClassData.java
public interface FlightClassData {
=======
public interface FlightClassType {
>>>>>>> parent of da26066 (Had public constructor for flightClasses):src/main/java/com/everest/airline/views/FlightClassType.java

    double getFare();

    double getTotalFare();

    String getUpdatedData(Long flightNumber, int passengerCount);

    boolean validateData(int passengerCount);
<<<<<<< HEAD:src/main/java/com/everest/airline/views/FlightClassData.java

    int getSeatsLeft();

    void setSeatsLeft(int seatsLeft);

    int getCapacity();

    void setCapacity(int capacity);

    static FlightClassData getInstance() {
        return classInstance;
    }
||||||| da26066 (Had public constructor for flightClasses):src/main/java/com/everest/airline/views/FlightClassData.java

    int getSeatsLeft();

    void setSeatsLeft(int seatsLeft);

    int getCapacity();

    void setCapacity(int capacity);
=======
>>>>>>> parent of da26066 (Had public constructor for flightClasses):src/main/java/com/everest/airline/views/FlightClassType.java
}
