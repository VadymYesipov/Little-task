<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Login" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<table id="main-container">

    <tr>
        <td class="content top">
            <table border='1' bordercolor="red">
                <tr>
                    <th> <fmt:message key="index.jsp.employeeTable.id"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.firstName"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.lastName"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.birthday"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.email"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.position"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.department"/> </th>
                    <th> <fmt:message key="index.jsp.employeeTable.salary"/> </th>
                </tr>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td>
                            <c:out value="${employee.getId()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getFirstName()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getLastName()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getBirthday()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getEmail()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getPosition()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getDepartment().getName()}"/>
                        </td>
                        <td>
                            <c:out value="${employee.getSalary()}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td class="content top">

            <form class="login_form" name="myForm" action="controller" method="post" onclick="validateBirthday()">
                <fieldset>
                    <input type="hidden" name="command" value="addEmployee"/></p>
                    <input type="text" required pattern="^[A-ZА-Я][a-zа-яё]+" name="firstName" placeholder="<fmt:message key="index.jsp.placeholder.firstName"/>"/></p>
                    <input type="text" required pattern="^[A-ZА-Я][a-zа-яё]+" name="lastName" placeholder="<fmt:message key="index.jsp.placeholder.lastName"/>"/></p>
                    <input type="date" required name="birthday"/></p>
                    <input type="text" required name="email" pattern="\w+([\.-]?\w+)*@\w+([\.-]?\w+)*\.\w{2,4}" placeholder="<fmt:message key="index.jsp.placeholder.email"/>"/></p>
                    <input type="text" required pattern="^[A-ZА-Я][a-zа-яё\s]+" name="position" placeholder="<fmt:message key="index.jsp.placeholder.position"/>"/></p>
                    <input type="number" required min="1" max="${departmentList.size()}" name="departmentId" placeholder="<fmt:message key="index.jsp.placeholder.newDepartmentID"/>"/></p>
                    <input type="number" required min="100" step="10" max="5000" name="salary" placeholder="<fmt:message key="index.jsp.placeholder.salary"/>"/></p>
                    <input type="submit" value="<fmt:message key="index.jsp.submit.add"/>"/>
                </fieldset>
            </form>

            <form class="login_form" action="controller" method="post">
                <fieldset>
                    <input type="hidden" name="command" value="editEmployee" /></p>
                    <input type="number" min="1" max="${employeeList.size()}" required name="id" placeholder="<fmt:message key="index.jsp.placeholder.chooseId"/>"/></p>
                    <input type="text" pattern="^[A-ZА-Я][a-zа-яё]+" name="firstName" placeholder="<fmt:message key="index.jsp.placeholder.firstName"/>"/></p>
                    <input type="text" pattern="^[A-ZА-Я][a-zа-яё]+" name="lastName" placeholder="<fmt:message key="index.jsp.placeholder.lastName"/>"/></p>
                    <input type="date" name="birthday"/></p>
                    <input type="text" name="email" pattern="\w+([\.-]?\w+)*@\w+([\.-]?\w+)*\.\w{2,4}" placeholder="<fmt:message key="index.jsp.placeholder.email"/>"/></p>
                    <input type="text" pattern="^[A-ZА-Я][a-zа-яё\s]+" name="position" placeholder="<fmt:message key="index.jsp.placeholder.position"/>"/></p>
                    <input type="number" min="1" max="${departmentList.size()}" name="departmentId" placeholder="<fmt:message key="index.jsp.placeholder.newDepartmentID"/>"/></p>
                    <input type="number" min="100" step="10" max="5000" name="salary" placeholder="<fmt:message key="index.jsp.placeholder.salary"/>"/></p>
                    <input type="submit" name="editEmployee" value="<fmt:message key="index.jsp.submit.edit"/>" />
                </fieldset>
            </form>

            <form class="login_form" action="controller" method="post">
                <fieldset>
                    <input type="hidden" name="command" value="removeEmployee"/></p>
                    <input type="number" min="1" max="${employeeList.size()}" required name="id" placeholder="<fmt:message key="index.jsp.placeholder.chooseId"/>"/></p>
                    <input type="submit" name="removeEmployee" value="<fmt:message key="index.jsp.submit.remove"/>"/>
                </fieldset>
            </form>
        </td>
    </tr>

</table>

</body>
</html>