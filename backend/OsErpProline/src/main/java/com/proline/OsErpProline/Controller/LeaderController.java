package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.EmployeeRepository;
import com.proline.OsErpProline.Repository.LeaderRepository;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Leader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/leader")
public class LeaderController {
    private EmployeeRepository employeeRepository;
    private LeaderRepository leaderRepository;


    public LeaderController(EmployeeRepository employeeRepository, LeaderRepository leaderRepository) {
        this.employeeRepository = employeeRepository;
        this.leaderRepository = leaderRepository;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Leader> getById(@PathVariable Integer id) {
        Optional<Leader> optionalLeader = leaderRepository.findById(id);
        if (!optionalLeader.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLeader.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Leader> delete(@PathVariable Integer id) {
        Optional<Leader> optionalLeader = leaderRepository.findById(id);
        if (!optionalLeader.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        leaderRepository.delete(optionalLeader.get());

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Leader> create(@RequestBody @Valid Leader leader) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(leader.getEmployeeByEmployeeId().getId());
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        leader.setEmployeeByEmployeeId(optionalEmployee.get());

        Leader savedLeader = leaderRepository.save(leader);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLeader.getId()).toUri();

        return ResponseEntity.created(location).body(savedLeader);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Leader> update(@RequestBody @Valid Leader leader, @PathVariable Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(leader.getEmployeeByEmployeeId().getId());
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Leader> optionalLeader = leaderRepository.findById(id);
        if (!optionalLeader.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        leader.setEmployeeByEmployeeId(optionalEmployee.get());
        leader.setId(optionalLeader.get().getId());
        leaderRepository.save(leader);

        return ResponseEntity.noContent().build();
    }
}
