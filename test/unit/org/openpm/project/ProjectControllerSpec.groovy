package org.openpm.project
import org.openpm.Project;
import org.openpm.ProjectController;
import org.openpm.ProjectService;

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification;

@Mock([Project])
@TestFor(ProjectController)
class ProjectControllerSpec extends Specification {

	def "view() should set project in session and forward to activity list action"() {
		given: "A request parameter"
		ProjectService projectService = Mock()
		projectService.fetch(_) >> new Project(id:1)
		controller.projectService = projectService
		params.id = 1
		
		when:"calling view() action"
		controller.view()
		response.forwardedUrl
		
		then:
		response.forwardedUrl == '/grails/activity.dispatch'
		session.project != null
		 
	}
	
}
