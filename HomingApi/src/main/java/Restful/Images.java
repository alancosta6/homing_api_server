package Restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Hibernate.TestExample;
import HomingDTO.Honey;

@Path("images")
public class Images {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        
    	
    	try {
    		
    		
            Honey forestHoney = new Honey();
            forestHoney.setName("forest honey");
            forestHoney.setTaste("very sweet");
            
        
            Honey countryHoney = new Honey();
            countryHoney.setName("country honey");
            countryHoney.setTaste("tasty");
            
            
            TestExample.createHoney(forestHoney);
//            TestExample.createHoney(countryHoney);
//        
//            TestExample.listHoney();
//            TestExample.deleteHoney(countryHoney);
//            TestExample.listHoney();
//            forestHoney.setName("Norther Forest Honey");
//            TestExample.updateHoney(forestHoney);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	

//        
    	return "Got it image!";
        
        
    }
}
