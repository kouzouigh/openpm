<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	
	

<form class="form-horizontal row-fluid">
	<div class="control-group">
	   	<label class="control-label" for="name">Name</label>
	   	<div class="controls">
	         <input type="text" class="input-xxlarge" id="name" value=""/>
	    </div>
	</div>
	<div class="control-group">
	   	<label class="control-label" for="email">Email</label>
	   	<div class="controls">
	         <input type="text" class="input-xxlarge" id="email" value=""/>
	    </div>
	</div>
	<div class="control-group">
	   	<label class="control-label" for="contactName">Contact name</label>
	   	<div class="controls">
	         <input type="text" class="input-xxlarge" id="contactName" value=""/>
	    </div>
	</div>
	<div class="control-group">
		<label for="basicinput" class="control-label">Country</label>
		<div class="controls">
			<g:select name="client.country.id" 
					  from="${countries}"
				 	  value="${client.country.id}"
				 	  noSelection="${['null':'Select One...']}"
				 	  optionKey="id" optionValue="name"/>
		</div>
	</div>
	<div class="form-actions">
    	<button type="submit" class="btn btn-primary">Save changes</button>
        <button class="btn">Cancel</button>
    </div>
</form>

</body>
</html>
