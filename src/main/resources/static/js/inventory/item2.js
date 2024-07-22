/*$(document).ready(function() {
	$('#parentCategory').change(function() {
		var parentId = $(this).val();
		if (parentId) {
			$.get('/inventory/create/categories', { parentId: parentId }, function(data) {
				var middleCategorySelect = $('#middleCategory');
				middleCategorySelect.empty();
				middleCategorySelect.append('<option value="">선택하세요</option>');
				data.forEach(function(category) {
					middleCategorySelect.append('<option value="' + [[${category.id}]] + '">' + category.name + '</option>');
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
			$.get('/inventory/create/subcategories', { parentId: parentId }, function(data) {
				var subCategorySelect = $('#subCategory');
				subCategorySelect.empty();
				subCategorySelect.append('<option value="">선택하세요</option>');
				data.forEach(function(category) {
					subCategorySelect.append('<option value="' + category.id + '">' + category.name + '</option>');
				});
			});
		} else {
			$('#subCategory').empty().append('<option value="">선택하세요</option>');
		}
	});
});*/