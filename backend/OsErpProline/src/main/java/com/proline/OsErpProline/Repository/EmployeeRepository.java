package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
