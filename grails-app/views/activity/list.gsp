<html>
<head>
<meta name="layout" content="project" />
</head>
<body>
	<table class="table table-bordered table-condensed">
		<thead>
			<tr>
				<th>Name</th>
				<th>Consultant</th>
				<th>Start date</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
		<g:each in="${activities}" var="activity">
			<tr>
				<td>${activity.name}</td>
				<td>${activity.consultant.firstName} ${activity.consultant.lastName}</td>
				<td><g:formatDate date="${activity.startDate}" type="date" style="MEDIUM"/></td>
				<td>${activity.country.name}</td>
			</tr>
		</g:each>	
		</tbody>

	</table>
	<g:link action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new Activity</g:link>
</body>
</html>
