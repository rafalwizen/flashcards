function changeVisibility() {
	let p = document.getElementById('pl');
	//p.removeAttribute("hidden");
	p.hidden = false;
}

function nextCard(cardsList) {
	var rand = Math.ceil(Math.random()*cardsList.length);
	document.getElementById('en').innerHTML = cardsList[rand].english;
	document.getElementById('pl').innerHTML = cardsList[rand].polish;
	let p = document.getElementById('pl');
	p.hidden = true;
}