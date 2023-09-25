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
		$.get(href, function(employeeType, status) {
			$('#idEdit').val(employeeType.id);
			$('#descriptionEdit').val(employeeType.description);
			$('#detailsEdit').val(employeeType.details);
				$('#createdByEdit').val(employeeType.createdBy);
			var createdDate = newDate(employeeType.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(employeeType.lastModifiedBy);
			var lastModifiedDate = newDate(employeeType.lastModifiedDate)
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

		$.get(href, function(employeeType, status) {
			$('#idDetails').val(employeeType.id);
			$('#descriptionDetails').val(employeeType.description);
			$('#detailsDetails').val(employeeType.details);
			$('#lastModifiedByDetails').val(employeeType.lastModifiedBy);
			$('#createdByDetails').val(employeeType.createdBy);
			$('#createdDateDetails').val(employeeType.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(employeeType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employeeType.lastModifiedDate.substring(0,10).replace(/-/g, '/'));
		});
		$('#detailsModal').modal();
	});


});