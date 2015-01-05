package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBObject;
import com.mongodb.MongoException;






import com.mongodb.util.JSON;

//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.query.Criteria;
//
//import static org.springframework.data.mongodb.core.query.Criteria.*;
//import static org.springframework.data.mongodb.core.query.Query.*;
//
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//
//import com.mongodb.DBObject;
//import com.mongodb.MongoException;
import services.CRUDService;

public class CRUDServiceImpl<T> implements CRUDService<T>{

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	protected final Class<T> entClass;
	
	public CRUDServiceImpl(Class<T> e) {
		this.entClass = e;
	}

	public void persist(T obj) {
		mongoTemplate.save(obj);
	}

	public T getById(String id) {
		T entity = mongoTemplate.findById(id, this.entClass);
		if(entity == null){
			throw new MongoException(123, "Cannot find node id: "+id);
		}
		return entity;
	}

	public List<T> getAll() {
		List<T> entity = mongoTemplate.findAll(this.entClass);
		return entity;
	}

	public T merge(T obj) {
		DBObject dbo= (DBObject) JSON.parse(obj.toString()) ;
		Query q = new Query(Criteria.where("id").is(dbo.get("id")));
		Update u = Update.fromDBObject(dbo, "");
		System.out.println("CRUD merge object");
		return mongoTemplate.findAndModify(q, u, this.entClass); 
	}

	public void delete(String id) {
		DBObject dbo = (DBObject) new Object();
		dbo.put("id", id);
		Query q = new Query(Criteria.where("id").is(dbo));
		mongoTemplate.remove(q, this.entClass);
	}

	public void delete(T obj) {
		mongoTemplate.remove(obj);
	}

	public void deleteAll() {
//		String collection = this.entClass.getAnnotation(Document.class).collection();
		Query q = new Query();
		mongoTemplate.findAllAndRemove(q, this.entClass);
	}

}
