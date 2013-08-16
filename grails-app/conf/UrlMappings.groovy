class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		'/logout'(controller: 'auth', action: 'logout')
		'/'(controller: 'auth', action: 'login')
		"404"(controller: "error", action: "notFound")
		"500"(view:'/error')
		
	}
}
