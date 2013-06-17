package org.openpm

class ProjectService {

    def fetch(Long id) {
		Project.find('''from Project project 
						join fetch project.projectManager 
						join fetch project.client 
						join fetch project.countries 
						where project.id = :id''', [id:id])
    }
}
