$(document).ready(function() {
	$("a[data-lang]").click(function() {
		var lang = $(this).attr("data-lang");
		var url = window.location.href;
		if (url.indexOf('?') > -1) {
			url += '&lang=' + lang;
		} else {
			url += '?lang=' + lang;
		}
		$.get(url, function() {
			location.reload();
		});
		return false;
	});
});