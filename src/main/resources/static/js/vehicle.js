function increaseDate(data){
	var newDate = new Date(data);
	newDate.setDate(newDate.getDate()+1);
	var formatDate = newDate.toISOString().slice(0,10);
	return formatDate;
};

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(vehicle, status){
			$('#idEdit').val(vehicle.id);
			$('#vehicleTypeEdit').val(vehicle.vehicletypeid);
			$('#nameEdit').val(vehicle.name);
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);
			
			var registrationDate = increaseDate(vehicle.registrationDate);
			$('#registrationDateEdit').val(registrationDate);
			
			$('#descriptionEdit').val(vehicle.description);
			
			var acquisitionDate = increaseDate(vehicle.acquisitionDate);
			$('#acquisitionDateEdit').val(acquisitionDate);
			
			$('#vehicleMakeEdit').val(vehicle.vehiclemakeid);
			$('#vehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#locationEdit').val(vehicle.locationid);
			$('#powerEdit').val(vehicle.power);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#remarksEdit').val(vehicle.remarks);
			$('#employeeEdit').val(vehicle.employeeid);
			$('#vehicleStatusEdit').val(vehicle.vehiclestatusid);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(vehicle, status){
			$('#idDetails').val(vehicle.id);
			$('#vehicleTypeDetails').val(vehicle.vehicletypeid);
			$('#nameDetails').val(vehicle.name);
			$('#vehicleNumberDetails').val(vehicle.vehicleNumber);
			
			var registrationDate = increaseDate(vehicle.registrationDate);
			$('#registrationDateDetails').val(registrationDate);
			
			$('#descriptionDetails').val(vehicle.description);
			
			var acquisitionDate = increaseDate(vehicle.acquisitionDate);
			$('#acquisitionDateDetails').val(acquisitionDate);
			
			$('#vehicleMakeDetails').val(vehicle.vehiclemakeid);
			$('#vehicleModelDetails').val(vehicle.vehiclemodelid);
			$('#locationDetails').val(vehicle.locationid);
			$('#powerDetails').val(vehicle.power);
			$('#fuelCapacityDetails').val(vehicle.fuelCapacity);
			$('#netWeightDetails').val(vehicle.netWeight);
			$('#remarksDetails').val(vehicle.remarks);
			$('#employeeDetails').val(vehicle.employeeid);
			$('#vehicleStatusDetails').val(vehicle.vehiclestatusid);
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();		
	});
	
	$('.table #photoButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#displayPhoto').attr('src',href);
		$('#photoModal').modal();
	});
	
	var dateList = $('.table #subDate').toArray();
	dateList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});
});