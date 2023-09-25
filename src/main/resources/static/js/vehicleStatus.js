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
		$.get(href, function(vehicleStatus, status) {
			$('#idEdit').val(vehicleStatus.id);
			$('#descriptionEdit').val(vehicleStatus.description);
			$('#detailsEdit').val(vehicleStatus.details);
			$('#createdByEdit').val(vehicleStatus.createdBy);
			var createdDate = newDate(vehicleStatus.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(vehicleStatus.lastModifiedBy);
			var lastModifiedDate = newDate(vehicleStatus.lastModifiedDate)
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

		$.get(href, function(vehicleStatus, status) {
			$('#idDetails').val(vehicleStatus.id);
			$('#descriptionDetails').val(vehicleStatus.description);
			$('#detailsDetails').val(vehicleStatus.details);
			$('#lastModifiedByDetails').val(vehicleStatus .lastModifiedBy);
			$('#createdByDetails').val(vehicleStatus.createdBy);
			$('#createdDateDetails').val(vehicleStatus.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(vehicleStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleStatus.lastModifiedDate.substring(0,10).replace(/-/g, '/'));	
		});
		$('#detailsModal').modal();
	});


});