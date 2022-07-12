package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
//@Table(name="Student_Details")
@AllArgsConstructor
@NoArgsConstructor
public class dto {

//@Id
//@GeneratedValue
	
private Integer id;
private String name;
private Float Salary;
private Character ageEligibitity;
private Long phNumber;
}
