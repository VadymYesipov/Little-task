<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Login" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<table id="main-container">
    <tr>
        <td class="content center">

            <form class="login_form" method="post" action="/controller">
                <input type="hidden" required name="command" value="list"/></p>
                <input type="submit" name="name" value="departments">
            </form>

            <form class="login_form" method="post" action="/controller">
                <input type="hidden" required name="command" value="list"/></p>
                <input type="submit" name="name" value="employees">
            </form>

        </td>
    </tr>

</table>

</body>

</html>
