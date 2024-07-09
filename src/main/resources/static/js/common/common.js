
/* */

document.addEventListener("DOMContentLoaded", function() {


	//메뉴바 기능을 위한 변수
	const layoutWrap =document.querySelector('.layoutWrap');
	const menubar = document.querySelector('.menubar');
	const menuspan = document.querySelectorAll('.cmnav-bttom span, .logo');
	const menua = document.querySelectorAll('.cmnav-bttom a');


	

	//메뉴바
	menubar.addEventListener("mouseover", function() {
		menubar.classList.add('menubarhover');
	});

	menubar.addEventListener("mouseout", function() {
		menubar.classList.remove('menubarhover');
	});
	

	
	menubar.addEventListener("click", function() {
		menuspan.forEach(function(span) {
			if (span.classList.contains('spanhidden')) {
				span.classList.remove('spanhidden');
				layoutWrap.style.gridTemplateColumns = "200px calc(100% - 200px)";
				
				menua.forEach(function(a){
					a.style.textAlign = 'left';
				})
				

			} else {
				span.classList.add('spanhidden');
				layoutWrap.style.gridTemplateColumns = "65px calc(100% - 65px)";
				
				menua.forEach(function(a){
					a.style.textAlign = 'center';
					
					a.addEventListener("mouseover",function(){
						
						var span = a.querySelector('span');
						span.classList.add('spanshow')
						
					})
					
					a.addEventListener("mouseout",function(){
						
						var span = a.querySelector('span');
						span.classList.remove('spanshow')
						
					})
					
				});
				
		
			}


		});

	});
	
	
	



});