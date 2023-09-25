$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(client, status) {
			$('#idEdit').val(client.id);
			$('#nameEdit').val(client.name);
			$('#detailsEdit').val(client.details);
			$('#websiteEdit').val(client.website);
			$('#addressEdit').val(client.address);
			$('#cityEdit').val(client.city);
			$('#stateEdit').val(client.stateid);
			$('#countryEdit').val(client.countryid);
			$('#phoneEdit').val(client.phone);
			$('#mobileEdit').val(client.mobile);
			$('#emailEdit').val(client.email);
		});
		$('#editModal').modal();
	});

$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(client, status) {
			$('#idDetails').val(client.id);
			$('#nameDetails').val(client.name);
			$('#detailsDetails').val(client.details);
			$('#websiteDetails').val(client.website);
			$('#addressDetails').val(client.address);
			$('#cityDetails').val(client.city);
			$('#stateDetails').val(client.stateid);
			$('#countryDetails').val(client.countryid);
			$('#phoneDetails').val(client.phone);
			$('#mobileDetails').val(client.mobile);
			$('#emailDetails').val(client.email);
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		/* gắn giá trị vào nút confirm */
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();
	});

	


});