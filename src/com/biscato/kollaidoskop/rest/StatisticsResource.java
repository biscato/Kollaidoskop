package com.biscato.kollaidoskop.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.biscato.kollaidoskop.model.TeamResult;

@Path("/statistics")
public class StatisticsResource {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TeamResult getTeamResults(){
		return new TeamResult();
	}

}