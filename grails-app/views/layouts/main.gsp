<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Open Project Management</title>
    <r:require modules="bootstrap, bootstrap-fixtaglib"/>
	<r:layoutResources/>
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>

  <body>
  
  		
   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Open Project Management</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Projects</a></li>
              <li><a href="#about">Invoices</a></li>
              <li><a href="#contact">Administration</a></li>
              <li><a href="#about">About</a></li>
              
            </ul>
            
            <ul id="main-menu-left" class="nav pull-right">
            	<li class="dropdown">
						
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> 
							 <shiro:principal  />
							<b class="caret"></b>
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<g:link controller="user" action="edit">
									My Profile
								</g:link>
							</li>
							<li><a href="javascript:;">My Groups</a></li>
							<li class="divider"></li>
							<li><a href="javascript:;">Logout</a></li>
						</ul>
						
					</li>
            </ul>
            
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
       	<g:layoutBody/>
      </div>
      
      <hr>
		
      <footer>
        <p>&copy; Company 2013</p>
      </footer>
	  <r:layoutResources />
    </div> <!-- /container -->

  </body>
</html>