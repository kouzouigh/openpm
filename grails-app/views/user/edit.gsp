<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<h3 class="page-header">
    	Edit profile
	</h3>

	<g:form action="update" class="form-horizontal row-fluid">
		<input type="hidden" name="id" value="${userInstance.id}" />
		<input type="hidden" name="version" value="${userInstance.version}" />
		<div class="control-group">
			<label for="username" class="control-label">Username</label>
			<div class="controls">
				<g:textField class="span8" name="username" value="${userInstance.username}"	id="username" required="required"/>
				<g:hasErrors  bean="${clientInstance}" field="name">
          			<span class="help-inline"><g:fieldError bean="${userInstance}" field="name" /></span>
            	</g:hasErrors>
			</div>
		</div>
		<div class="control-group">
			<label for="firstName" class="control-label">First name</label>
			<div class="controls">
				<g:textField class="span8" name="firstName" value="${userInstance.firstName}" id="firstName" required="required"/>
				<g:hasErrors  bean="${clientInstance}" field="firstName">
          			<span class="help-inline"><g:fieldError bean="${userInstance}" field="firstName" /></span>
            	</g:hasErrors>
			</div>
		</div>
		<div class="control-group">
			<label for="lastName" class="control-label">Last name</label>
			<div class="controls">
				<g:textField class="span8" name="lastName" value="${userInstance.lastName}" id="lastName" required="required"/>
				<g:hasErrors  bean="${clientInstance}" field="lastName">
          			<span class="help-inline"><g:fieldError bean="${userInstance}" field="lastName" /></span>
            	</g:hasErrors>	 
			</div>
		</div>
		<div class="control-group">
			<label for="email" class="control-label">Email</label>
			<div class="controls">
				<g:textField class="span8" name="email" value="${userInstance.email}" id="email" required="required"/>
				<g:hasErrors  bean="${clientInstance}" field="email">
          			<span class="help-inline"><g:fieldError bean="${userInstance}" field="email" /></span>
            	</g:hasErrors>	 
			</div>
		</div>
		
		<div class="control-group">
			<label for="code" class="control-label">Code</label>
			<div class="controls">
				<g:textField class="span8" name="code" value="${userInstance.code}" id="code" required="required"/>
				<g:hasErrors  bean="${clientInstance}" field="code">
          			<span class="help-inline"><g:fieldError bean="${userInstance}" field="code" /></span>
            	</g:hasErrors>	 
			</div>
		</div>

		<div class="control-group">
			<label for="basicinput" class="control-label">Country</label>
			<div class="controls">
				<g:select class="span8"
						  name="user.country.id" 
						  from="${countries}"
				 		  value="${userInstance.country.id}"
				 		  noSelection="${['null':'Select One...']}"
				 		  optionKey="id" optionValue="name"/>
			</div>
		</div>
		
		<div class="form-actions">
    		<button type="submit" class="btn btn-primary">Update</button>
        	<g:link action="list" class="btn">Cancel</g:link>
    	</div>
	</g:form>
	
</body>
</html>