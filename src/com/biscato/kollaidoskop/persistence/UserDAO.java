package com.biscato.kollaidoskop.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.biscato.kollaidoskop.model.Answer;
import com.biscato.kollaidoskop.model.Team;
import com.biscato.kollaidoskop.model.User;

public class UserDAO implements EntityDAO<User> {

	@Override
	public User createEntity(User entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		User newEntity;
		
		try{
			newEntity = pm.makePersistent(entity);
		}
		finally{
			pm.close();
		}
		return newEntity;
	}

	@Override
	public List<User> createAllEntities(List<User> entities) {
		Collection<User> newEntities;
		List createdUsers;
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Collection<User> collection = new ArrayList<User>(entities);
		
		try{
			newEntities = pm.makePersistentAll(collection);
		}
		finally{
			pm.close();
		}
		createdUsers = new ArrayList(newEntities);
		return createdUsers;
	}

	@Override
	public boolean deleteEntity(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllEntities() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updateEntity(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEntityForId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

}
