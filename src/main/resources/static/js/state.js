$('document').ready(function(){
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#detailsEdit').val(state.details);
			$('#nameEdit').val(state.name);
			$('#ddlCountryEdit').val(state.countryid);			
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#capitalDetails').val(state.capital);
			$('#codeDetails').val(state.code);
			$('#detailsDetails').val(state.details);
			$('#nameDetails').val(state.name);
			$('#ddlCountryDetails').val(state.countryid);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace('T', " "));
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