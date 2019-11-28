package wizen.rafal.flashcards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Card> tempList = cardService.findOnlySameLevel(1);
		theModel.addAttribute("cardsList", tempList);
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
	
	@PostMapping("/save")
	public String save(@ModelAttribute ("tempCard") Card tempCard) {
		
		cardService.saveCard(tempCard);
		return "redirect:/game";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		
		cardService.deleteCard(theId);
		return "redirect:/game";
	}
}
