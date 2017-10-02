/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
     $("input[name$=contactMobile]").on("input",function (){
        var reg = /^[0-9]*$/;
        var is = reg.test($(this).val());
        if(!is){
            this.value = "";
        }
    });
     
    $('#contactSubmit').click(function () {
        var dataString = $("#contactForm").serialize();
            
        $.ajax({
             url:'ContactReceiver',
             type:'post',
             datatype:'json',
             data:dataString,
             success: function (data, textStatus, jqXHR) {
                console.log("data:"+data);
                var response = $.parseJSON(data);
                console.log("data x:"+response.valid);
                if(response.valid)
                {
                   console.log("1");
                   $("#contactResponse").html("");
                   $("#contactResponse").html("<div class='alert alert-success' role='alert'>"+response.msg+"</div>");
                   $('#contactForm').trigger("reset");
                   console.log("ok");
                }
                else{
                    console.log("2");
                    $("#contactResponse").html("");
                    $("#contactResponse").html("<div class='alert alert-danger' role='alert'>"+response.msg+"</div>");

                }

            },
            error:function (jqXHR , textStatus , errorThrown){
                console.log("error");
                $("#contactResponse").html("");
                $("#contactResponse").html("<div class='alert alert-danger' role='alert'>"+
                                            "<strong>Oh snap!</strong> Error occured try submitting again."+
                                            "</div>");
                $("#contactSubmit").attr("disabled",false);        
            },
            
            beforeSend: function (xhr,settings) {
                console.log("beforeSend");
                //settings.data +="&dummy=hiiiiiiii";
                $("#contactResponse").html("");
                $("#contactResponse").html("<span class='glyphicon-yen'></span>");
                $("#contactSubmit").attr("disabled",true);
            },
            
            complete: function (jqXHR, textStatus) {
                console.log("complete");
                $("#contactSubmit").attr("disabled",false);
            }
            


        });

    });

//$('#contactSubmit').(function () {
//    
//});
    

 
});//documet.ready


