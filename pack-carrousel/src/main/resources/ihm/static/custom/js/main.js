$(document).ready(function() {
	console.log("JS Chargé !");

	console.log("Rechargement de la page toutes les 10 min");
	setTimeout(function() {
		location.reload();
	}, 600000);
	
	console.log("Défilement des images toutes les 5 secondes");
	$('.carousel').carousel({
	  interval: 5000
	})
});