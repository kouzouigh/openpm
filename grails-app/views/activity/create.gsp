<%@page import="org.openpm.Country" %>
<html>
<head>
<meta name="layout" content="project" />
</head>
<body>
	<h3 class="page-header">
    Create Activity
</h3>
<g:form action="save" class="form-horizontal row-fluid">
	<g:hiddenField name="project.id" value="${session.project.id}"/>
	
	<div class="control-group">
	   	<label class="control-label" for="name">Name</label>
	   	<div class="controls">
   		 	<g:textField name="name" class="span3" value="${activityInstance.name}" id="name" required="" />
			<g:hasErrors  bean="${activityInstance}" field="name">
          		<span class="help-inline"><g:fieldError bean="${activityInstance}" field="name" /></span>
            </g:hasErrors>
	    </div>
	</div>
	
	<div class="control-group">
		<label for="description" class="control-label">Description</label>
		<div class="controls">
			<g:textArea id="description" name="description" class="span3" value="${activityInstance.description}"></g:textArea> 
		</div>
	</div>
	
	<div class="control-group">
		<label for="consultant" class="control-label">Consultant</label>
		<div class="controls">
			<g:select name="consultant.id"
					  class="span3"	 
					  from="${consultants}"
				 	  value="${activityInstance?.consultant?.id}"
				 	  noSelection="${['null':'Select One...']}"
				 	  optionKey="id" optionValue="username"/>
		</div>
		<g:hasErrors  bean="${activityInstance}" field="consultant">
      		<span class="help-inline"><g:fieldError bean="${activityInstance}" field="consultant" /></span>
        </g:hasErrors>
	</div>
	
	<div class="control-group ${hasErrors(field:'country', 'error')}">
		<label for="country" class="control-label">Country</label>
		<div class="controls"> 		  
			 <g:select name="country.id"
			 		   id="country" 
			 		   class="span3"	
					   from="${session.project.countries}"
				 	   value="${activityInstance?.country?.id}"
				 	   noSelection="${['null':'Select One...']}"
				 	   optionKey="id" optionValue="name"/>		  
							 		  
			<g:hasErrors bean="${activityInstance}" field="country">
              		<span class="help-inline"><g:fieldError bean="${activityInstance}" field="country" /></span>
           	</g:hasErrors>
		</div>
	</div>
	
	<div class="control-group">
	   	<label class="control-label" for="hourlyChargeRate">Charge rate</label>
	   	<div class="controls">
	   		
   		 	<div class="input-append">
				<g:textField name="hourlyChargeRate" class="input-mini" value="${activityInstance.hourlyChargeRate}" id="hourlyChargeRate" required="" />
				<span class="add-on">&euro;</span>
			</div>
			<g:hasErrors  bean="${activityInstance}" field="hourlyChargeRate">
          		<span class="help-inline"><g:fieldError bean="${activityInstance}" field="hourlyChargeRate" /></span>
            </g:hasErrors>
            
	    </div>
	</div>
	
	<div class="control-group">
			<label for="startDate" class="control-label">Start date</label>
			<div class="controls">
				<g:datePicker name="startDate" class="span3" value="${new Date()}"precision="day" relativeYears="[-1..7]"/>
			</div>
		</div>
	
	<div class="form-actions">
    	<button type="submit" class="btn btn-primary">Create</button>
        <g:link action="list" class="btn">Cancel</g:link>
    </div> 
</g:form>
</body>
</html>
