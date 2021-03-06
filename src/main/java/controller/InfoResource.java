package controller;

import com.codahale.metrics.annotation.Timed;
import db.InfoDao;
import io.dropwizard.hibernate.UnitOfWork;
import models.InfoModel;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class InfoResource {

    private InfoDao infoDao;

    public InfoResource(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @GET
    @Timed
    @Path("/getName")
    public String getName(){
        return "Harsh";
    }

    @POST
    @Timed
    @Path("/postName")
    public String postName(String name) {
        System.out.println("Name given by : "+name);
        return "Ok";
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/findAllEmp")
    public List<InfoModel> findAllEmp() {
        System.out.println("All Emp  : "+infoDao.findAll());
        return infoDao.findAll();
    }
}
