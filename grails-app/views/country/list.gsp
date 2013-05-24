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
			<th></th>
		</tr>
	</thead>
	<g:each in="${countries}" var="country">
		<tr>
			<td>${country.name}</td>
			<td>${country.code}</td>
			<td class="align-right">
				<a class="btn btn-small btn-warning table-edit"><i class="icon-edit icon-white"></i></a>
				<a class="btn btn-small btn-danger"><i class="icon-remove icon-white"></i></a>
			</td>
		</tr>
	</g:each>
</table>
	<g:link controller="country" action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new country</g:link>
</body>
</html>
