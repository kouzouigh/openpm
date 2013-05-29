<html>
<head>
	<meta name="layout" content="main" />
</head>
<body>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Code</th>
			<th>Start date</th>
			<th>End date</th>
			<th>Client</th>
			<th>Countries</th>
			<th>Status</th>
			<th></th>
		</tr>
	</thead>
	<g:each in="${projects}" var="project">
		<tr>
			<td>${project.name}</td>
			<td>${project.code}</td>
			<td><g:formatDate date="${project.startDate}" type="date" style="MEDIUM"/></td>
			<td><g:formatDate date="${project.endDate}" type="date" style="MEDIUM"/></td>
			<td>${project.client.name}</td>
			<td>${project.countries.name.join(',')}</td>
			<td>Open</td>
			
			<td class="align-right">
				<g:link action="edit" id="${project.id}" class="btn btn-small btn-warning table-edit" title="close project"><i class="icon-stop icon-white"></i></g:link>
				<g:link action="edit" id="${project.id}" class="btn btn-small btn-warning table-edit"><i class="icon-edit icon-white"></i></g:link>
				<a class="btn btn-small btn-danger" data-toggle="modal" href="#modalPanel"><i class="icon-remove icon-white"></i></a>
			</td>
		</tr>
	</g:each>
</table>
<g:link action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new project</g:link>

<g:render template="/common/modal"/>

</body>
</html>

	
