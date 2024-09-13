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
public class PatientService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<AppointmentDto> viewOpenAppointments(Long doctorId, LocalDateTime date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        List<Appointment> appointmentList = appointmentRepository.findByDoctorAndStartTime(doctor, date);
        return appointmentList.stream().map(AppointmentMapper::entityToDto).collect(Collectors.toList());
    }

    public AppointmentDto bookAppointment(Long appointmentId, String patientName, String patientPhone) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        if(appointment.getPatientName() != null) {
            throw new IllegalArgumentException("Appointment is already taken.");
        }

        appointment.setPatientName(patientName);
        appointment.setPatientPhone(patientPhone);
        appointmentRepository.save(appointment);
        return AppointmentMapper.entityToDto(appointment);
    }

}
