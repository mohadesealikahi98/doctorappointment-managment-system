package com.Doctorappointment.dms.service;

import com.Doctorappointment.dms.dto.AppointmentDto;
import com.Doctorappointment.dms.entity.Appointment;
import com.Doctorappointment.dms.entity.Doctor;
import com.Doctorappointment.dms.mapper.AppointmentMapper;
import com.Doctorappointment.dms.repository.AppointmentRepository;
import com.Doctorappointment.dms.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public void addAvailableTimes(Long doctorId, LocalDateTime start, LocalDateTime end) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        if (end.isBefore(start)) {
            throw  new IllegalArgumentException("End time must be after start time.");
        }

        LocalDateTime periodStart = start;
        while (periodStart.plusMinutes(30).isBefore(end) || periodStart.plusMinutes(30).isEqual(end)) {
            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setStartTime(periodStart);
            appointment.setEndTime(periodStart.plusMinutes(30));
            appointmentRepository.save(appointment);
            periodStart = periodStart.plusMinutes(30);
        }
    }

    public List<AppointmentDto> viewAppointments(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        List<Appointment> appointmentList = appointmentRepository.findByDoctor(doctor);
        return appointmentList.stream().map(AppointmentMapper::entityToDto).collect(Collectors.toList());
    }

    public void deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        if(appointment.getPatientName() != null) {
            throw new IllegalArgumentException("Cannot delete a taken appointment.");
        }
        appointmentRepository.delete(appointment);
    }

}
