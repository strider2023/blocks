package com.touchmenotapps.blocks.blocks.api;

import com.touchmenotapps.blocks.blocks.dao.Equations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
@Path("/blocks/api/ar/chemistry")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlocksChemistryAPI {

    private List<Equations> equationsList = new ArrayList<>();

    @GET
    @Path("/equations")
    public List<Equations> getEquations() {
        equationsList.clear();
        //TODO Create a list for demo
        Equations equations = new Equations();
        equations.addDemoEquation();
        equationsList.add(equations);
        return equationsList;
    }
}
