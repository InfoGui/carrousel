$(document).ready(function() {
	console.log("Rechargement de la page toutes les 10 min");
	setTimeout(function() {
		location.reload();
	}, 600000);
	
	console.log("Defilement des images toutes les 5 secondes");
	$('.carousel').carousel({
	  interval: 5000,
	  pause: false
	})
});