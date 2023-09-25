function increaseDay(date){
		var newDate = new Date(date);
		newDate.setDate(newDate.getDate() +1);
		var formatDate = newDate.toISOString().slice(0,10);
		return formatDate;
	};

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#clientEdit').val(invoice.clientid);
			
			var date = increaseDay(invoice.invoiceDate);		
			$('#invoiceDateEdit').val(date);
			
			$('#invoiceStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id);
			$('#clientDetails').val(invoice.clientid);
			
			var date = increaseDay(invoice.invoiceDate);			
			$('#invoiceDateDetails').val(date);
			
			$('#invoiceStatusDetails').val(invoice.invoicestatusid);
			$('#remarksDetails').val(invoice.remarks);
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');	
		
		$('#confirmDelete').attr('href', href);
		$('#deleteModal').modal();		
	});
	
	// Lấy tất cả các phần tử có id "subDate" trong bảng
	var dateList = $('.table #subDate').toArray();
	 
	// Lặp qua danh sách các phần tử và chỉnh sửa giá trị
	dateList.forEach(function(element){
		// element có giá trị là : <td id="subDate">2001-01-11 00:00:00:00</td>
		var currentDate = $(element).text(); // vì  <td id="subDate" th:text="${invoice.invoiceDate}"></td> có th:text nên text()
		var newDate = currentDate.substring(0,10).replace(/-/g, '/');
		$(element).text(newDate);
	});
});