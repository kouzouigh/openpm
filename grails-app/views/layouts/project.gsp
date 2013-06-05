<g:applyLayout name="main">
<html>
<head>
	
	<title>Project</title>
	<g:layoutHead/>
</head>
<body>
	<div class="subnav navbar navbar-fixed-top">
	    <div class="navbar-inner">
	        <div class="container-fluid">
	            <ul class="nav">
	                <li class="${controllerName == 'user' ? 'active' :''}"><g:link controller="user" action="list"><i class="icon-th"></i>Activities</g:link></li>
	                <li class="${controllerName == 'client' ? 'active' :''}"><g:link controller="client"><i class="icon-file"></i>Invoices</g:link></li>
	                <li><g:link controller="country"><i class="icon-flag"></i>Profitability</g:link></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<g:layoutBody/>
</body>
</html>
</g:applyLayout>