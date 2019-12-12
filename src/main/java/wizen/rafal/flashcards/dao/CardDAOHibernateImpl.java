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
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Card> theQuery = currentSession.createQuery("from Card", Card.class);
		List<Card> cards = theQuery.getResultList();

		return cards;
	}


	@Override
	public void saveCard(Card card) {		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(card);
	}

	@Override
	public void deleteCard(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Card where id=:cardId");
		theQuery.setParameter("cardId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Card> findOnlySameLevel(int level) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Card> theQuery = currentSession.createQuery("from Card where level=:levelNum", Card.class);
		theQuery.setParameter("levelNum", level);
		List<Card> cards = theQuery.getResultList();
		
		return cards;
	}

	@Override
	public Card findCardById (int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.get(Card.class, theId);
	}

}
