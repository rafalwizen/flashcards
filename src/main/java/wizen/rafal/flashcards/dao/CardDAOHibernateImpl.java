package wizen.rafal.flashcards.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wizen.rafal.flashcards.entity.Card;

@Repository
public class CardDAOHibernateImpl implements CardDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	@Autowired
	public CardDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Card> findAll() {

		// get current hibernate session by unwrap
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Card> theQuery = currentSession.createQuery("from Card", Card.class);
		
		// execute query and get result list 
		List<Card> cards = theQuery.getResultList();
		
		// return result
		return cards;
	}


	@Override
	public void saveCard(Card card) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(card);
	}

	@Override
	public void deleteCard(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		//currentSession.de
	}

}
