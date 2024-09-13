package com.Doctorappointment.dms.controller;

import com.Doctorappointment.dms.dto.AppointmentDto;
import com.Doctorappointment.dms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDto>> viewOpenAppointments(@RequestParam Long doctorId, @RequestParam LocalDateTime date) {
        List<AppointmentDto> appointmentDtoList = patientService.viewOpenAppointments(doctorId, date);
        return new ResponseEntity<List<AppointmentDto>>(appointmentDtoList, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<AppointmentDto> bookAppointment(@RequestParam Long appointmentId, @RequestParam String patientName, @RequestParam String patientPhone) {
        AppointmentDto appointmentDto = patientService.bookAppointment(appointmentId, patientName, patientPhone);
        return new ResponseEntity<AppointmentDto>(appointmentDto,HttpStatus.OK);
    }

}
