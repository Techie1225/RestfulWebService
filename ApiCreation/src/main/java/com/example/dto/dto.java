package com.example.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Student_Details")
public class dto {

@Id
@GeneratedValue
private Integer id;
private String name;
private Float Salary;
private Character ageEligibitity;
private Long phNumber;
}
