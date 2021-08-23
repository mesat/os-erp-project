package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Modifying
    @Query("update Leader l set l.employeeByEmployeeId.id = :employeeId where l.id = :leaderId")
    void updateLeader(@Param(value = "employeeId") Integer employeeId,@Param(value = "leaderId") Integer leaderId);
}
