package com.Doctorappointment.dms.mapper;

import com.Doctorappointment.dms.dto.DoctorDto;
import com.Doctorappointment.dms.entity.Doctor;

public class DoctorMapper {
    public static DoctorDto entityToDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        return doctorDto;
    }
    public static Doctor dtoToEntity(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctor.getName());
        return doctor;
    }
}
