package wizen.rafal.flashcards.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.flashcards.entity.Card;
import wizen.rafal.flashcards.service.CardService;

@RestController
@RequestMapping("/api")
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
		System.out.println("test");
		return cardService.findAll();
	}
}
