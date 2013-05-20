<div class="mainnav navbar navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">
        	<a class="brand" href="#">Open Project Management</a>
            <ul class="nav">
				<li class="active"><g:link controller="project" action="list">Projects</g:link></li>
				<li><a href="#about">Invoices</a></li>
				<li><g:link controller="admin">Administration</g:link></li>
				<li><a href="#about">About</a></li>
			</ul>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> <shiro:principal /> <span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><g:link controller="user" action="edit"><i class="icon-wrench"></i> My Profile</g:link></li>
					<li class="divider"></li>
					<li><a href="#"><i class="icon-share"></i> Logout</a></li>
				</ul>
			</div>
        </div>
    </div>
</div>

<div class="subnav navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <ul class="nav">
                <li><a>foo</a></li>
                <li><a>bar</a></li>
            </ul>
        </div>
    </div>
</div>
