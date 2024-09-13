package com.Doctorappointment.dms.dto;

import com.Doctorappointment.dms.entity.Doctor;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String patientName;
    private String patientPhone;
    private Doctor doctor;
}
