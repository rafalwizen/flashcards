package wizen.rafal.flashcards.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.flashcards.dao.CardDAO;
import wizen.rafal.flashcards.entity.Card;

@Service
public class CardServiceImpl implements CardService {

	private CardDAO cardDAO;
	
	@Autowired
	public CardServiceImpl (CardDAO theCardDAO) {
		cardDAO = theCardDAO;
	}
	
	@Override
	@Transactional
	public List<Card> findAll() {
		
		return cardDAO.findAll();
	}

	// method to return random flashcard from database
	@Override
	@Transactional
	public Card randomFlashcard() {
		List<Card> tempList = cardDAO.findAll();
		Random random = new Random();
		int randomNumber = random.nextInt(tempList.size());
		return tempList.get(randomNumber);
	}

	@Override
	@Transactional
	public void saveCard(Card card) {
		
		cardDAO.saveCard(card);
	}

	@Override
	@Transactional
	public void deleteCard(int theId) {

		cardDAO.deleteCard(theId);
	}

}
