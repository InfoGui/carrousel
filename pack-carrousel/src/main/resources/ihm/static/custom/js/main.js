$(document).ready(function() {
	console.log("JS Chargé : rechargement de la page toute les 10 min");

	setTimeout(function() {
		location.reload();
	}, 600000);
	
	$('.carousel').carousel({
	  interval: 5000
	})
});