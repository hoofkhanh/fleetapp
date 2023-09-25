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
		$.get(href, function(vehicleType, status) {
			$('#idEdit').val(vehicleType.id);
			$('#descriptionEdit').val(vehicleType.description);
			$('#detailsEdit').val(vehicleType.details);
			$('#createdByEdit').val(vehicleType.createdBy);
			var createdDate = newDate(vehicleType.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(vehicleType.lastModifiedBy);
			var lastModifiedDate = newDate(vehicleType.lastModifiedDate)
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

		$.get(href, function(vehicleType, status) {
			$('#idDetails').val(vehicleType.id);
			$('#descriptionDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);
			$('#createdByDetails').val(vehicleType.createdBy);
			$('#createdDateDetails').val(vehicleType.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substring(0,10).replace(/-/g, '/'));	
		});
		$('#detailsModal').modal();
	});


});