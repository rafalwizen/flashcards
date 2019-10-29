package wizen.rafal.flashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wizen.rafal.flashcards.entity.Card;
import wizen.rafal.flashcards.service.CardService;

@Controller
@RequestMapping("/test")
public class CardController {

	private CardService cardService;
	
	@Autowired
	public CardController (CardService theCardService) {
		cardService = theCardService;
	}
	
	// expose "/randomFlashcard"
	@RequestMapping("/game")
	public String randomFlashcard(Model theModel){
		Card tempCard = cardService.randomFlashcard();
		theModel.addAttribute("randomCard", tempCard);
		return "flashcards";
		}
}
