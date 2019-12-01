package ro.dragos.dao.spec;

import java.util.List;

public interface IDao<T> {

	public List<T> findAll();
	public void save(T obj);
	
	// public List<T> findByName(String name);
	
}
