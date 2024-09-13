package com.Doctorappointment.dms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
