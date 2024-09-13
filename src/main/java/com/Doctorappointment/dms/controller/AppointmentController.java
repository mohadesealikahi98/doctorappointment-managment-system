package com.Doctorappointment.dms.controller;

import com.Doctorappointment.dms.dto.AppointmentDto;
import com.Doctorappointment.dms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<List<AppointmentDto>> addAvailableTimes(@RequestParam Long doctorId, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        List<AppointmentDto> appointmentDtoList = appointmentService.addAvailableTimes(doctorId, start, end);
        return new ResponseEntity<List<AppointmentDto>>(appointmentDtoList, HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity<List<AppointmentDto>> viewAppointments(@RequestParam Long doctorId) {
        List<AppointmentDto> appointmentDtoList = appointmentService.viewAppointments(doctorId);
        return new ResponseEntity<List<AppointmentDto>>(appointmentDtoList, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("entity deleted", HttpStatus.OK);
    }

}
