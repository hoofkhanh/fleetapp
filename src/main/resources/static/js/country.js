$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(country, status) {
			$('#idEdit').val(country.id);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#descriptionEdit').val(country.description);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});
		$('#editModal').modal();
	});


	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		/* gắn giá trị vào nút confirm */
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(country, status) {
			$('#idDetails').val(country.id);
			$('#capitalDetails').val(country.capital);
			$('#codeDetails').val(country.code);
			$('#descriptionDetails').val(country.description);
			$('#continentDetails').val(country.continent);
			$('#nationalityDetails').val(country.nationality);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#LastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});


});