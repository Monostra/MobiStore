/* === img Liquid === */
$(".wrapImg").imgLiquid({fill:false});
/* === end img Liquid === */

// var res = confirm("Підтвердіть видалення");
// 	if (!res) return false;

$("#save").click(function () {



        var res = confirm("Підтвердіть");
        if (!res) return false;
        var delivery = {
            name: $("#nameDelivery").val()
        }

        $("#nameDelivery").val("");

        $.ajax({
            url: "saveDelivery?" + $('.deliveryWrap input[name=csrf_name]').val() + "=" + $('.deliveryWrap input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(delivery),
            success: function () {
                alert("ok");
            },
            error: function () {
                alert("error");
            }
        })


});