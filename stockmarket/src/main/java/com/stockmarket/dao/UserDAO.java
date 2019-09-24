package com.stockmarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.User;
import com.stockmarket.repository.UserRepository;
@Service
public class UserDAO {
	 @Autowired
	 UserRepository userRepository;
	 
	 public List<User> getAllUsers(){
		 	List<User> userList=userRepository.findAll();
		 	 if(userList.size() > 0) {
		            return userList;
		        } else {
		            return new ArrayList<User>();
		        }
	 }
	 
	 
	 
	public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = userRepository.findById(id);
         
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }





	public User createOrUpdateUser(User entity) throws RecordNotFoundException
    {
        Optional<User> user = userRepository.findById(entity.getId());
         
        if(user.isPresent())
        {
            User newEntity = user.get();
            newEntity.setName(entity.getName());
            newEntity.setPassword(entity.getPassword());
            newEntity.setEmail(entity.getEmail());
            newEntity.setIsactivated(entity.isIsactivated());
            
 
            newEntity = userRepository.save(newEntity);
             
            return newEntity;
        } 
        else {
            entity = userRepository.save(entity);
             
            return entity;
        }
    }


  public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = userRepository.findById(id);
         
        if(user.isPresent())
        {
            userRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

  

	/* get an User by email and Password*/
	public User findByEmailPass(String email,String password) {
		User user=new User();
		user.setEmail(email);
		//user.setPassword(password);
		Example<User> userExample=Example.of(user);
		//calling QueryByExampleExecutor#findAll(Example)
		Iterable<User> users = userRepository.findAll(userExample);
		User em = null;
		for(User e:users)
			em=e;
		return em;
	}
  
 
}
