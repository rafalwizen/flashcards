package wizen.rafal.flashcards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wizen.rafal.flashcards.entity.Card;
import wizen.rafal.flashcards.service.CardService;

@Controller
public class CardController {

	private CardService cardService;
	
	// expose "/randomFlashcard"
	@GetMapping("/game")
	public String randomFlashcard(Model theModel){
		Card tempCard = cardService.randomFlashcard();
		//theModel.addAttribute("randomCard", tempCard);
		return "flashcards";
		}
}
