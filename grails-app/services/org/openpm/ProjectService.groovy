package org.openpm

import org.hibernate.FetchMode;

class ProjectService {

    def fetch(Long id) {
		def criteria = Project.createCriteria()
		criteria.get {
			eq('id', id)
			fetchMode("projectManager", FetchMode.JOIN)
			fetchMode("client", FetchMode.JOIN)
		}
		
    }
}
