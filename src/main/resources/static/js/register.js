$('document').ready(function() {

	var password = document.getElementById('password');

	var confirmPassword = document.getElementById('confirmPassword');

	/*
		Khi thay đổi giá trị trong input password và confirmPassword thì khi  password.value và confirmPasswordvalue nó
		cũng thay đổi
	*/
	function validatePassword() {
		if (password.value != confirmPassword.value) {
			confirmPassword.setCustomValidity("Password don't match");
		} else {
			confirmPassword.setCustomValidity('');
		}
	};

	/* 
		onchange() xảy ra khi giá trị của một phần tử thay đổi và sau khi phần tử đó mất focus 
		(người dùng click vào ô nhập liệu và sau đó click ra ngoài)
	*/
	/*
		Sự kiện onkeyup xảy ra khi người dùng thả phím sau khi nhấn một phím trên bàn phím.
	*/
	/*
		validatePassword không cần thêm () vì nó đang gán cho onchange và onkeyup là khi xảy ra sự kiện đó thì sẽ làm hàm này
		còn thêm dấu () thì có nghĩa gọi hàm đó và nhận kết quả từ no
	*/
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;
});