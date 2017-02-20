$(document).ready(function() {

	/* *** form styler *** */
		$('input, select').styler({
			selectSearch: true,
			filePlaceholder: 'Файл не вибраний',
			fileBrowse: 'Обзор...',
			fileNumber: 'Вибрано файлів: %s',
			selectPlaceholder: 'Виберіть...',
			selectSearchNotFound: 'Збігів не знайдено',
			selectSearchPlaceholder: 'Пошук...',
		});
	/* *** endform styler *** */

	/* *** accordion *** */
	$(".accordion .buttonAccordion").click(function() {
		var element = $(this).parent("li");
		if (element.hasClass('open')) {
			element.removeClass('open');
			element.find('ul.subUl').slideUp();
		} else{
			element.addClass('open');
			element.children('ul.subUl').slideDown();
			element.siblings('li').children('ul.subUl').slideUp();
			element.siblings('li').removeClass('open');
		}
	});
	/* *** end accordion *** */

	/* *** fancybox *** */
	$(".fancybox").fancybox();
	/* *** end fancybox *** */

	/* *** sort list *** */
	// closeBlock(".sort p", ".sort .menuList");
	// setCookieWithAnchorLink ("sort", "sortView", ".sort .menuList li a");
	/* *** end sort list *** */

	/* *** page.jsp list *** */
	// closeBlock(".page.jsp p", ".page.jsp .menuList");
	// setCookieWithAnchorLink ("page.jsp", "sortView", ".page.jsp .menuList li a");
	/* *** end page.jsp list *** */

	/* *** table list view *** */
	setCookieWithAnchorLink("view", "table", "sortView", ".view button");
	/* *** end table list view *** */

	/* *** head autorization menu *** */
	$("#headAutorization").mouseover(function() {
		$(".headAutorization .menuList").slideDown();
	});
	$(".headAutorization .menuList").mouseleave(function() {
		$(".headAutorization .menuList").slideUp();
	});
	/* *** end head autorization menu *** */

	/* *** validation *** */
	// $(#loginpage)
	/* *** end validation *** */

});


//
// $.getJSON('//freegeoip.net/json/?callback=?', function(data) {
//     console.log(data.ip);
// });




