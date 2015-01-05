package services;

import java.util.List;

public interface CRUDService<T> {

	void persist(T obj);
	
	T getById(String id);
	List<T> getAll();
	
	T merge(T obj);
	
	void delete(String id);
	void delete(T obj);
	void deleteAll();

}