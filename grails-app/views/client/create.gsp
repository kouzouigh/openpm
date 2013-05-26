<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
<h3 class="page-header">
    Create Client
</h3>
<g:form action="save" class="form-horizontal row-fluid">
	<div class="control-group">
	   	<label class="control-label" for="name">Name</label>
	   	<div class="controls">
   		 	<g:textField name="name" class="input-xxlarge" value="${clientInstance.name}" id="name" required="" />
			<g:hasErrors  bean="${clientInstance}" field="name">
          		<span class="help-inline"><g:fieldError bean="${clientInstance}" field="name" /></span>
            </g:hasErrors>
	    </div>
	</div>
	<div class="control-group">
	   	<label class="control-label" for="email">Email</label>
	   	<div class="controls">
	     	<g:textField name="email" class="input-xxlarge" value="${clientInstance.email}" id="email" required=""/>
			<g:hasErrors  bean="${clientInstance}" field="email">
          		<span class="help-inline"><g:fieldError bean="${clientInstance}" field="email" /></span>
            </g:hasErrors>
	    </div>
	</div>
	<div class="control-group">
	   	<label class="control-label" for="contactName">Contact name</label>
	   	<div class="controls">
	        <g:textField name="contactName" class="input-xxlarge" value="${clientInstance.contactName}" id="contactName"/>
			<g:hasErrors  bean="${clientInstance}" field="contactName">
          		<span class="help-inline"><g:fieldError bean="${clientInstance}" field="contactName" /></span>
            </g:hasErrors>
	    </div>
	</div>
	<div class="control-group">
		<label for="basicinput" class="control-label">Country</label>
		<div class="controls">
			<g:select name="country.id" 
					  from="${org.openpm.Country.list()}"
				 	  value="${clientInstance?.country?.id}"
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
