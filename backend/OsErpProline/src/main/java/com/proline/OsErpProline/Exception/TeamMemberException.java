package com.proline.OsErpProline.Exception;

public class TeamMemberException extends RuntimeException{
    public TeamMemberException(Integer id) {
        super("Could not find employee " + id);
    }
}
