<html>
<head>
<title>An Example Page</title>
<meta name="layout" content="main" />
</head>
<body>
	<form class="form-horizontal row-fluid">
		<div class="control-group">
			<label for="basicinput" class="control-label">Username</label>
			<div class="controls">
				<input type="text" class="span8" value="${user.username}"
					placeholder="Type something here..." id="basicinput"/>
			</div>
		</div>
		<div class="control-group">
			<label for="basicinput" class="control-label">Display name</label>
			<div class="controls">
				<input type="text" class="span8"
					placeholder="Type something here..." id="basicinput"/>
			</div>
		</div>
		
		<div class="control-group">
			<label for="basicinput" class="control-label">Email</label>
			<div class="controls">
				<input type="text" class="span8" value="${user.email}"
					placeholder="Type something here..." id="basicinput"/> 
			</div>
		</div>
		<div class="control-group">
			<label for="basicinput" class="control-label">Code</label>
			<div class="controls">
				<input type="text" class="span8" value="${user.code}"
					placeholder="Type something here..." id="basicinput">
			</div>
		</div>

		<div class="control-group">
			<label for="basicinput" class="control-label">Country</label>
			<div class="controls">
				<g:select class="span8"
						  name="user.country.id" 
						  from="${countries}"
				 		  value="${user.country.id}"
				 		  noSelection="${['null':'Select One...']}"
				 		  optionKey="id" optionValue="name"/>
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