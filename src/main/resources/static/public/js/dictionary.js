$(document).ready(function() {
	var currentPage = 1;
	$("#getMore").click(function(e) {
		$.get("/dictionary/more-result", {
			search : "${key}",
			page : currentPage
		}, function(data, status) {
			if (data.length < 40) {
				$("#getMore").off("click");
				$("#getMore").remove();
			}
			for ( var x in data) {
				$("#table-result tr:last")
					.after('<tr><td><div class="text-success"><strong>' + data[x].en + '</strong></div><div>' + data[x].vi + '</div></td></tr>');
			}
		});
		currentPage++;
	});
});