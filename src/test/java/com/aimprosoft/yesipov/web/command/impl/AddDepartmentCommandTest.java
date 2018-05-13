package com.aimprosoft.yesipov.web.command.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDepartmentCommandTest extends Mockito {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeClass
    public static void init() throws Exception {

        //initialize();

    }
    @Test
    public void testAdminPage() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        //new AdminPage().doPost(request, response);
        verify(request).getRequestDispatcher("WEB-INF/jsp/admin/admin.jsp");
    }
}