/* === ajax === */
	/* *** live search *** */
	// $("#search").focusin(function () {
     //    $(".textSearch").show();
    // });
	// $("#search").focusout(function () {
	// 	$(".textSearch").hide();
	// });
	// function textSearch (name) {
     //    // var textSearch = $(this).text();
     //    // alert(name);
     //    $("#search").val(name);
    // }
	// document.getElementById('search').oninput = function () {
     //    var liveSearch = $("#search").val();
    //
     //    $.ajax({
     //    	url: 'liveSearch?' + $('#csrf input[name=csrf_name]').val() + "=" + $('#csrf input[name=csrf_value]').val(),
     //        method: 'POST',
     //        contentType: 'application/json; charset=UTF-8',
     //        dataType: 'json',
	// 		data: liveSearch,
     //        success :function (res) {
     //            var all = '';
     //            for (var i = 0; i < res.length; i++){
     //    			all += "<li onclick='textSearch("+res[i].name+")'>"+res[i].name+"</li><br>";
	// 			}
	// 			$(".textSearch").html(all);
     //        }
	// 	})
	// }

	/* *** end live search *** */
	// document.getElementsByClassName('countCart').oninput = function () {
	// 	countCart($(this));
	// }
	$('.countCart').change(function () {
		countCart($(this));
    })
	function countCart(el) {
		var id = el.attr('id').substr(4);
		var quantity = Math.abs(parseInt(el.val()));
		var price = $("#price"+id).text();
		el.val(quantity);
		if (quantity == 0){
			el.val(1);
			quantity = 1;
		}
		if (isNaN(quantity)){
			el.val(1);
			quantity = 1;
		}
        var cart = {
            id: id,
            quantity: quantity
        }
		$.ajax({
            url: 'countCart?' + $('#csrf input[name=csrf_name]').val() + "=" + $('#csrf input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(cart),
            success: function (res) {
                loadCart();
                $("#newPrice"+id).text(price*quantity);
            },
			error:function () {
				alert("error");
            }
		})
    }
	/* *** delete cart *** */
	$(".buttonDeleteCart").click(function () {
		var id = $(this).attr("id").substr(1);
		var cart = {
			id: id
		}
		$.ajax({
			url: 'deleteCart?' + $('#csrf input[name=csrf_name]').val() + "=" + $('#csrf input[name=csrf_value]').val(),
			method: 'POST',
			contentType: 'application/json; charset=UTF-8',
			dataType: 'json',
			data: JSON.stringify(cart),
			success: function (res) {
				// alert("ok");
				$("#wrapC"+id).hide(300);
				loadCart();
			},
			error: function () {
				alert("error");
			}
		})
	});
	/* *** end delete cart *** */

	/* *** buy good *** */
	$(".buttonBuy").click(function () {
		var id = $(this).attr("id").substr(1);
		var good = {
			id: id
		}
        $.ajax({
            url: "buyGood?"+$('#csrf input[name=csrf_name]').val() + "=" + $('#csrf input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(good),
            success: function () {
                loadCart();
                // alert("ok");
            },
            error: function () {
                alert("error");
            }
		});
    });
	/* *** end buy good *** */

	/* *** load cart *** */
    function loadCart() {
        $.ajax({
            url: "loadCart?" + $('#csrf input[name=csrf_name]').val() + "=" + $('#csrf input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            success: function (data) {
            	if (data[0] != null){
                    $("#cartInform").html("<div class='cartFull'>" +
						"<div><p><span>"+data[0]+"</span> на суму <span>"+data[1]+"</span> грн.</p></div>" +
						"<a href='cart' class='pure-button buttonBlue buttonCart'>Оформити замовлення</a></div>");
                } else {
                    $("#cartInform").html("<div class='cartEmpty' style='display: block'>" +
						"<h4 class='h4'>Корзина пуста</h4></div>");
				}
            },
            error: function () {
				alert("error");
            }
        })
    }
	/* *** end load cart *** */

/////

/////////////////////////
$("#showAllCategories").click(function () {
	$.ajax({
        url: "allCategories?"+$('.showAllCategories input[name=csrf_name]').val() + "=" + $('.showAllCategories input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {
            var text = "";
            for(var i= 0; i< res.length; i++){
                var index = res[i].id;
                text += "<div>id = "+res[i].id+" name = "+res[i].name+"</div>";
            }
            $("#allCategories").html(text);
        }
    })
});
//////////

/* === end ajax === */

/* === functions === */
	/* *** close block *** */
	function closeBlock (btn, block) {
		$(btn).click(function() {
			var $message = $(block);

			if ($message.css('display') != 'block') {
				$message.slideDown();
				var firstClick = true;
				$(document).bind('click.myEvent', function(e) {
					if (!firstClick && $(e.target).closest(block).length == 0) {
						$message.slideUp();
						$(document).unbind('click.myEvent');
					}
					firstClick = false;
				});
			}
		});
	}
	/* *** end close block *** */

	/* *** anchor cookie *** */
	function setCookieWithAnchorLink (nameCookie,cookie, anchor, link) {
		if ($.cookie(nameCookie) == null) {
			$.cookie(nameCookie, $.cookie(cookie));
		}
		if ($.cookie(nameCookie+'Сheck') == null) {
			$.cookie(nameCookie+'Check', $.cookie(nameCookie));
		}
		$(link).click(function() {
			var cookie = $(this).attr("id");
			$.cookie(nameCookie, cookie);
			window.location.reload();
			return false;
		});
		if ($.cookie(nameCookie) != $.cookie(nameCookie+'Check')) {
			window.location.hash = anchor;
		}
		setTimeout(function() {
			$.cookie(nameCookie+'Check', $.cookie(nameCookie));
		}, 1000);
	}	
	/* *** end anchor cookie *** */

	/* *** group price *** */
	function groupPrice(intprice) {  
		var result_total = String(intprice);
		var lenstr = result_total.length;
		switch(lenstr) {
			case 4: {
				groupprice = result_total.substring(0,1)+" "+result_total.substring(1,4);
				break;
			}
			case 5: {
				groupprice = result_total.substring(0,2)+" "+result_total.substring(2,5);
				break;
			}
			case 6: {
				groupprice = result_total.substring(0,3)+" "+result_total.substring(3,6); 
				break;
			}
			case 7: {
				groupprice = result_total.substring(0,1)+" "+result_total.substring(1,4)+" "+result_total.substring(4,7); 
				break;
			}
			default: {
				groupprice = result_total;  
			}
		}  
		return groupprice;
	}
	/* *** end group price *** */

/* === end functions === */