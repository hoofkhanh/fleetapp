function newDate (date){
	var newDate = new Date(date);
	return newDate;
}

$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(invoiceStatus, status) {
			$('#idEdit').val(invoiceStatus.id);
			$('#descriptionEdit').val(invoiceStatus.description);
			$('#detailsEdit').val(invoiceStatus.details);
			$('#createdByEdit').val(invoiceStatus.createdBy);
			var createdDate = newDate(invoiceStatus.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(invoiceStatus.lastModifiedBy);
			var lastModifiedDate = newDate(invoiceStatus.lastModifiedDate)
			$('#lastModifiedDateEdit').val(lastModifiedDate);	
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

		$.get(href, function(invoiceStatus, status) {
			$('#idDetails').val(invoiceStatus.id);
			$('#descriptionDetails').val(invoiceStatus.description);
			$('#detailsDetails').val(invoiceStatus.details);
			$('#lastModifiedByDetails').val(invoiceStatus.lastModifiedBy);
		$('#createdByDetails').val(invoiceStatus.createdBy);
			$('#createdDateDetails').val(invoiceStatus.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(invoiceStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoiceStatus.lastModifiedDate.substring(0,10).replace(/-/g, '/'));
		});
		$('#detailsModal').modal();
	});


});