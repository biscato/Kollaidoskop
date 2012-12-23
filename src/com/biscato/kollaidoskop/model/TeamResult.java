package com.biscato.kollaidoskop.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.biscato.kollaidoskop.persistence.AnswerDAO;

@XmlRootElement
public class TeamResult {
	
	private float vision;
	private float security;
	private float taskOrientation;
	private float innovation;
	private float structure;
	private float virtualCompetence;
	
	public TeamResult(){
		super();
		initFloats();
		gatherData();
	}
	
	public TeamResult(long from, long to, String team){
		super();
		initFloats();
		gatherData(from, to, team);
	}
	
	private void initFloats(){
		this.vision = 0;
		this.innovation = 0;
		this.security = 0;
		this.structure = 0;
		this.taskOrientation = 0;
		this.virtualCompetence = 0;
	}
	
	private void gatherData(){
		//get all answers
		ArrayList<Answer> answers = new ArrayList();
		AnswerDAO answer = new AnswerDAO();
		answers = (ArrayList<Answer>) answer.getAllEntities();
		
		int visionCounter = 0;
		int securityCounter = 0;
		int taskOrientationCounter = 0;
		int innovationCounter = 0;
		int structureCounter = 0;
		int virtualCompetenceCounter = 0;
		
		int categoryId;
		
		for(int i = 0; i < answers.size(); i++){
			categoryId = answers.get(i).getQuestionCategoryId();
			//TODO: need a safer matching of category ID since the client triggers the creation with the ids
			if(categoryId == 1){
				vision += answers.get(i).getRating();
				visionCounter++;
			}
			else if(categoryId == 2){
				innovation += answers.get(i).getRating();
				innovationCounter++;
			}
			else if(categoryId == 3){
				taskOrientation += answers.get(i).getRating();
				taskOrientationCounter++;
			}
			else if(categoryId == 4){
				security += answers.get(i).getRating();
				securityCounter++;
			}
			else if(categoryId == 5){
				structure += answers.get(i).getRating();
				structureCounter++;
			}
			else if(categoryId == 6){
				virtualCompetence += answers.get(i).getRating();
				virtualCompetenceCounter++;
			}
		}
		
		if(visionCounter > 0)
			vision /= visionCounter;
		if(securityCounter > 0)
			security /= securityCounter;
		if(taskOrientationCounter > 0)
			taskOrientation /= taskOrientationCounter;
		if(innovationCounter > 0)
			innovation /= innovationCounter;
		if(structureCounter > 0)
			structure /= structureCounter;
		if(virtualCompetenceCounter > 0)
			virtualCompetence /= virtualCompetenceCounter;

	}

	private void gatherData(long from, long to, String team){
		//TODO: return team results based on timeframe and team
	}

	public float getVision() {
		return vision;
	}

	public void setVision(float vision) {
		this.vision = vision;
	}

	public float getSecurity() {
		return security;
	}

	public void setSecurity(float security) {
		this.security = security;
	}

	public float getTaskOrientation() {
		return taskOrientation;
	}

	public void setTaskOrientation(float taskOrientation) {
		this.taskOrientation = taskOrientation;
	}

	public float getInnovation() {
		return innovation;
	}

	public void setInnovation(float innovation) {
		this.innovation = innovation;
	}

	public float getStructure() {
		return structure;
	}

	public void setStructure(float structure) {
		this.structure = structure;
	}

	public float getVirtualCompetence() {
		return virtualCompetence;
	}

	public void setVirtualCompetence(float virtualCompetence) {
		this.virtualCompetence = virtualCompetence;
	}
	
}
