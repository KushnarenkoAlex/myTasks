<fmt:setLocale value="${sessionScope.currentLocaleLocale}" />
<fmt:setBundle basename="${applicationScope.bundleBasename}" />
<div class="row">
	<div class="col-sm-6">
		<div class="form-group">
			<label class="control-label" for="dateFrom"> <fmt:message
					key="label.date_from" />
			</label> <input class="form-control date" id="dateFrom" name="dateFrom"
				value="${dateFrom}" data-provide="datepicker-inline" />
			<p class="text-warning" id="dateFromError">${dateError}</p>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="form-group">
			<label class="control-label" for="dateTo"> <fmt:message
					key="label.date_to" />
			</label> <input class="form-control date" id="dateTo" name="dateTo"
				value="${dateTo}" data-provide="datepicker-inline" />
			<p class="text-warning" id="dateToError">${dateError}</p>
		</div>
	</div>
</div>