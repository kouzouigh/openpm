package org.openpm

class ActivityController {
	
	static defaultAction = "list"
	
	def userService
	
    def list() { }
	
	def create() {
		def activityInstance = new Activity();
		def consultants = userService.findByRoleName("CONSULTANT") 
		[activityInstance: activityInstance, consultants: consultants]
	}
}
