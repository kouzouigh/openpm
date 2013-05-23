<html>
<head>
	<meta name="layout" content="main" />
</head>
<body>

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Contact name</th>
			<th>Email</th>
			<th>Country</th>
			<th></th>
		</tr>
	</thead>
	<g:each in="${clients}" var="client">
		<tr>
			<td>${client.name}</td>
			<td>${client.contactName}</td>
			<td>${client.email}</td>
			<td>France</td>
			<td class="align-right">
				<a class="btn btn-small btn-warning table-edit"><i class="icon-edit icon-white"></i></a>
				<a class="btn btn-small btn-danger" data-toggle="modal" href="#modalPanel"><i class="icon-remove icon-white"></i></a>
			</td>
		</tr>
	</g:each>
</table>
<g:link controller="client" action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new client</g:link>

<g:render template="/common/modal"/>

</body>
</html>
