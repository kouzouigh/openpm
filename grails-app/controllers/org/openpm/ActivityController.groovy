package org.openpm

class ActivityController {
	
	static defaultAction = "list"
	
	def userService
	
    def list() { 
		def activities = Activity.findAllWhere(project: session.project)
		[activities: activities]
	}
	
	def create() {
		def activityInstance = new Activity()
		def consultants = userService.findByRoleName("CONSULTANT") 
		[activityInstance: activityInstance, consultants: consultants]
	}
	
	def save() {
		def activity = new Activity(params)
		
		if( activity.save() ) {
			redirect(action: "list")
		}
		
		println activity.errors
		
		render view:'create', model: [activityInstance: activity]
	}
}
