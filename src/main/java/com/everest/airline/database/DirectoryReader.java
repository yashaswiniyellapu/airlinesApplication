package com.everest.airline.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DirectoryReader {

private DirectoryReader(){}
    public static Set<Map.Entry<Path, String>> getListOfFiles() {
        String directoryLocation = "/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData";
        try {
            return Files.list(Paths.get(directoryLocation)).collect(Collectors.toMap(Path::getFileName, e-> e.toString())).entrySet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
