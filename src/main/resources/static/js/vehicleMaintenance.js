	function newDate (date){
	var newDate = new Date(date);
	return newDate;
};

function increaseDate(date){
		var newDate = new Date(date);
		newDate.setDate(newDate.getDate()+1);
		return newDate.toISOString().slice(0,10);
	};
	


$(document).ready(function() {

	$('.table #editButton').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(vehicleMaintenance, status) {
			$('#idEdit').val(vehicleMaintenance.id);
			$('#vehicleEdit').val(vehicleMaintenance.vehicleid);
			
			var startDate = increaseDate(vehicleMaintenance.startDate);
			$('#startDateEdit').val(startDate);
			
			$('#remarksEdit').val(vehicleMaintenance.remarks);
			
			var endDate = increaseDate(vehicleMaintenance.endDate);
			$('#endDateEdit').val(endDate);
			
			$('#supplierEdit').val(vehicleMaintenance.supplierid);
			$('#priceEdit').val(vehicleMaintenance.price);
			
			$('#createdByEdit').val(vehicleMaintenance.createdBy);
			var createdDate = newDate(vehicleMaintenance.createdDate)
			$('#createdDateEdit').val(createdDate);
			$('#lastModifiedByEdit').val(vehicleMaintenance.lastModifiedBy);
			var lastModifiedDate = newDate(vehicleMaintenance.lastModifiedDate)
			$('#lastModifiedDateEdit').val(lastModifiedDate);	
		});
		$('#editModal').modal();
	});

$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(vehicleMaintenance, status) {
			$('#supplierDetails').val(vehicleMaintenance.supplierid);
			$('#idDetails').val(vehicleMaintenance.id);
			$('#vehicleDetails').val(vehicleMaintenance.vehicleid);
			
			var startDate = increaseDate(vehicleMaintenance.startDate);
			$('#startDateDetails').val(startDate);
			
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			
			var endDate = increaseDate(vehicleMaintenance.endDate);
			$('#endDateDetails').val(endDate);
			
			
			$('#priceDetails').val(vehicleMaintenance.price);
			
			$('#createdByDetails').val(vehicleMaintenance.createdBy);
			$('#createdDateDetails').val(vehicleMaintenance.createdDate.substring(0,10).replace(/-/g, '/'));
			$('#lastModifiedByDetails').val(vehicleMaintenance.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMaintenance.lastModifiedDate.substring(0,10).replace(/-/g, '/'));
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
	
	var dateList = $('.table #subDate').toArray();
	
	dateList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});
	
});