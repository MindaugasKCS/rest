import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class AplicationConfig extends ResourceConfig {
    public AplicationConfig (){
        packages ("rest");
    }

}
