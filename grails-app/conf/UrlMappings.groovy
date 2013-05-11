class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		'/logout'(controller: 'auth', action: 'logout')
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
