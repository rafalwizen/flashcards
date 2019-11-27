package wizen.rafal.flashcards.dao;

import java.util.List;

import wizen.rafal.flashcards.entity.Card;

public interface CardDAO {

	// TEST method
	public List<Card> findAll();
	public void saveCard(Card card);
	public void deleteCard(int theId);
	public List<Card> findOnlySameLevel(int level);
}
