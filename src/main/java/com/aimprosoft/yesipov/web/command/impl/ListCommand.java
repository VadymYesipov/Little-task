package com.aimprosoft.yesipov.web.command.impl;

import com.aimprosoft.yesipov.Path;
import com.aimprosoft.yesipov.db.dao.impl.MySQLDepartmentDAO;
import com.aimprosoft.yesipov.db.dao.impl.MySQLEmployeeDAO;
import com.aimprosoft.yesipov.db.entity.Department;
import com.aimprosoft.yesipov.db.entity.Employee;
import com.aimprosoft.yesipov.web.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCommand implements Command {

    private static final Logger log = Logger.getLogger(ListCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");

        String forward = Path.LIST_JSP;

        List<Employee> employees = new MySQLEmployeeDAO().employeeList();
        if (employees.size() > 0) {
            log.trace("Employees size = " + employees.size());
            request.getServletContext().setAttribute("employeeList", employees);
        }

        List<Department> departments = new MySQLDepartmentDAO().departmentsList();
        if (departments.size() > 0) {
            log.trace("Departments size = " + departments.size());
            request.getServletContext().setAttribute("departmentList", departments);
        }


        log.trace("Forward address --> " + forward);
        log.debug("Controller finished, now go to forward address --> " + forward);

        log.debug("Command finished");
        return forward;
    }
}
