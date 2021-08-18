package com.proline.OsErpProline.Controller;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}
