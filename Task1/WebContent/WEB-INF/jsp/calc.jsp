<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="calculate" method="post">
        <table>
            <tr>
                <td>X:</td>
                <td><input type="text" id="x" name="x"></td>
                <td><span class="error-message" id="xError">${sessionScope.errors.get("xIncorrect")}</span>
                </td>
            </tr>
            <tr>
                <td>Action:</td>
                <td><select name="action">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                </select></td>
                <td><span class="error-message" id="xError">${sessionScope.errors.get("actionIncorrect")}</span>
                </td>
            </tr>
            <tr>
                <td>Y:</td>
                <td><input type="text" id="y" name="y"></td>
                <td><span class="error-message" id="xError">${sessionScope.errors.get("yIncorrect")}</span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>