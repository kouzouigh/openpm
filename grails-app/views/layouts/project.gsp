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
	                <li class="${controllerName == 'activity' ? 'active' :''}"><g:link controller="activity" action="list"><i class="icon-th"></i>Activities</g:link></li>
	                <li class="${controllerName == 'invoice' ? 'active' :''}"><g:link controller="invoice"><i class="icon-file"></i>Invoices</g:link></li>	                
	                <li class="${controllerNamer == 'profitability' ? 'active' : ''}"><g:link controller="profitability">Profitability</g:link></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<h5 class="page-header">
		<span>Project ${session.project.name}</span>
		<span style="float:right"><i class="icon-calendar icon-large"></i><g:formatDate date="${session.project.startDate}" type="datetime" style="SHORT"/></span>
	</h5>
	<g:layoutBody/>
</body>
</html>
</g:applyLayout>