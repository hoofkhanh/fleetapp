
function increaseDay(date){
	var newDate = new Date(date);
	newDate.setDate(newDate.getDate()+1);
	var formatDate = newDate.toISOString().slice(0,10);
	return formatDate;
};

$('document').ready(function() {
	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(vehicleHire, status) {
			$('#idEdit').val(vehicleHire.id);
			$('#vehicleEdit').val(vehicleHire.vehicleid);
			$('#clientEdit').val(vehicleHire.clientid);
			
		    var dateOut = increaseDay(vehicleHire.dateOut)
			$('#dateOutEdit').val(dateOut);
			
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#locationEdit').val(vehicleHire.locationid);
			
			var dateIn = increaseDay(vehicleHire.dateIn)
			$('#dateInEdit').val(dateIn);
			
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
		});
		$('#editModal').modal();
	});

$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(vehicleHire, status) {
			$('#idDetails').val(vehicleHire.id);
			$('#vehicleDetails').val(vehicleHire.vehicleid);
			$('#clientDetails').val(vehicleHire.clientid);
			
		    var dateOut = increaseDay(vehicleHire.dateOut)
			$('#dateOutDetails').val(dateOut);
			
			$('#timeOutDetails').val(vehicleHire.timeOut);
			$('#locationDetails').val(vehicleHire.locationid);
			
			var dateIn = increaseDay(vehicleHire.dateIn)
			$('#dateInDetails').val(dateIn);
			
			$('#timeInDetails').val(vehicleHire.timeIn);
			$('#priceDetails').val(vehicleHire.price);
			$('#remarksDetails').val(vehicleHire.remarks);
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		/* gắn giá trị vào nút confirm */
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();
	});

	var dateOutList = $('.table #subDateOut').toArray();
	dateOutList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});
	
	var dateInList = $('.table #subDateIn').toArray();
	dateInList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});


});