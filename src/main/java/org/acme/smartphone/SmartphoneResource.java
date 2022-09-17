package org.acme.smartphone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/smartphone")
public class SmartphoneResource {
    private final Set<Smartphone> smartphones = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    private SmartphoneResource() {
        smartphones.add(new Smartphone("iPhone 12", BigDecimal.valueOf(999.99)));
        smartphones.add(new Smartphone("Samsung Galaxy S21", BigDecimal.valueOf(799.99)));
        smartphones.add(new Smartphone("Google Pixel 5", BigDecimal.valueOf(699.99)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Smartphone> getSmartphones() {
        return smartphones;
    }

    @GET
    @Path("/response")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSmartphonesResponse() {
        return Response.accepted(smartphones).build();
    }
}
