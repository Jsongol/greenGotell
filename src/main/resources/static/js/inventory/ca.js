/**
 * 
 */
/*
$(document).ready(function () {
				
	$('#parentCategory').change(function() {
		alert("aaaa");
		var parentId = $(this).val();
		console.log("parentId: ", parentId);
		var middleCategorySelect = $('#middleCategory');
		var subCategorySelect = $('#subCategory');
		if (parentId) {
			$.get('/inventory/categories', { parentId: parentId }, function(data) {
				console.log("--->>>");
				console.log(data);
				var middleCategorySelect = $('#middleCategory');
				middleCategorySelect.empty();
				middleCategorySelect.append('<option value="">선택하세요</option>');
				data.forEach(function(category) {
					middleCategorySelect.append('<option value="' + $(this).id + '">' + $(this).name + '</option>');
				});
			});
		} else {
			$('#middleCategory').empty().append('<option value="">선택하세요</option>');
			$('#subCategory').empty().append('<option value="">선택하세요</option>');
		}
	});
	$('#middleCategory').change(function() {
		var parentId = $(this).val();
		if (parentId) {
			$.get('/inventory/subcategories', { parentId: parentId }, function(data) {
				var subCategorySelect = $('#subCategory');
				subCategorySelect.empty();
				subCategorySelect.append('<option value="">선택하세요</option>');
				data.forEach(function(category) {
					subCategorySelect.append('<option value="' + $(this).id + '">' + $(this).name + '</option>');
				});
			});
		} else {
			$('#subCategory').empty().append('<option value="">선택하세요</option>');
		}
	});
});
//*/