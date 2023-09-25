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
		$.get(href, function(vehicleModel, status) {
			$('#idEdit').val(vehicleModel.id);
			$('#descriptionEdit').val(vehicleModel.description);
			$('#detailsEdit').val(vehicleModel.details);
			$('#createdByEdit').val(vehicleModel.createdBy);
			var createdDate = newDate(vehicleModel.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(vehicleModel.lastModifiedBy);
			var lastModifiedDate = newDate(vehicleModel.lastModifiedDate)
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

		$.get(href, function(vehicleModel, status) {
			$('#idDetails').val(vehicleModel.id);
			$('#descriptionDetails').val(vehicleModel.description);
			$('#detailsDetails').val(vehicleModel.details);
			$('#createdByDetails').val(vehicleModel.createdBy);
			$('#createdDateDetails').val(vehicleModel.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleModel.lastModifiedDate.substring(0,10).replace(/-/g, '/'));	
		});
		$('#detailsModal').modal();
	});


});