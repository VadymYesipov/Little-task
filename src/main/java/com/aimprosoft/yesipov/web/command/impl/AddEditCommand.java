package com.aimprosoft.yesipov.web.command.impl;

import com.aimprosoft.yesipov.Path;
import com.aimprosoft.yesipov.web.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEditCommand implements Command {

    private static final Logger log = Logger.getLogger(AddEditCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");

        String forward = request.getParameter("name").equals("departments") ?
                Path.ADD_EDIT_DEPARTMENT :
                Path.ADD_EDIT_EMPLOYEE;

        log.trace("Forward address --> " + forward);
        log.debug("Controller finished, now go to forward address --> " + forward);

        log.debug("Command finished");
        return forward;
    }
}
