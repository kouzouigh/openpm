<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="#">Open Project Management</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><g:link controller="project" action="list">
					Projects
				</g:link></li>
					<li><a href="#about">Invoices</a></li>
					<li><g:link controller="admin">Administration</g:link></li>
					<li><a href="#about">About</a></li>

				</ul>

				<ul id="main-menu-left" class="nav pull-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-user"></i> <shiro:principal />
							<b class="caret"></b>
					</a>

						<ul class="dropdown-menu">
							<li><g:link controller="user" action="edit">
									My Profile
								</g:link></li>
							<li><a href="javascript:;">My Groups</a></li>
							<li class="divider"></li>
							<li><a href="javascript:;">Logout</a></li>
						</ul></li>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>