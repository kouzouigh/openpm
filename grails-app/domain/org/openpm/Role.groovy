package org.openpm

class Role {
	String name
	
	static hasMany = [ users: User, permissions: String ]
	static belongsTo = User
	
	static mapping = {
		cache true
	}
	
    static constraints = {
		name(nullable: false, blank: false, unique: true)
    }
	
	@Override
	public String toString() {
		return name
	}
}
