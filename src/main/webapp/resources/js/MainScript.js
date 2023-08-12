/**
 * 
 */
function toggleFade() {
	const activeElement = document.querySelector('.header_fade.active');
	const disactiveElement = document.querySelector('.header_fade.disactive');

	activeElement.classList.remove('active');
	activeElement.classList.add('disactive');
	disactiveElement.classList.remove('disactive');
	disactiveElement.classList.add('active');
}

setInterval(toggleFade, 4000);