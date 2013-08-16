<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>
    	<g:layoutTitle default="Open Project Management"/>
    </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.pnotify.default.css')}" type="text/css">
    
    <r:require modules="bootstrap, bootstrap-fixtaglib"/>
    
    <link type="text/css" href="${resource(dir: 'css', file: 'main.css')}" rel="stylesheet" />
	<r:layoutResources/>
	<g:layoutHead />
	
  </head>

  <body>
  	
  	<g:render template="/layouts/navigation"/>
  	
    <div class="main-container container-fluid">

      <g:layoutBody/>
      
      <hr>
		
      <footer>
        <p>&copy; Company 2013</p>
      </footer>
      <g:javascript src="lib/jquery.pnotify.min.js"/>
	  <r:layoutResources />
    </div> <!-- /container -->
  </body>
</html>