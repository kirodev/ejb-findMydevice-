package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserRemote {
	
	public boolean Create(User u);
	public boolean Update(User u);
	public boolean deleteById(int id);
	public User findById(int id);
	public List<User> findAll();
	public User findByEmail(String email);



}
