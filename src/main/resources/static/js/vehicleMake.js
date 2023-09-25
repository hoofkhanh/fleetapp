
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
		$.get(href, function(vehicleMake, status) {
			$('#idEdit').val(vehicleMake.id);
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
			$('#createdByEdit').val(vehicleMake.createdBy);
			var createdDate = newDate(vehicleMake.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(vehicleMake.lastModifiedBy);
			var lastModifiedDate = newDate(vehicleMake.lastModifiedDate)
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

		$.get(href, function(vehicleMake, status) {
			$('#idDetails').val(vehicleMake.id);
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
			$('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
			$('#createdByDetails').val(vehicleMake.createdBy);
			$('#createdDateDetails').val(vehicleMake.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substring(0,10).replace(/-/g, '/'));
		});
		$('#detailsModal').modal();
	});


});