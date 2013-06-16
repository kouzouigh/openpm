package org.openpm

class UserService {

    def findByRoleName(roleName) {
		def criteria = User.createCriteria()
		criteria.list {
			roles {
				eq('name', roleName)
			}
		}
    }
}
