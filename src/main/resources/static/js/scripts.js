var language = true; //if true it's English, if false it's Polish
var cardsList = /*[[${cardsList}]]*/ 'default_text_error';
var currentCardId = cardsList[0].id;

function changeVisibility() {
	let p = document.getElementById('answer');
	//p.removeAttribute("hidden");
	p.hidden = false;
}

function nextCard(cardsList) {
	var rand = Math.ceil(Math.random()*cardsList.length);
	if(language){
	document.getElementById('toSolve').innerHTML = cardsList[rand].english;
	document.getElementById('answer').innerHTML = cardsList[rand].polish;
	} else {
		document.getElementById('toSolve').innerHTML = cardsList[rand].polish;
		document.getElementById('answer').innerHTML = cardsList[rand].english;	
	}
	currentCardId = cardsList[rand].id;
	let p = document.getElementById('answer');
	p.hidden = true;
}

function changeToSolveLanguage(cardsList){
	language = !language;
	nextCard(cardsList);
}

function deleteCurrentCard() {
	if(!(confirm('Are you sure you want to delete this flashcard?'))) return false
	document.getElementById('deleteField').value = currentCardId;
	return true;
}

function moveToNextBucket() {
	document.getElementById('moveToNextValue').value = currentCardId;
}