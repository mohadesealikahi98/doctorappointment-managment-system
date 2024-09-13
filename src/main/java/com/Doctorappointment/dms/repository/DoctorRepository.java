package com.Doctorappointment.dms.repository;

import com.Doctorappointment.dms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
