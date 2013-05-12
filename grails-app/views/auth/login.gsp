<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Open Project Management</title>
    
    <r:require modules="bootstrap, bootstrap-fixtaglib"/>
	<r:layoutResources/>
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
	
  </head>

  <body>

    <div class="container">
	<div class="row">
		<div class="span4 offset4 well">
			<legend>Please Sign In</legend>
			<g:if test="${flash.message}">
          		<div class="alert alert-error">
                	<a class="close" data-dismiss="alert" href="#">×</a>Incorrect Username or Password!
            	</div>
           </g:if>
			<g:form url="[controller:'auth', action:'signIn']" accept-charset="UTF-8">
				<input type="hidden" name="targetUri" value="${targetUri}" />
				<g:textField required="true" id="email" class="span4" name="username" 
							 placeholder="Email" value="${username}"/>
							 
				<g:passwordField required="true" type="password" id="password" class="span4" name="password" 
							 placeholder="Password" value=""/>
							 
	            <label class="checkbox">
	            	<input type="checkbox" name="remember" value="1"> Remember Me
	            </label>
	            
				<button type="submit" name="submit" class="btn btn-primary btn-block">Log in</button>
			</g:form>    
		</div>
	</div>

      <hr>

      <footer>
        <p>&copy; Open Project Management - 2013</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
