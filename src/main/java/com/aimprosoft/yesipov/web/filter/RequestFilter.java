package com.aimprosoft.yesipov.web.filter;

import com.aimprosoft.yesipov.db.dao.impl.MySQLDepartmentDAO;
import com.aimprosoft.yesipov.db.dao.impl.MySQLEmployeeDAO;
import com.aimprosoft.yesipov.db.entity.Department;
import com.aimprosoft.yesipov.db.entity.Employee;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class RequestFilter implements Filter {

    private static final Logger log = Logger.getLogger(RequestFilter.class);

    public void destroy() {
        log.debug("Filter destruction starts");
        // do nothing
        log.debug("Filter destruction finished");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        log.debug("Filter starts");

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        log.trace("Request uri --> " + httpRequest.getRequestURI());

        List<Department> departments = new MySQLDepartmentDAO().departmentsList();
        if (departments.size() > 0) {
            log.trace("Departments size = " + departments.size());
            req.getServletContext().setAttribute("departmentList", departments);
        }

        log.debug("Filter finished");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        log.debug("Filter initialization starts");
        log.debug("Filter initialization finished");
    }

}
