package services.impl;

import model.User;
import services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends CRUDServiceImpl<User> implements UserService {

	public UserServiceImpl() {
		super(User.class);
	}	

}