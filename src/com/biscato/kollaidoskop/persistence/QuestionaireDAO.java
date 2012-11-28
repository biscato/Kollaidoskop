package com.biscato.kollaidoskop.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.biscato.kollaidoskop.model.Questionaire;

public class QuestionaireDAO implements EntityDAO<Questionaire> {

	@Override
	public Questionaire createEntity(Questionaire entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Questionaire newEntity;

		try {
			newEntity = pm.makePersistent(entity);
		} finally {
			pm.close();
		}
		return newEntity;
	}

	@Override
	public boolean deleteEntity(Questionaire entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Questionaire updateEntity(Questionaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questionaire getEntityForId(long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		return (Questionaire) pm.getObjectById(Questionaire.class, id);		
	}

	@Override
	public List<Questionaire> getAllEntities() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Questionaire.class);
		Collection<Questionaire> myCol = (Collection<Questionaire>) query.execute();
		return new ArrayList<Questionaire>(myCol);
	}
}
