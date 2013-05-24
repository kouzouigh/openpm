<html>
<head>
<title>Create new Project</title>
<meta name="layout" content="main" />
</head>
<body>

	<g:form action="save" class="form-horizontal row-fluid">
		<div class="control-group ${hasErrors(field:'name', 'error')}">
			<label for="name" class="control-label">Project name</label>
			<div class="controls">
				<g:textField name="name" class="span8" value="${project.name}" id="name"/>
				<g:hasErrors  bean="${project}" field="name">
               		<span class="help-inline"><g:fieldError bean="${project}" field="name" /></span>
            	</g:hasErrors>
			</div>
		</div>
		<div class="control-group ${hasErrors(field:'code', 'error')}">
			<label for="code" class="control-label">Project code</label>
			<div class="controls">
				<input type="text" class="span8" id="code"/>
				<g:hasErrors  bean="${project}" field="code">
               		<span class="help-inline"><g:fieldError bean="${project}" field="code" /></span>
            	</g:hasErrors>
			</div>
		</div>
		
		<div class="control-group">
			<label for="description" class="control-label">Description</label>
			<div class="controls">
				<g:textArea id="description" name="description" class="span8" value="${project.description}"></g:textArea> 
			</div>
		</div>
		
		<div class="control-group ${hasErrors(field:'client', 'error')}">
			<label for="client" class="control-label">Client</label>
			<div class="controls">
				<div class="input-append" style="width:100%">
   					<g:select class="span8"
   					  id="client"
					  name="client.id" 
					  from="${org.openpm.Client.list()}"
			 		  value="${project?.client?.id}"
			 		  noSelection="${['null':'Select One...']}"
			 		  optionKey="id" optionValue="name"/>
   					<button class="btn" style="display:inline" type="button"><i class="icon-plus"></i> Create client</button>
    			</div>
				
				<g:hasErrors  bean="${project}" field="client">
               		<span class="help-inline"><g:fieldError bean="${project}" field="client" /></span>
            	</g:hasErrors>
			</div>
		</div>
		
		<div class="control-group ${hasErrors(field:'countries', 'error')}">
			<label for="countries" class="control-label">Countries</label>
			<div class="controls">
				<g:select class="span8"
						  id="countries"
						  name="country.id" 
						  multiple="true"
						  from="${org.openpm.Country.list()}"
				 		  value="${project?.countries?.id}"
				 		  optionKey="id" optionValue="name"/>
								 		  
				<g:hasErrors  bean="${project}" field="countries">
               		<span class="help-inline"><g:fieldError bean="${project}" field="countries" /></span>
            	</g:hasErrors>
			</div>
		</div>
		
		<div class="control-group">
			<label for="basicinput" class="control-label">Start date</label>
			<div class="controls">
				<g:datePicker name="finishDate" value="${new Date()}"precision="day" relativeYears="[-2..7]"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="basicinput" class="control-label">Finish date</label>
			<div class="controls">
				<g:datePicker name="finishDate" value="${new Date()}" 
					noSelection="['':'']" precision="day" relativeYears="[-2..7]"/>
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<button class="btn btn-primary" type="submit">Create</button>
			</div>
		</div>
	</g:form>
</body>
</html>