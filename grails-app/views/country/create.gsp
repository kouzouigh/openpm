<html>
<head>
<title>Create new Project</title>
<meta name="layout" content="main" />
</head>
<body>

	<g:form action="save" class="form-horizontal row-fluid">
		<div class="control-group ${country.errors['name'] ? 'error':''}">
			<label for="name" class="control-label">Country name</label>
			<div class="controls">
				<g:textField name="name" class="span2" value="${country.name}" id="name"/>
				<g:hasErrors  bean="${country}" field="name">
               		<span class="help-inline"><g:fieldError bean="${country}" field="name" /></span>
            	</g:hasErrors>
			</div>
		</div>
		<div class="control-group ${country.errors['code'] ? 'error':''}">
			<label for="code" class="control-label">Country code</label>
			<div class="controls">
				<g:textField name="code" class="span2" value="${country.code}" id="code"/>
				<g:hasErrors  bean="${country}" field="code">
               		<span class="help-inline"><g:fieldError bean="${country}" field="code" /></span>
            	</g:hasErrors>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button class="btn btn-primary" type="submit">Save</button>
			</div>
		</div>
	</g:form>
</body>
</html>