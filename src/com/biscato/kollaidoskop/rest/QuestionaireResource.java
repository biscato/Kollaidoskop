package com.biscato.kollaidoskop.rest;

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

public class QuestionaireResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Questionaire> getAllQuestionaire() {
		QuestionaireDAO questionaireDAO = new QuestionaireDAO();
		return questionaireDAO.getAllEntities();
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
