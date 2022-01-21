package dao;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserLocal {

	public boolean Create(User u);
	public boolean Update(User u);
	public boolean deleteById(int id);
	public User findById(int id);
	public List<User> findAll();
	public User findByEmail(String email);
	
}
