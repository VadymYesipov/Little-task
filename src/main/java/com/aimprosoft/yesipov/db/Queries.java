package com.aimprosoft.yesipov.db;

public final class Queries {

    public static final String SQL_FIND_ALL_DEPARTMENTS = "SELECT * FROM department ORDER BY id";

    public static final String SQL_FIND_ALL_EMPLOYEES_FILTERED =
            "SELECT empl.id, first_name, last_name, birthday, email, job, original_name as department, salary " +
                    "FROM employee as empl " +
                    "INNER JOIN department as dep on empl.department_id=dep.id;";

    public static final String SQL_FIND_ALL_EMPLOYEES = "SELECT * FROM employee INNER JOIN department on employee.department_id=department.id;";

    public static final String SQL_INSERT_NEW_DEPARTMENT = "INSERT INTO department (id, original_name) VALUES (?, ?);";

    public static final String SQL_INSERT_NEW_EMPLOYEE = "INSERT INTO employee " +
            "(id, first_name, last_name, birthday, email, job, department_id, salary) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String SQL_DELETE_DEPARTMENT = "DELETE FROM department WHERE id=?;";

    public static final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?;";

    public static final String SQL_UPDATE_DEPARTMENT = "UPDATE department SET original_name = ? WHERE id=?;";

    public static final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET ";

    public static final String SQL_WHERE = " WHERE id=?;";
}