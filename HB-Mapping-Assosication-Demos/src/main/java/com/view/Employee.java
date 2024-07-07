package com.view;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="employee")
public class Employee extends Person {
	
 @DecimalMin(value = "0.0", inclusive = false, message = "Height must be greater than 0")
	
  float salary;
  
  
  @NotNull(message = "Designation cannot be null")
  @Size(min = 3, max = 50, message ="Designation must be between 3 and 50 characters")

  String designation;
  
  
  @Digits(integer=10,fraction=0,message="Invalid doj.Maximum valid number is 10")
  String doj;
      public Employee() {
	  super();
   }
public Employee(String name,float salary, String designation, String doj) {
	super(name);
	this.salary = salary;
	this.designation = designation;
	this.doj = doj;
	this.name=name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}

}