package com.aimprosoft.yesipov.web.command.impl;

import com.aimprosoft.yesipov.Path;
import com.aimprosoft.yesipov.db.dao.impl.MySQLEmployeeDAO;
import com.aimprosoft.yesipov.db.entity.Employee;
import com.aimprosoft.yesipov.web.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoveEmployeeCommand implements Command {

    private static final Logger log = Logger.getLogger(RemoveEmployeeCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");

        String errorMessage = null;
        String forward = Path.PAGE__ERROR_PAGE;

        Integer id = Integer.valueOf(request.getParameter("id"));

        List<Employee> employees = (List<Employee>) request.getServletContext().getAttribute("employeeList");

        Employee object = employees.stream()
                .filter(x -> id.equals(x.getId()))
                .findAny()
                .orElse(null);

        if (object == null) {
            errorMessage = "An employee with such id doesn't exist";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        } else {
            MySQLEmployeeDAO mySQLEmployeeDAO = new MySQLEmployeeDAO();

            Employee employee = new Employee();
            employee.setId(id);

            mySQLEmployeeDAO.removeEmployee(employee);

            employees = mySQLEmployeeDAO.employeeList();

            log.trace("Employee size = " + employees.size());
            request.getServletContext().setAttribute("employeeList", employees);

            forward = "/WEB-INF/jsp/list.jsp";
        }


        log.trace("Forward address --> " + forward);
        log.debug("Controller finished, now go to forward address --> " + forward);

        log.debug("Command finished");
        return forward;
    }
}
