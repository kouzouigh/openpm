<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Open Project Management</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    
    <r:require modules="bootstrap, bootstrap-fixtaglib"/>
    
    <link type="text/css" href="${resource(dir: 'css', file: 'main.css')}" rel="stylesheet" />
	<r:layoutResources/>
	<g:layoutHead />
	
  </head>

  <body>
  
  		
  	<g:render template="/layouts/navigation"/>
  	
    <div class="container-fluid">

      <g:layoutBody/>
      
      <hr>
		
      <footer>
        <p>&copy; Company 2013</p>
      </footer>
	  <r:layoutResources />
    </div> <!-- /container -->

  </body>
</html>