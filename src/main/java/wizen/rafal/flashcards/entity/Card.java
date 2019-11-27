package wizen.rafal.flashcards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="english")
	private String english;
	
	@Column(name="polish")
	private String polish;
	
	@Column(name="level")
	private int level;
	
	public Card() {
		
	}
	
	public Card(String english, String polish) {
		this.english = english;
		this.polish = polish;
		//every word start as level 1
		this.level = 1;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getPolish() {
		return polish;
	}

	public void setPolish(String polish) {
		this.polish = polish;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
