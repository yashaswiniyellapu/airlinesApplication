package com.everest.airline.database;

import com.everest.airline.exceptions.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryReader {

private DirectoryReader(){}
    public static Set<Map.Entry<Path, String>> ListOfFiles() {
        String directoryLocation = "/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData";
        try (Stream<Path> listOfFiles=Files.list(Paths.get(directoryLocation))){
            return listOfFiles.collect(Collectors.toMap(Path::getFileName, Path::toString)).entrySet();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

}
