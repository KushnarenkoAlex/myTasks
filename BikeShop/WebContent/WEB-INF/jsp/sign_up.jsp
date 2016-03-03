<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ taglib prefix="pref" uri="/WEB-INF/myTag.tld"%>
<div class="container">
    <div class="cart-top">
        <a href="index.html"> home</a>
    </div>
    <br> <br>
    <h2>SIGN UP</h2>
    <form id="signUpForm" action="register" method="post"
        enctype="multipart/form-data">
        <table size="1000" border="5" bordercolor="white">
            <tr>
                <td>FIRST NAME:</td>
                <td size="100"><input size="100" type="text"
                    id="firstName" name="firstName"
                    class="form-control input-text"
                    placeholder="First Name"
                    value="${sessionScope.firstName}"><span
                    class="error-message" id="firstNameError"
                    name="firstNameError">${sessionScope.errors.get("firstName")}</span></td>
            </tr>
            <tr>
                <td>LAST NAME:</td>
                <td size="100"><input size="100" type="text"
                    id="lastName" name="lastName"
                    class="form-control input-text"
                    placeholder="Last Name"
                    value="${sessionScope.lastName}"><span
                    class="error-message" id="lastNameError"
                    name="lastNameError">${sessionScope.errors.get("lastName")}</span></td>
            </tr>
            <tr>
                <td>PASSWORD:</td>
                <td><input type="password" id="password"
                    name="password" class="form-control input-text"
                    placeholder="Password"> <span
                    class="error-message" id="passwordError"
                    name="passwordError">${sessionScope.errors.get("password")}</span>
                </td>
            </tr>
            <tr>
                <td>REPEAT PASSWORD:</td>
                <td><input type="password" id="password2"
                    name="password2" class="form-control input-text"
                    placeholder="Password"><span
                    class="error-message" id="password2Error"
                    name="password2Error">${sessionScope.errors.get("incorrectPasswords")}</span>
                </td>
            </tr>
            <tr>
                <td>EMAIL:</td>
                <td><input type="text" id="email" name="email"
                    class="form-control input-text" placeholder="Email"
                    value="${sessionScope.email}"><span
                    class="error-message" id="emailError"
                    name="emailError">${sessionScope.errors.get("email")}</span></td>
            </tr>
            </tr>
            <tr>
                <td>PHONE NUMBER:</td>
                <td><input type="text" id="phoneNumber"
                    name="phoneNumber" class="form-control input-text"
                    placeholder="Phone Number"
                    value="${sessionScope.phoneNumber}"><span
                    class="error-message" id="phoneNumberError"
                    name="phoneNumberError">${sessionScope.errors.get("phoneNumber")}</span></td>
            </tr>

            <tr>
                <td>GET MAIL FROM BIKE SHOP</td>
                <td><input type="checkbox" name="spam" value="spam" /></td>
            </tr>
            <tr>
                <td>AVATAR</td>
                <td><input type="file" name="image" value="image" /><span
                    class="error-message" id="imageError"
                    name="imageError">${sessionScope.errors.get("image")}</span></td>
            </tr>
            <pref:CaptchaTag />
        </table>
        <span class="error-message" id="userExists" name="userExists">${sessionScope.errors.get("userExists")}</span>
        <input type="submit" class="btn btn-default" name="signup"
            value="Sign Up">
    </form>

</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>