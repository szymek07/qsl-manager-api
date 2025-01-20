package pl.sp6pat.qsl.manager.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import pl.sp6pat.qsl.manager.entity.QslCardsToPickup;
import pl.sp6pat.qsl.manager.service.QslService;

import java.util.List;

@Path("/qsl")
public class QslController {

    @Inject
    QslService qslService;

    @GET
    @Path("/to-pickup")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QslCardsToPickup> toPickup(@QueryParam("call") String call) {
        return qslService.toPickup(call);
    }

    @GET
    @Path("/is-call-serviced")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isCallServiced(@QueryParam("call") String call) {
        return qslService.isCallServiced(call);
    }

}
