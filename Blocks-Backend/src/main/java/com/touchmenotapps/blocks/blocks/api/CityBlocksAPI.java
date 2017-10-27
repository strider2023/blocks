package com.touchmenotapps.blocks.blocks.api;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by i7 on 27-10-2017.
 */

@Component
@Path("/blocks/api/ar/city")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityBlocksAPI {

    final private int MIN_HOUSES = 3;
    final private int MAX_HOUSES = 7;

    @GET
    @Path("/generate/city")
    public void getEquations() {

    }

    public void generateCity() {
        int numHouses = ThreadLocalRandom.current().nextInt(MIN_HOUSES, MAX_HOUSES);
    }
}
