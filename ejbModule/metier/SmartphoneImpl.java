package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import dao.SmartphoneRemote;
import dao.SmartphoneLocal;

import entities.User;
import entities.Smartphone;

@Stateless
public class SmartphoneImpl implements SmartphoneRemote,SmartphoneLocal{
	@PersistenceContext
	private EntityManager em;

	private UserImpl userImpl = new UserImpl();

	@Override
	@Transactional
	public boolean Create(Smartphone s) {
        em.persist(s);
		return true;
	}

	@Override
	@Transactional
	public boolean Update(Smartphone s) {
		if (s.getId() == 0 && s.getMarque() == null) {
			return false;
		}
		if (s.getId() != 0) {
			Smartphone updatedSmartphone = em.find(Smartphone.class,s.getId());
			updatedSmartphone.setMarque(s.getMarque());
			em.merge(updatedSmartphone);
			return true;
		} else if (s.getMarque() != null) {
			Smartphone updatedSmartphone = findById(s.getId());
			updatedSmartphone.setMarque(s.getMarque());

			em.merge(updatedSmartphone);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		Smartphone sm = em.find(Smartphone.class, id);
		em.remove(sm);
		return true;
	}



	@Override
	public Smartphone findById(int id) {
		return em.find(Smartphone.class,id);
	}

	@Override
	public List<Smartphone> findAllid(int id) {
		 List<Smartphone> result = em.createQuery("from Smartphone where id ="+id).getResultList();
		return result;
	}
	@Override
	public List<Smartphone> findAll() {
		 List<Smartphone> result = em.createQuery("from Smartphone").getResultList();
		return result;
	}




	}














