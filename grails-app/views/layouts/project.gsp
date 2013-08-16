<g:applyLayout name="main">
<html>
<head>
	
	<title>Project ${session.project.code}</title>
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
	
	<div>
		<table class="table table-bordered table-condensed">
			<thead>
				<tr style="background:#eee">
					<th>Project</th>
					<th>Code</th>
					<th>Client</th>
					<th>Project Manager</th>
					<th>Countries</th>
					<th>Start date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody>
				<tr class="warning">
					<td>${session.project.name}</td>
					<td>${session.project.client.name}</td>
					<td>${session.project.code}</td>
					<td>${session.project.projectManager.username}</td>
					<td>${session.project.countries.name.join(',')}</td>
					<td><g:formatDate date="${session.project.startDate}" type="date" style="MEDIUM"/></td>
					<td><g:formatDate date="${session.project.endDate}" type="date" style="MEDIUM"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr/>
	<g:layoutBody/>
</body>
</html>
</g:applyLayout>