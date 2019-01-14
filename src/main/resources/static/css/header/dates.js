var baseUrl = "http://localhost:8080";
$(document).ready(function () {

    $('#startDate, #stopDate').datetimepicker({
        format: 'Y-m-d H:i'
    });

    $('.selectpicker').selectpicker();
    $('.selectpicker').selectpicker({
        style: 'btn-info',
        size: 4
    });


});


$(function () {

    $nationalid = $("#nationalId");
    $nationalid.on('keyup', function () {
        search($nationalid.val());
    });


});


$('#startDate').datetimepicker({
    format: 'Y-m-d H:i'
});

$('#endDate').datetimepicker({
    format: 'Y-m-d H:i'
});


function search(campaignId){
    $name = $("#name");
    $.get("/get_identity/"+campaignId, {
        number: "f64c97e4bba65"+campaignId+"f10f9f0ddffe236"
    }).done(function(data){

        $.each(data, function (index, item) {
            // Use item in here
            if(index=="user_name"){
                $name.val(item)
            }

        });
    })

}