package com.biscato.kollaidoskop.persistence;

import java.util.List;

public interface EntityDAO<T> {
	//TODO: read about JAVA-generics --> "<>" notation
	public T createEntity(T entity);
	public boolean deleteEntity(T entity);
	public T updateEntity(T entity);
	public T getEntityForId(long id);
	public List<T> getAllEntities();

}
