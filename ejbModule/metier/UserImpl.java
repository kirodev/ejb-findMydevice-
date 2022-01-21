package metier;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import dao.UserLocal;
import dao.UserRemote;
import entities.User;

@Stateless
public class UserImpl implements UserRemote,UserLocal{
	@PersistenceContext
	private EntityManager em;


	@Override
	@Transactional

	public boolean Create(User u) {
		em.persist(u);
		return true;
	}

	@Override
	@Transactional
	public boolean Update(User u) {
		if (u.getId() == 0 && u.getEmail() == null) {
			return false;
		}
		if (u.getId() != 0) {
			User updatedUser = em.find(User.class, u.getId());
			updatedUser.setNom(u.getNom());
			updatedUser.setPrenom(u.getPrenom());
			updatedUser.setTele(u.getTele());
			updatedUser.setdateNaissance(u.getdateNaissance());
			em.merge(updatedUser);
			return true;
		} else if (u.getEmail() != null) {
			User oldUser = findByEmail(u.getEmail());
			oldUser.setNom(u.getNom());
			oldUser.setPrenom(u.getPrenom());
			oldUser.setTele(u.getTele());
			oldUser.setdateNaissance(u.getdateNaissance());
			em.merge(oldUser);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		em.remove(user);
		return true;
	}



	@Override
	public User findById(int id) {
		return em.find(User.class,id);
	}

	@Override
	public List<User> findAll() {
		 List<User> result = em.createQuery("from User").getResultList();
		return result;
	}

	@Override
	public User findByEmail(String email) {
		List<User> allUsers = findAll();
		for (User u : allUsers) {
			if (u.getEmail().equals(email)) return u;
		}
		return null;
	}










}



