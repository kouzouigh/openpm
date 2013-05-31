<html>
<head>
	<meta name="layout" content="admin" />
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
			<td>${client.country.name}</td>
			<td class="align-right">
				<g:link action="edit" id="${client.id}" class="btn btn-small btn-warning table-edit"><i class="icon-edit icon-white"></i></g:link>
				<a class="btn btn-small btn-danger" data-toggle="modal" data-target="#" href="${createLink(action:'deleteConfirmation', id:client.id)}"><i class="icon-remove icon-white"></i></a>
			</td>
		</tr>
	</g:each>
</table>
<g:link controller="client" action="create" class="btn btn-primary"><i class="icon-plus icon-white"></i> Add new client</g:link>

<r:script>
	$(function () {
		$('[data-toggle="modal"]').click(function(e) {
			e.preventDefault();
			var url = $(this).attr('href');
			if (url.indexOf('#') == 0) {
				$(url).modal('open');
			} else {
				 $.get(url, function(data) {
     				$(data).modal();
  				});
			}
		});
	})
</r:script>
</body>
</html>
