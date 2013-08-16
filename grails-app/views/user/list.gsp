<html>
<head>
	<meta name="layout" content="admin" />
</head>
<body>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Username</th>
			<th>Code</th>
			<th>Role(s)</th>
			<th>Email</th>
			<th>Country</th>
			<th></th>
		</tr>
	</thead>
	<g:each in="${users}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.code}</td>
			<td>${user.roles.name.join(', ')}</td>
			<td>${user.email}</td>
			<td>France</td>
			<td class="align-right">
				<g:link action="edit" id="${user.id}" class="btn btn-small btn-warning table-edit"><i class="icon-edit icon-white"></i></g:link>
				<a class="btn btn-small btn-danger"><i class="icon-remove icon-white"></i></a>
			</td>
		</tr>
	</g:each>
</table>
<g:link controller="user" action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new user</g:link>

</body>
</html>
