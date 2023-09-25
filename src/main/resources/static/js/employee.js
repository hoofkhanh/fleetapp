function increaseDate(date){
	var newDate = new Date(date);
	newDate.setDate(newDate.getDate()+1);
	var formatDate = newDate.toISOString().slice(0,10);
	return formatDate;
}

$('document').ready(function() {
	$('.table #editButton ').on('click', function(event) {
		event.preventDefault(); // Ngăn chặn khi bấm vào button thì nó nhảy qua bên url đó và làm
		var href = $(this).attr('href');// lấy giá trị trong href bên nút button edit

		/* bắt đầu vào url getMapping này bên controller làm */
		/* khi $.get(href) làm xong rồi thi nó sẽ làm callback => function(..) */
		$.get(href, function(employee, status) {
			$('#usernameEdit').val(employee.username);
			$('#idEdit').val(employee.id);
			$('#titleEdit').val(employee.title);
			$('#initialsEdit').val(employee.initials);
			$('#socialSecurityNumberEdit').val(employee.socialSecurityNumber);
			$('#firstNameEdit').val(employee.firstname);
			$('#lastNameEdit').val(employee.lastname);
			$('#otherNameEdit').val(employee.othername);
			$('#genderEdit').val(employee.gender);
			$('#countryEdit').val(employee.countryid);
			$('#addressEdit').val(employee.address);
			
			var dateOfBirth = increaseDate(employee.dateOfBirth);
			$('#dateOfBirthEdit').val(dateOfBirth);
			
			var hireDate = increaseDate(employee.hireDate);
			$('#hireDateEdit').val(hireDate);
			
			$('#stateEdit').val(employee.stateid);
			$('#cityEdit').val(employee.city);
			$('#phoneEdit').val(employee.phone);
			$('#mobileEdit').val(employee.mobile);
			$('#maritalStatusEdit').val(employee.maritalStatus);
			$('#emailEdit').val(employee.email);
			$('#jobTitleEdit').val(employee.jobtitleid);
			$('#employeeTypeEdit').val(employee.employeetypeid);
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

		$.get(href, function(employee, status) {
			$('#idDetails').val(employee.id);
			$('#titleDetails').val(employee.title);
			$('#initialsDetails').val(employee.initials);
			$('#socialSecurityNumberDetails').val(employee.socialSecurityNumber);
			$('#firstNameDetails').val(employee.firstname);
			$('#lastNameDetails').val(employee.lastname);
			$('#otherNameDetails').val(employee.othername);
			$('#genderDetails').val(employee.gender);
			$('#countryDetails').val(employee.countryid);
			$('#addressDetails').val(employee.address);
			
			var dateOfBirth = increaseDate(employee.dateOfBirth);
			$('#dateOfBirthDetails').val(dateOfBirth);
			
			var hireDate = increaseDate(employee.hireDate);
			$('#hireDateDetails').val(hireDate);
			
			$('#stateDetails').val(employee.stateid);
			$('#cityDetails').val(employee.city);
			$('#phoneDetails').val(employee.phone);
			$('#mobileDetails').val(employee.mobile);
			$('#maritalStatusDetails').val(employee.maritalStatus);
			$('#emailDetails').val(employee.email);
			$('#jobTitleDetails').val(employee.jobtitleid);
			$('#employeeTypeDetails').val(employee.employeetypeid);
		});
		$('#detailsModal').modal();
	});
	
	$('.table #photoButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();
	});
	
	var dateList = $('.table #subDate').toArray();
	dateList.forEach(function(element){
		var currentDate = $(element).text();
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});

});