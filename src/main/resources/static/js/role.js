function newDate (date){
	var newDate = new Date(date);
	return newDate;
}

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(role, status){
			$('#idEdit').val(role.id);
			$('#descriptionEdit').val(role.description);	
			$('#detailsEdit').val(role.details);
			$('#createdByEdit').val(role.createdBy);
			var createdDate = newDate(role.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(role.lastModifiedBy);
			var lastModifiedDate = newDate(role.lastModifiedDate)
			$('#lastModifiedDateEdit').val(lastModifiedDate);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(role, status){
			$('#idDetails').val(role.id);
			$('#descriptionDetails').val(role.description);	
			$('#detailsDetails').val(role.details);
			$('#createdByDetails').val(role.createdBy);
			$('#createdDateDetails').val(role.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(role.lastModifiedBy);
			$('#lastModifiedDateDetails').val(role.lastModifiedDate.substring(0,10).replace(/-/g, '/'));
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');	
		
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();		
	});
	
});