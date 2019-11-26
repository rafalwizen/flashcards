package wizen.rafal.flashcards.service;

import java.util.List;

import wizen.rafal.flashcards.entity.Card;

public interface CardService {

	public List<Card> findAll();
	public Card randomFlashcard();
	public void saveCard(Card card);
	public void deleteCard(int theId);
}
