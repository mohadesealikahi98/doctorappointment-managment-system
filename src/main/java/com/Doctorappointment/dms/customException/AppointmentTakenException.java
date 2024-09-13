package com.Doctorappointment.dms.customException;

public class AppointmentTakenException extends RuntimeException{
    public AppointmentTakenException(String message) {
        super(message);
    }
}
