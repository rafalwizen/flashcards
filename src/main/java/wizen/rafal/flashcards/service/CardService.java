package wizen.rafal.flashcards.service;

import java.util.List;

import wizen.rafal.flashcards.entity.Card;

public interface CardService {

	public List<Card> findAll();
	public void saveCard(Card card);
	public Card randomFlashcard();
	public void delete(int theId);
	public List<Card> findOnlySameLevel(int level);
	public void moveToNextBucket(int theId);
}
