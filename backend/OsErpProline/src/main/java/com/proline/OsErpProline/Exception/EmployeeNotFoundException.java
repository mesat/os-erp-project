package com.proline.OsErpProline.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}
