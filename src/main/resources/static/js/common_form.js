$(document).ready(function() {
	$("#buttonCancel").on("click", function() {
		window.location.href = 'http://localhost:8080/account/add';
	});

	$("#fileImage").change(function() {
		showImageThumbnail(this);
	});
});

function showImageThumbnail(fileInput) {
	var file = fileInput.files[0];
	var reader = new FileReader();
	reader.onload = function(e) {
		$("#thumbnail").attr("src", e.target.result);
	};

	reader.readAsDataURL(file);
}
$(document).ready(function(){

	$('.input').focus(function(){
		$(this).parent().find(".label-txt").addClass('label-active');
	});

	$(".input").focusout(function(){
		if ($(this).val() == '') {
			$(this).parent().find(".label-txt").removeClass('label-active');
		};
	});



});

