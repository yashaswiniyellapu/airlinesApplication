package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.model.Flight;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.FlightClassType;
import com.everest.airline.views.SecondClass;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SearchService {

    private FlightClassType flightClassType;
   private double totalFare;
   private double totalClassFare;


//    public List<Flight> flight(String source, String destination, String date, String passengersCount, String classType) throws Exception {
//        List<String[]> fileData;
//        List<Flight> flightList = new ArrayList<>();
//        Flight flight;
//        DirectoryReader fileHandler = new DirectoryReader(source, destination, date);
//        fileData = fileHandler.getFileData(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"));
//        for (String[] name : fileData) {
//            long flightNumber = Long.parseLong(name[0]);
//            String from = name[1];
//            String to = name[2];
//            LocalDate departureDate = LocalDate.parse(name[3]);
//            LocalTime departureTime = LocalTime.parse(name[4]);
//            LocalTime arrivalTime = LocalTime.parse(name[5]);
//            int availableSeats = Integer.parseInt(name[6]);
//            int economicClassSeats = Integer.parseInt(name[7]);
//            int secondClassSeats = Integer.parseInt(name[8]);
//            int firstClassSeats = Integer.parseInt(name[9]);
//            int economicCapacity = Integer.parseInt(name[10]);
//            int numberOfPassengers = Integer.parseInt(passengersCount);
//            int firstClassCapacity = Integer.parseInt(name[11]);
//            int secondClassCapacity = Integer.parseInt(name[12]);
//            economicClass = new FlightDataAssign(economicClassSeats, secondClassSeats, firstClassSeats, economicCapacity, secondClassCapacity, firstClassCapacity);
//            System.out.println(economicClass.getEconomicClassData().getCapacity()+" capacity "+economicCapacity);
//
//           flight = new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats,economicClass );
//
//            filter= new FlightClassFilter(classType);
//                flightClassType = filter.filterClass(flight);
//                if(flightClassType.validateData(numberOfPassengers))
//                {
//                    flightList.add(flight);
//                    totalFare=flightClassType.getTotalFare()*numberOfPassengers;
//                    totalClassFare = flightClassType.getTotalFare();
//
//                }
//                else
//                {
//                    throw new IllegalStateException();
//                }
//
//            }
//        return flightList;
//    }

    public double getTotalFare()
    {
        return totalFare;

    }
    public double getFare()
    {
        return totalClassFare;
    }

    public List<Flight> flightObjectTest(String source, String destination, String date,int passengersCount, String classType)
    {
    return DataReader.getFilesData().stream().map(Map.Entry::getValue).filter(strings-> strings[1].equalsIgnoreCase(source)&&
            strings[2].equalsIgnoreCase(destination)&& strings[3].equalsIgnoreCase(date)).map(data->
          new Flight(Long.parseLong(data[0]),data[1],data[2],LocalDate.parse(data[3]),LocalTime.parse(data[4]),LocalTime.parse(data[5]),
                    new EconomicClass(Integer.parseInt(data[10]),Integer.parseInt(data[7]),LocalDate.parse(data[3]),passengersCount),
                    new SecondClass(Integer.parseInt(data[11]),Integer.parseInt(data[8]),LocalDate.parse(data[3]),passengersCount),
                            new FirstClass(Integer.parseInt(data[12]),Integer.parseInt(data[9]),LocalDate.parse(data[3]),passengersCount))).collect(Collectors.toList());
    }

}

  //  public Flight(long number, String source, String destination, LocalDate departureDate,LocalTime departureTime,LocalTime arrivalTime, FlightClassType economicClass, FlightClassType secondClass, FlightClassType firstClass) {
