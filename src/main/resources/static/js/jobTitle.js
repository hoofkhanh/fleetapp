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
		$.get(href, function(jobTitle, status) {
			$('#idEdit').val(jobTitle.id);
			$('#descriptionEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);
			$('#createdByEdit').val(jobTitle.createdBy);
			var createdDate = newDate(jobTitle.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(jobTitle.lastModifiedBy);
			var lastModifiedDate = newDate(jobTitle.lastModifiedDate)
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

		$.get(href, function(jobTitle, status) {
			$('#idDetails').val(jobTitle.id);
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
		$('#createdByDetails').val(jobTitle.createdBy);
			$('#createdDateDetails').val(jobTitle.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substring(0,10).replace(/-/g, '/'));	
		});
		$('#detailsModal').modal();
	});


});