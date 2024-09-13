package com.Doctorappointment.dms.repository;

import com.Doctorappointment.dms.entity.Appointment;
import com.Doctorappointment.dms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorAndStartTimeBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findByDoctorAndStartTime( Doctor doctor,LocalDateTime start);

}
