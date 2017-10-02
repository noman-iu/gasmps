/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
    $('#subscribeSubmit').click(function (e) {
    	e.preventDefault();
        $.ajax({
             url:'saveSubscribe',
             type:'post',
             datatype:'json',
             data : $('form[name=subscribeForm]').serialize(),
             success: function (res, textStatus, jqXHR) {
            	 if(res.status){
            		 $('input[name=subscribeEmail]').val("");
                     $("#subscribeResponse").html("");
                     $("#subscribeResponse").html("<div class='alert alert-success' role='alert' style='text-align: center;margin-top: 15px;'> <strong>Thank you! "+Object.values(res.message)[0]+"</strong></div>");
                     $('#subscribeForm').trigger("reset");
                  }else{
                      $("#subscribeResponse").html("");
                      $("#subscribeResponse").html("<div class='alert alert-danger' role='alert' style='text-align: center;margin-top: 15px;'><strong>Oh snap! "+Object.values(res.message)[0]+"</strong> </div>");
                  }
            },
            error:function (jqXHR , textStatus , errorThrown){
                $("#subscribeResponse").html("");
                $("#subscribeResponse").html("<div class='alert alert-danger' role='alert' style='text-align: center;margin-top: 15px;'>"+
                                            "<strong>Oh snap!</strong> Error occured try submitting again."+
                                            "</div>");
                $("#subscribeSubmit").attr("disabled",false);  
            },
            
            beforeSend: function (xhr,settings) {
            	$("#subscribeResponse").delay(1).fadeIn("slow");
                $("#subscribeResponse").html("");
                $("#subscribeResponse").html("<span class='glyphicon-yen'></span>");
                $("#subscribeSubmit").attr("disabled",true);
            },
            
            complete: function (jqXHR, textStatus) {
                $("#subscribeSubmit").attr("disabled",false);
                $("#subscribeResponse").delay(3000).fadeOut("slow");
            }

        });

    });
});


