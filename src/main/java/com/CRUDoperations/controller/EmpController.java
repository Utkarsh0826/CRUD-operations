package com.CRUDoperations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.CRUDoperations.Entity.Employee;
import com.CRUDoperations.Repo.EmpRepo;

@RestController
@RequestMapping("/")
public class EmpController {
	
	@Autowired
	EmpRepo empRepo;
	
	@PostMapping("add")
	public String createNew(@RequestBody Employee employee) {
		 empRepo.save(employee);
		return "success";
	}
	
	@GetMapping("show")
	public List<Employee> getall() {
		 
		return empRepo.findAll();
	}
	
	@GetMapping("show/{id}")
	public ResponseEntity<Employee> getByid(@PathVariable Long id) {
Optional<Employee> employee = empRepo.findById(id);  // Get the entity by ID
        
        if (employee.isPresent()) {
            // If the entity is found, return it with a 200 OK response
            return ResponseEntity.ok(employee.get());
        } else {
            // If not found, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
	}
	
	@PutMapping("{id}")  // HTTP PUT request for updating
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        // Find the existing employee by ID
        Optional<Employee> employ = empRepo.findById(id);

        if (employ.isPresent()) {
            Employee employe = employ.get();

            // Update the fields of the existing employee
            employe.setEmpName(updatedEmployee.getEmpName());
            employe.setEmpSalary(updatedEmployee.getEmpSalary());
            employe.setEmpAge(updatedEmployee.getEmpAge());

            // Save the updated employee back to the repository
            Employee savedEmployee = empRepo.save(employe);

            // Return the updated employee with a 200 OK response
            return ResponseEntity.ok(savedEmployee);
        } else {
            // If not found, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
	}
	
	@DeleteMapping("{id}")  // HTTP DELETE request for deleting by ID
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = empRepo.findById(id);  // Find by ID

        if (employee.isPresent()) {
            empRepo.deleteById(id);  // Delete the entity by ID
            return ResponseEntity.noContent().build();  // 204 No Content indicates successful deletion
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found if entity doesn't exist
        }
    }
}
