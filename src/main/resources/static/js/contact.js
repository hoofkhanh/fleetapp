$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(contact, status) {
			$('#idEdit').val(contact.id);
			$('#firstNameEdit').val(contact.firstname);
			$('#lastNameEdit').val(contact.lastname);
			$('#emailEdit').val(contact.email);
			$('#mobileEdit').val(contact.mobile);
			$('#phoneEdit').val(contact.phone);
			$('#remarksEdit').val(contact.remarks);
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

		$.get(href, function(contact, status) {
			$('#idDetails').val(contact.id);
			$('#firstNameDetails').val(contact.firstname);
			$('#lastNameDetails').val(contact.lastname);
			$('#emailDetails').val(contact.email);
			$('#mobileDetails').val(contact.mobile);
			$('#phoneDetails').val(contact.phone);
			$('#remarksDetails').val(contact.remarks);
		});
		$('#detailsModal').modal();
	});


});