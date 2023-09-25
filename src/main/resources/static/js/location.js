$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#addressEdit').val(location.address);
			$('#cityEdit').val(location.city);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
			$('#countryEdit').val(location.countryid);
			$('#stateEdit').val(location.stateid);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#addressDetails').val(location.address);
			$('#cityDetails').val(location.city);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#countryDetails').val(location.countryid);
			$('#stateDetails').val(location.stateid);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#LastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
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