/*package com.proline.OsErpProline.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select name from employee where name = name",nativeQuery = true)
    List<EmployeeRepository> getEmployeesByName(String firstname);
}


 */