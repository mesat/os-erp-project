package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //List<Employee> findByLike(String place);

}
