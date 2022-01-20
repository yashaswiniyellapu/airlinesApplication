package com.everest.airline.exceptions;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException()
    {
        super("File Not found in directory, Please check and update file path ");
    }
}
