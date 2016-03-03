<input type="text" name="captchaId" id="captchaId" value="${captchaId}"
	hidden="true" />
<tr>
	<td><img
		src="${pageContext.request.contextPath}/captchasService?captchaId=${captchaId}"></td>
	<td><input type="text" id="captchaValue" name="captchaValue"
		class="form-control input-text" placeholder="Captcha"><span
		class="error-message" id="phoneNumberError" name="captchaError">${sessionScope.errors.get("captcha")}</span></td>
</tr>