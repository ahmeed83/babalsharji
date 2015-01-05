package services;

import model.User;

public interface UserService extends CRUDService<User>{
	public void save(User obj);
}
