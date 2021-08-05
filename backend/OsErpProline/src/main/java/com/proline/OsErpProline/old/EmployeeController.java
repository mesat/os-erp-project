/*package com.proline.OsErpProline.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.proline.OsErpProline.entity.Contact;
import com.proline.OsErpProline.entity.EmployeeHasTeam;
import com.proline.OsErpProline.entity.Leader;
import com.proline.OsErpProline.entity.Socialmedia;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public static void main(String[] args) {
        com.proline.OsErpProline.entity.Employee employee = new com.proline.OsErpProline.entity.Employee();
        employee.setName("Ömer");
        Contact contact = new Contact();
        contact.setLink("https://www.link1");
        Socialmedia socialmedia = new Socialmedia();
        socialmedia.setPlatform("Facebook");
        contact.setSocialmediaBySocialmediaId(socialmedia);
        EmployeeHasTeam hasTeam = new EmployeeHasTeam();
        Leader leader = new Leader();
        List<EmployeeHasTeam> ehtList = new ArrayList<>();
        ehtList.add(hasTeam);
        employee.setEmployeeHasTeamsById(ehtList);
        employee.setContacts(Arrays.asList(contact));
        employee.setLeadersById(Arrays.asList(leader));


    }




    @GetMapping("/employee")
    CollectionModel<EntityModel<Employee>> all() {

        List<EntityModel<Employee>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee) {

        return repository.save(newEmployee);
    }

    // Single item



    @PutMapping("/employee/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        Employee updatedEmployee = repository.findById(id) //
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setSurName(newEmployee.getSurName());
                    employee.setBio(newEmployee.getBio());
                    employee.setRol(newEmployee.getRol());
                    return repository.save(employee);
                }) //
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }



    @GetMapping("/employee/{id}")
    EntityModel<Employee> one(@PathVariable Long id) {

        Employee employee = repository.findById(id) //
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toModel(employee);
    }
}

*/
