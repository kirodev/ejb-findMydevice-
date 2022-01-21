package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Smartphone;
import entities.User;

@Remote
public interface SmartphoneRemote {

	public boolean Create(Smartphone s);
	public boolean Update(Smartphone s);
	public boolean deleteById(int id);
	public Smartphone findById(int id);
	public List<Smartphone> findAllid(int id);
	public List<Smartphone> findAll();

	
}
