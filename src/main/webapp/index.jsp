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
                    <th> <fmt:message key="index.jsp.departmentTable.id"/> </th>
                    <th> <fmt:message key="index.jsp.departmentTable.name"/> </th>
                </tr>
                <c:forEach var="department" items="${departmentList}">
                    <tr>
                        <td>
                            <c:out value="${department.getId()}"/>
                        </td>
                        <td>
                            <c:out value="${department.getName()}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>

        <td class="content center">
            <form class="login_form" action="controller" method="post">
                <input type="hidden" name="command" value="addDepartment"/></p>
                <input type="text" name="departmentName" required pattern="^[A-ZА-Я][a-zа-яё\s]+" placeholder="<fmt:message key="index.jsp.placeholder.departmentName"/>"/></p>
                <input type="submit" value="<fmt:message key="index.jsp.submit.add"/>"/>
            </form>
        </td>

        <td class="content center">
            <form class="login_form" action="controller" method="post">
                <input type="hidden" name="command" value="editDepartment"/>
                <input type="number" required min="1" name="id" max="${departmentList.size()}" placeholder="<fmt:message key="index.jsp.placeholder.chooseId"/>" /></p>
                <input type="text" required name="departmentName" pattern="^[A-ZА-Я][a-zа-яё\s]+" placeholder="<fmt:message key="index.jsp.placeholder.departmentName"/>" /></p>
                <input type="submit" value="<fmt:message key="index.jsp.submit.edit"/>"/>
            </form>
        </td>

        <td class="content center">
            <form class="login_form" action="controller" method="post">
                <input type="hidden" name="command" value="removeDepartment"/></p>
                <input type="number" min="1" max="${departmentList.size()}" required name="id" placeholder="<fmt:message key="index.jsp.placeholder.chooseId"/>"/></p>
                <input type="submit" name="removeDepartment" value="<fmt:message key="index.jsp.submit.remove"/>"/>
            </form>
        </td>

        <td class="content center">
            <form class="login_form" action="controller" method="post">
                <input type="hidden" required name="command" value="list"/></p>
                <input type="submit" value="<fmt:message key="index.jsp.submit.list_of_employees"/>"/>
            </form>
        </td>
    </tr>

</table>
<script src="js/script.js"></script>
</body>
</html>