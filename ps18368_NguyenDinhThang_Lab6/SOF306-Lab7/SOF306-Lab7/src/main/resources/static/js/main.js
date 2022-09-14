jQuery(function($) {
	"use strict";

	//Counter Up
	$('.count').counterUp({ delay: 40, time: 3000 });
	$('.dropdown-menu a.dropdown-toggle').on('click', function(e) {
		if (!$(this).next().hasClass('show')) {
			$(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
		}
		var $subMenu = $(this).next(".dropdown-menu");
		$subMenu.toggleClass('show');

		$(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
			$('.dropdown-submenu .show').removeClass("show");
		});
		return false;
	});

	$(document).ready(function() {
		$('.table').DataTable();
	});
});