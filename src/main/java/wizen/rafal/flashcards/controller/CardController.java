package wizen.rafal.flashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wizen.rafal.flashcards.entity.Card;
import wizen.rafal.flashcards.service.CardService;

@Controller
@RequestMapping("/")
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
	
	// expose
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create new attribute to bind form data
		Card tempCard = new Card();
		
		theModel.addAttribute("tempCard", tempCard);
		
		return "add-flashcard";
	}
	
}
