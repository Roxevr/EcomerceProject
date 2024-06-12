// Añade un evento click al botón
function search() {
	var searchLabel = document.getElementById('searchLabel').value;
	window.location.replace = '/productos?filter=' + searchLabel;

};
