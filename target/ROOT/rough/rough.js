/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 var dataString = $("#commentForm").serialize();
        var commentName = $("#contact_name").val();
        var commentEmail = $("#contact_email").val();
        var commentSubject = $("#contact_mobile").val();
        var commentMessage = $("#contact_mobile").val();
        
        
        
 $(document).ready(function () {
console.log(" ##### ");
$('#mysubmit').click(function () {
    console.log(" *********************************");
    var person = {
        contact_name : $("#contact_name").val(),
        contact_email : $("#contact_email").val(),
        contact_mobile : $("#contact_mobile").val(),
        contact_message : $("#contact_message").val()
    };
    
    $.ajax({
     url:'ContactUs',
     type:'post',
     datatype:'json',
     contentType: 'application/json',
     success:function (data){
         console.log("Succcess");
         console.log(data.msg);
     },
    data:person 
            
    
     
    });
    
});


 
                                });
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
console.log(" ##### ");
$('#mysubmit').click(function () {
    var dataString = "CountryCode = 10";
    
    $.ajax({
     url:'ContactUs',
     type:'post',
     datatype:'json',
     data:dataString ,
    success: function (data, textStatus, jqXHR) {
        console.log("jqXHR:"+jqXHR.responseText);
        console.log("data:"+data);
        if(data.success)
        {
            $("#ajaxResponse").html("");
            $("#ajaxResponse").html("<p>Noman</p>");
            $("#ajaxResponse").html("<p>"+data.person+"</p>");
        }
        else{
            console.log("2");
            $("#ajaxResponse").html("");
            $("#ajaxResponse").html("<p>akhtar</p>");
            
        }

    },
            error:function (jqXHR , textStatus , errorThrown){
                console.log("3");
        //$("#ajaxResponse").html(jqXHR.responseText);
        
    }
    
     
    });
    
});


 
                                });
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
console.log(" ##### ");
$('#mysubmit').click(function () {
    //var dataString = "CountryCode = 10";
    var dataString = $("#myform").serialize();
    
    $.ajax({
     url:'ContactUs',
     type:'post',
     datatype:'json',
     data:dataString ,
    success: function (data, textStatus, jqXHR) {
        console.log("jqXHR:"+jqXHR.responseText);
        console.log("data:"+data);
        if(data.success)
        {
            $("#ajaxResponse").html("");
            $("#ajaxResponse").html("<p>Noman</p>");
            $("#ajaxResponse").html("<p>"+data.person+"</p>");
        }
        else{
            console.log("2");
            $("#ajaxResponse").html("");
            $("#ajaxResponse").html("<p>akhtar</p>");
            
        }

    },
            error:function (jqXHR , textStatus , errorThrown){
                console.log("3");
        //$("#ajaxResponse").html(jqXHR.responseText);
        
    }
    
     
    });
    
});


 
                                });
                                
                                
                                
                                
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
     
     
    $('#contactSubmit').click(function () {
        var dataString = $("#contactForm").serialize();
            
        $.ajax({
             url:'ContactUs',
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




$("input[name$=commentMessage]").on("input",function (){
        var name = $(this);
        console.log("1");
        var reg = /^[a-zA-Z ]*[a-zA-Z]*$/;
        var is = reg.test(name.val());
        console.log("2");
        if(is)
            console.log("ok");
        else
            console.log("not");
        
    });
