package org.openpm

class ActivityController {
	
	static defaultAction = "list"
	
    def list() { }
	
	def create() {
		def activityInstance = new Activity();
		[activityInstance: activityInstance]
	}
}
