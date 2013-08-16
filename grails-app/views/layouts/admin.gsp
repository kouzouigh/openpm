<g:applyLayout name="main">
<html>
<head>
	
	<title>Administration</title>
	<g:layoutHead/>
</head>
<body>
	<div class="subnav navbar navbar-fixed-top">
	    <div class="navbar-inner">
	        <div class="container-fluid">
	            <ul class="nav">
	                <li class="${controllerName == 'user' ? 'active' :''}"><g:link controller="user" action="list"><i class="icon-user"></i>Users</g:link></li>
	                <li class="${controllerName == 'client' ? 'active' :''}"><g:link controller="client">Clients</g:link></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<g:layoutBody/>
</body>
</html>
</g:applyLayout>