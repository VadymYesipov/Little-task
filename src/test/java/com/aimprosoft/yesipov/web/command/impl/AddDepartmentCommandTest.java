package com.aimprosoft.yesipov.web.command.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aimprosoft.yesipov.Path;
import com.aimprosoft.yesipov.db.entity.Department;

@RunWith(MockitoJUnitRunner.class)
public class AddDepartmentCommandTest extends Mockito {

    @InjectMocks
    private AddDepartmentCommand addDepartmentCommand;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Test
    public void testAdminPage() throws ServletException, IOException {
        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
        ServletContext servletContextMock = mock(ServletContext.class);

        List<Department> departments = new ArrayList<>();

        Department department = new Department();
        department.setName("depName");
        departments.add(department);

        when(servletContextMock.getAttribute("departmentList")).thenReturn(departments);
        when(httpRequestMock.getParameter("departmentName")).thenReturn("depName");
        when(httpRequestMock.getServletContext()).thenReturn(servletContextMock);
        Assert.assertEquals(Path.PAGE_ERROR_PAGE, addDepartmentCommand.execute(httpRequestMock, null));
    }
}
