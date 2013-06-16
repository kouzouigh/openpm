import grails.util.Environment;

import org.openpm.Country
import org.openpm.Role
import org.openpm.User


class BootStrap {
	def fixtureLoader
	def shiroSecurityService

	def init = { servletContext ->
		
		// Loading dev data
		if ( Environment.current == Environment.DEVELOPMENT)  {
			println "Loading fixture data"
			fixtureLoader.with {
				load("countries")
				load("clients")
			}
		}
		
		def country = Country.findByName('France')

		// Create the admin role
		def adminRole = Role.findByName('ADMIN') ?:
			new Role(name: 'ADMIN').save(flush: true, failOnError: true)
			
		// Create Project Manager role
		def pmRole = Role.findByName('PROJECT_MANAGER') ?:
			new Role(name: 'PROJECT_MANAGER').save(flush: true, failOnError: true)
			
		// Create the user role
		def consultantRole = Role.findByName('CONSULTANT') ?:
			new Role(name: 'CONSULTANT').save(flush: true, failOnError: true)

		// Create an admin user
		def adminUser = User.findByUsername('admin') ?:
			new User(username: "admin",
					email: "admin@company.com",
					code: 'ADM',
					country: country,
					passwordHash: shiroSecurityService.encodePassword('password'))
					.save(flush: true, failOnError: true)

		// Add roles to the admin user
		assert adminUser.addToRoles(adminRole)
				.addToRoles(consultantRole)
				.addToRoles(pmRole)
				.save(flush: true, failOnError: true)

		// Create an standard user
		def standardUser = User.findByUsername('joe') ?:
			new User(username: "joe",
					 code: 'JOE',
					 email: "joe@company.com",
					 country: country,
					 passwordHash: shiroSecurityService.encodePassword('password'))
					.save(flush: true, failOnError: true)

		// Add role to the standard user
		assert standardUser.addToRoles(consultantRole)
				.save(flush: true, failOnError: true)
				
		// create a project manager user
		def pmUser = User.findByUsername('project manager') ?:
					new User(username: "project manager",
							 email: 'pm@company.com',
							 code: 'PMU',
							 country: country,
							 passwordHash: shiroSecurityService.encodePassword('password'))
					.save(flush: true, failOnError: true)
					
		// Add role to project maager user
		assert pmUser.addToRoles(pmRole)
				.save(flush: true, failOnError: true)
	}
	
	def destroy = {
	}
}