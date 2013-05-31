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
	                <li><g:link controller="user" action="list"><i class="icon-user"></i>Users</g:link></li>
	                <li><g:link controller="client">Clients</g:link></li>
	                <li><g:link controller="country"><i class="icon-flag"></i>Countries</g:link></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<g:layoutBody/>
</body>
</html>
</g:applyLayout>