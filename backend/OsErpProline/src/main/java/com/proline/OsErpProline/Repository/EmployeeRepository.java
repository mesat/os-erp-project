package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //List<Employee> findByLike(String place);
    @Modifying
    @Query(value="select e from Employee e where e.rol like %:rol% and e.bio like %:bio%")
    List<Employee> searchEmployee(@Param(value = "rol") String rol,@Param(value = "bio") String bio);
}
