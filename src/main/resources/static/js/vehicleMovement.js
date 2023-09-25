	
function increaseDate(date){
		var newDate = new Date(date);
		newDate.setDate(newDate.getDate()+1);
		return newDate.toISOString().slice(0,10);
	};

$('document').ready(function() {

	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(vehicleMovement, status) {
			$('#idEdit').val(vehicleMovement.id);
			$('#vehicleEdit').val(vehicleMovement.vehicleid);
			$('#location1Edit').val(vehicleMovement.locationid1);
			
			var date1 = increaseDate(vehicleMovement.date1);
			$('#date1Edit').val(date1);
			
			$('#location2Edit').val(vehicleMovement.locationid2);
			
			var date2 = increaseDate(vehicleMovement.date2);
			$('#date2Edit').val(date2);
			
			$('#remarksEdit').val(vehicleMovement.remarks);
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

		$.get(href, function(vehicleMovement, status) {
			$('#idDetails').val(vehicleMovement.id);
			$('#vehicleDetails').val(vehicleMovement.vehicleid);
			$('#location1Details').val(vehicleMovement.locationid1);
			
			var date1 = increaseDate(vehicleMovement.date1);
			$('#date1Details').val(date1);
			
			$('#location2Details').val(vehicleMovement.locationid2);
			
			var date2 = increaseDate(vehicleMovement.date2);
			$('#date2Details').val(date2);
			
			$('#remarksDetails').val(vehicleMovement.remarks);
		});
		$('#detailsModal').modal();
	});
	
	var dateList = $('.table #subDate').toArray();
	
	dateList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});


});