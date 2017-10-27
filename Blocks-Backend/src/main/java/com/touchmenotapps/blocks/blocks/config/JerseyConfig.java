package com.touchmenotapps.blocks.blocks.config;

import com.touchmenotapps.blocks.blocks.api.BlocksChemistryAPI;
import com.touchmenotapps.blocks.blocks.api.BlocksUserAPI;
import com.touchmenotapps.blocks.blocks.api.HealthCheckAPI;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by i7 on 27-10-2017.
 */

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(HealthCheckAPI.class);
        register(BlocksUserAPI.class);
        register(BlocksChemistryAPI.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
