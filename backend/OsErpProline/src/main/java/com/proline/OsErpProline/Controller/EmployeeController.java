package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.EmployeeRepository;

import com.proline.OsErpProline.Repository.SocialMediaRepository;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Socialmedia;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${cors.address}")
public class EmployeeController {
    private final EmployeeRepository repository;
    private final SocialMediaRepository socialMediaRepository;

    public EmployeeController(EmployeeRepository repository,SocialMediaRepository socialMediaRepository) {
        this.repository = repository;
        this.socialMediaRepository = socialMediaRepository;
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        if (newEmployee.getContactsById() != null)
            newEmployee.getContactsById().forEach(o->o.setEmployeeByEmployeeId(newEmployee));
        return repository.save(newEmployee);
    }

    @PostMapping("/employees/socialmedia")
    Socialmedia newSocialmedia(@RequestBody Socialmedia newSocialmedia){
        return socialMediaRepository.save(newSocialmedia);
    }

    @GetMapping("/employees/socialmedia")
    List<Socialmedia> getAllSocialmedia(@RequestBody Socialmedia newSocialmedia){
        return socialMediaRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setSurname(newEmployee.getSurname());
                    employee.setBio(newEmployee.getBio());
                    employee.setRol(newEmployee.getRol());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}