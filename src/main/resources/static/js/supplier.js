$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(supplier, status) {
			$('#idEdit').val(supplier.id);
			$('#nameEdit').val(supplier.name);
			$('#detailsEdit').val(supplier.details);
			$('#websiteEdit').val(supplier.website);
			$('#addressEdit').val(supplier.address);
			$('#cityEdit').val(supplier.city);
			$('#stateEdit').val(supplier.stateid);
			$('#countryEdit').val(supplier.countryid);
			$('#phoneEdit').val(supplier.phone);
			$('#mobileEdit').val(supplier.mobile);
			$('#emailEdit').val(supplier.email);
		});
		$('#editModal').modal();
	});

$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(supplier, status) {
			$('#idDetails').val(supplier.id);
			$('#nameDetails').val(supplier.name);
			$('#detailsDetails').val(supplier.details);
			$('#websiteDetails').val(supplier.website);
			$('#addressDetails').val(supplier.address);
			$('#cityDetails').val(supplier.city);
			$('#stateDetails').val(supplier.stateid);
			$('#countryDetails').val(supplier.countryid);
			$('#phoneDetails').val(supplier.phone);
			$('#mobileDetails').val(supplier.mobile);
			$('#emailDetails').val(supplier.email);
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