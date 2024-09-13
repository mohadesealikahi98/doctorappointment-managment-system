package com.Doctorappointment.dms.mapper;

import com.Doctorappointment.dms.dto.AppointmentDto;
import com.Doctorappointment.dms.entity.Appointment;

public class AppointmentMapper {
    public static AppointmentDto entityToDto(Appointment appointment){
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setStartTime(appointment.getStartTime());
        appointmentDto.setEndTime(appointment.getEndTime());
        appointmentDto.setPatientName(appointment.getPatientName());
        appointmentDto.setPatientPhone(appointment.getPatientPhone());
        appointmentDto.setDoctor(appointment.getDoctor());
        return appointmentDto;
    }
    public static Appointment dtoToEntity(AppointmentDto appointmentDto){
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        appointment.setPatientName(appointmentDto.getPatientName());
        appointment.setPatientPhone(appointmentDto.getPatientPhone());
        appointment.setDoctor(appointmentDto.getDoctor());
        return appointment;
    }
}
