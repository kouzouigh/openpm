<html>
<head>
<title>Create new Project</title>
<meta name="layout" content="main" />
</head>
<body>

	<form class="form-horizontal row-fluid">
		<div class="control-group">
			<label for="name" class="control-label">Project name</label>
			<div class="controls">
				<g:textField name="name" class="span8" value="${project.name}" id="name"/>
			</div>
		</div>
		<div class="control-group">
			<label for="code" class="control-label">Project code</label>
			<div class="controls">
				<input type="text" class="span8" id="code"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="description" class="control-label">Description</label>
			<div class="controls">
				<g:textArea id="description" name="description" class="span8" value="${project.description}"></g:textArea> 
			</div>
		</div>
		<div class="control-group">
			<label for="basicinput" class="control-label">Code</label>
			<div class="controls">
				<input type="text" class="span8" value="${user?.code}"
					placeholder="Type something here..." id="basicinput">
			</div>
		</div>

		<div class="control-group">
			<label for="basicinput" class="control-label">Client</label>
			<div class="controls">
				<g:select class="span8"
						  name="user.country.id" 
						  from="${clients}"
				 		  value="${project.client.id}"
				 		  noSelection="${['null':'Select One...']}"
				 		  optionKey="id" optionValue="name"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="basicinput" class="control-label">Countries</label>
			<div class="controls">
				<g:select class="span8"
						  name="user.country.id" 
						  multiple="true"
						  from="${clients}"
				 		  value="${project.client.id}"
				 		  noSelection="${['null':'Select One...']}"
				 		  optionKey="id" optionValue="name"/>
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
				<button class="btn" type="submit">Save</button>
			</div>
		</div>
	</form>
</body>
</html>