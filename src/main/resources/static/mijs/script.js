
function filtrar() {
	var searchlabel = document.getElementById("searchlabel").value;
	if (searchlabel == null || searchlabel == "") {
		window.location.href = "/productos";
	} else {
		window.location.href = "/productos?filter=" + searchlabel;
	}

};
