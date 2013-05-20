<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Open Project Management</title>
    
    <r:require modules="bootstrap, bootstrap-fixtaglib"/>
    
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,800">
	<link rel="stylesheet" href="http://jumpstartuidemo.com/themes/dashboard/css/font-awesome.css">
    
   <%-- 
    <link href="http://localhost:8080/openpm/static/bundle-bundle_bootstrap_head.css" rel="stylesheet">
    <link href="http://localhost:8080/openpm/static/bundle-fixtaglib_head.css" rel="stylesheet">
    <link href="http://jumpstartuidemo.com/themes/dashboard/css/application.css" rel="stylesheet">
    <script src="http://jumpstartuidemo.com/themes/dashboard/js/libs/modernizr-2.5.3.min.js"></script>
    --%>
	<r:layoutResources/>

	<link type="text/css" href="${resource(dir: 'css', file: 'login.css')}" rel="stylesheet" />
	<script src="http://jumpstartuidemo.com/themes/dashboard/js/libs/modernizr-2.5.3.min.js"></script>
    
  </head>

<body class="login">



<div class="account-container login stacked">
	
	<div class="content clearfix">
		
		<g:form url="[controller:'auth', action:'signIn']" accept-charset="UTF-8" method="post">
			<input type="hidden" name="targetUri" value="${targetUri}" />
			<h1>Sign In</h1>		
			
			<div class="login-fields">
				
				<p>Sign in using your registered account:</p>
				
				<div class="field">
					<label for="username">Email:</label>
					<!--input type="text" id="username" name="username" value="" placeholder="Username" class="login username-field" /-->
					<g:textField id="email" class="login username-field" name="username" placeholder="Email" value="${username}" required="true"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Password:</label>
					<g:passwordField id="password" class="login password-field" name="password" placeholder="Password" value="" required="true"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">Keep me signed in</label>
				</span>
									
				<button class="button btn btn-warning btn-large">Sign In</button>
				
			</div> <!-- .actions -->
			
			<div class="login-social">
				<a href="#">Forgot your password?</a>
			</div>
			
		</g:form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Open project management &copy; 2013
</div> <!-- /login-extra -->


  </body>
</html>
