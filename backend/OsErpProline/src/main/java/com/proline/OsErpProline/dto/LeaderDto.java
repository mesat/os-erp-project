package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Leader;
import com.proline.OsErpProline.entity.Team;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

public class LeaderDto implements Serializable {
    private Integer id;
    private String rol;
    private Integer employeeId;
    private TeamDto teamsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }




    public Leader toLeader(){
        Leader leader = new Leader();


        leader.setRol(this.rol);

        return leader;
    }
}
