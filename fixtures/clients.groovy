import org.openpm.Client;
import org.openpm.Country;

fixture {
	build {
		def france = Country.findByName('France')
		def belgium = Country.findByName('Belgium')  
		
		ssii(Client, name:"SSII", contactName:"Societe de service", email:"ssii@pm.org", country: france)
		saas(Client, name:"SAAS", contactName:"Software as a service", email:"sass@pm.org", country: belgium)
		
		
	}
}

