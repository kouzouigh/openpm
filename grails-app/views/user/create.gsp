<html>
<head>
<meta name="layout" content="admin" />
</head>
<body>
<h3 class="page-header">
    Create user
</h3>
	<g:form action="save" class="form-horizontal row-fluid">
		<div class="control-group">
			<label for="username" class="control-label">Username</label>
			<div class="controls">
				<g:textField class="span8" name="username" value="${userInstance.username}"	id="username" required="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="email" class="control-label">Email</label>
			<div class="controls">
				<g:textField type="text" class="span8" name="email" value="${userInstance.email}" id="email" required="required"/> 
			</div>
		</div>
		
		<div class="control-group">
			<label for="code" class="control-label">Code</label>
			<div class="controls">
				<g:textField class="span8" name="code" value="${userInstance.code}" id="code" required="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="roles" class="control-label">Role</label>
			<div class="controls">
				<g:select class="span8"
						  id="roles"	
						  name="roles" 
						  from="${org.openpm.Role.list()}"
						  multiple="true"
				 		  value="${userInstance?.roles?.id}"
				 		  optionKey="id" optionValue="name"/>
			</div>
		</div>

		<div class="control-group">
			<label for="country" class="control-label">Country</label>
			<div class="controls">
				<g:select class="span8"
						  name="country.id"
						  from="${org.openpm.Country.list()}"
				 		  value="${userInstance?.country?.id}"
				 		  noSelection="${['null':'Select One...']}"
				 		  optionKey="id" optionValue="name"/>
			</div>
		</div>
		<div class="form-actions">
    		<button type="submit" class="btn btn-primary">Create</button>
        	<g:link action="list" class="btn">Cancel</g:link>
    	</div>
	</g:form>
</body>
</html>