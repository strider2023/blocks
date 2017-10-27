package com.touchmenotapps.blocks.blocks.api;

import com.touchmenotapps.blocks.blocks.dao.User;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by i7 on 27-10-2017.
 */

@Component
@Path("/blocks/api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlocksUserAPI {

    @GET
    @Path("/{employeeId}")
    public User getEmployee(@PathParam("employeeId") Integer employeeId) {
        User user = new User();
        user.setId(Long.valueOf(employeeId.longValue()));
        return new User();
    }
}
