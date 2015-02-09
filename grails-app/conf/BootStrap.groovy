import storagectrl.auth.*

class BootStrap {

    def init = { servletContext ->

    	def springSecurityService

    	def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save()
		def admin = User.findByUsername('admin') ?: new User(
			username : 'admin',
			password : "admin",
			enabled : true).save()
    	def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save()
		def user = User.findByUsername('user') ?: new User(
			username : 'user',
			password : "user",
			enabled : true).save()
		
		if(!admin.authorities.contains(adminRole) ){
			UserRole.create(admin, adminRole, true).save()		
		}
		if(!user.authorities.contains(userRole) ){
			UserRole.create(user, userRole, true).save()
		}
	}
    def destroy = {
    }
}
