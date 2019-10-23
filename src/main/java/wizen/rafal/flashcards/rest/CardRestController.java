package wizen.rafal.flashcards.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.flashcards.entity.Card;
import wizen.rafal.flashcards.service.CardService;

@RestController
@RequestMapping("/")
public class CardRestController {
	
	private CardService cardService;
	
	// inject card dao with constructor
	@Autowired
	public CardRestController (CardService theCardService) {
		cardService = theCardService;
	}
	
	// TEST
	// expose "/flashcards"
	@GetMapping("/list")
	public List<Card> findAll(){
		System.out.println("find all test");
		return cardService.findAll();
	}
	
	// TEST
	// expose "/randomFlashcard"
	@GetMapping("/card")
	public Card randomFlashcard(){
		System.out.println("random test");
		return cardService.randomFlashcard();
	}
	
	
}
