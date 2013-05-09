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
				<input type="text" class="span8"
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
				<input type="text" class="span8"
					placeholder="Type something here..." id="basicinput"/> 
			</div>
		</div>
		<div class="control-group">
			<label for="basicinput" class="control-label">Code</label>
			<div class="controls">
				<input type="text" class="span8"
					placeholder="Type something here..." id="basicinput">
			</div>
		</div>
		
		<div class="control-group">
			<label for="basicinput" class="control-label">Disabled Input</label>
			<div class="controls">
				<input type="text" disabled="" class="span8"
					placeholder="You can't type something here..." id="basicinput">
			</div>
		</div>

		<div class="control-group">
			<label for="basicinput" class="control-label">Country</label>
			<div class="controls">
				<select class="span8" data-placeholder="Select here.." tabindex="1">
					<option value="">Select here..</option>
					<option value="Category 1">First Row</option>
					<option value="Category 2">Second Row</option>
					<option value="Category 3">Third Row</option>
					<option value="Category 4">Fourth Row</option>
				</select>
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