package com.CRUDoperations.Entity;

import jakarta.persistence.*;


@Entity  // Marks this class as a JPA entity
@Table(name = "Employee")  // Maps the class to the "employee" table in the database
public class Employee {

	
	    
	    @Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge + "]";
	}

		@Id  
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	    private Long id;  
	    
	    @Column(name = "emp_name", nullable = false) 
	    private String empName;  
	    
	    @Column(name = "emp_salary", nullable = false)  
	    private Double empSalary;  
	    
	    @Column(name = "emp_age", nullable = false) 
	    private Integer empAge;  
	    
	    public Employee(Long id, String empName, Double empSalary, Integer empAge) {
			super();
			this.id = id;
			this.empName = empName;
			this.empSalary = empSalary;
			this.empAge = empAge;
		}
	    public Employee() {
	    	
	    }

		// Getters and Setters (essential for JPA and Spring data)
	    
	    public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public String getEmpName() {
	        return empName;
	    }
	    
	    public void setEmpName(String empName) {
	        this.empName = empName;
	    }
	    
	    public Double getEmpSalary() {
	        return empSalary;
	    }
	    
	    public void setEmpSalary(Double empSalary) {
	        this.empSalary = empSalary;
	    }
	    
	    public Integer getEmpAge() {
	        return empAge;
	    }
	    
	    public void setEmpAge(Integer empAge) {
	        this.empAge = empAge;
	    }
	    
	    

}
