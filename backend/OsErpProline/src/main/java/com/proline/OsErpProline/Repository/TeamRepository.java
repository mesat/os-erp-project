package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
