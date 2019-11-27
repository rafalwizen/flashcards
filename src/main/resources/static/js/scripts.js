function changeVisibility() {
	let p = document.getElementById('pl');
	p.removeAttribute("hidden");
}

function nextCard() {
	let r = document.getElementById('pl').textContent;
	document.getElementById('en').innerHTML = r;
}