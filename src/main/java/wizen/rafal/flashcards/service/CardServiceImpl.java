package wizen.rafal.flashcards.service;

import java.util.List;

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

}
