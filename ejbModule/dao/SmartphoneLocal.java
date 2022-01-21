package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Smartphone;

@Local
public interface SmartphoneLocal {

	public boolean Create(Smartphone s);
	public boolean Update(Smartphone s);
	public boolean deleteById(int id);
	public Smartphone findById(int id);
	public List<Smartphone> findAllid(int id);
	public List<Smartphone> findAll();
	
}

