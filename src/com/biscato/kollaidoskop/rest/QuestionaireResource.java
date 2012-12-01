package com.biscato.kollaidoskop.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.biscato.kollaidoskop.model.Questionaire;
import com.biscato.kollaidoskop.persistence.QuestionaireDAO;

@Path("/questionaire")
public class QuestionaireResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Questionaire> getAllQuestionaire() {
		QuestionaireDAO questionaireDAO = new QuestionaireDAO();

		Questionaire newEntry1 = new Questionaire("Created by Code 1");
		Questionaire newEntry2 = new Questionaire("Created by Code 2");
		Questionaire newEntry3 = new Questionaire("Created by Code 3");
		ArrayList<Questionaire> list = new ArrayList<Questionaire>();
		list.add(newEntry1);
		list.add(newEntry2);
		list.add(newEntry3);
		
		System.out.println("in get method of questionaire RESOURCE");
		
		questionaireDAO.createEntity(newEntry1);
		// 		return questionaireDAO.getAllEntities();
		return list;
		
	}

	@GET
	@Path("{id}")
	public Questionaire getQuestionaireForId(@PathParam("id") long id) {
		QuestionaireDAO questionaireDAO = new QuestionaireDAO();
		return questionaireDAO.getEntityForId(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Questionaire createQuestionaire(Questionaire newQuestionaire)	 {
		QuestionaireDAO questionaireDAO = new QuestionaireDAO();
		return questionaireDAO.createEntity(newQuestionaire);
	}
}
