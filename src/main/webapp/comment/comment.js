/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {

    $('#commentSubmit').click(function () {
        
        var dataString = $("#commentForm").serialize();
        var commentName = $("input[name$=commentName]").val();
        var commentEmail = $("input[name$=commentEmail]").val();
        var commentSubject = $("input[name$=commentSubject]").val();
        var commentMessage = $("[name$=commentMessage]").val();
        var commentDate ="11/OCT/2015 at 21:20:25 on Sunday";
        
        var regName = /^[a-zA-Z ]*[a-zA-Z]*$/;
        var regEmail = /^[a-zA-Z0-9\\.]*[@][a-zA-Z]*[.][a-zA-Z]*$/;
        var regMessage = /^[a-zA-Z0-9\\-_ ]*$/;
        if(!regName.test(commentName)){
            $("input[name$=commentName]").css("border-color","red");
            return ;
        }else{
            $("input[name$=commentName]").css("border-color","#A09F9F");
        }
        if(!regEmail.test(commentEmail)){
            $("input[name$=commentEmail]").css("border-color","red");
            return ;
        }else{
            $("input[name$=commentEmail]").css("border-color","#A09F9F");
        }
        if(!regMessage.test(commentSubject)){
            $("input[name$=commentSubject]").css("border-color","red");
            return ;
        }else{
            $("input[name$=commentSubject]").css("border-color","#A09F9F");
        }
        if(!regMessage.test(commentMessage)){
            $("[name$=commentMessage]").css("border-color","red");
            return ;
        }else{
             $("[name$=commentMessage]").css("border-color","#A09F9F");
        }
        
        $.ajax({
             url:'CommentReceiver',
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
                   $("#media2").after("\
                        <div class='media'>"+
                            "<div class='media-left'>"+
                                "<a href='#'>"+
                                    "<img src='images/si.png' alt=''>"+
                                "</a>"+
                            "</div>"+
                            "<div class='media-body'>"+
                                "<h4 class='media-heading'>"+commentName+"</h4>"+
                                "<h6>"+commentDate+"</h6>"+
                                "<p>"+commentMessage+"</p>"+
                            "</div>"
                        +"</div>");
                   $("#commentResponse").html("");
                   $("#commentResponse").html("<div class='alert alert-success' role='alert'>"+response.msg+"</div>");
                   $('#commentForm').trigger("reset");
                   console.log("ok");


                }
                else{
                    console.log("2");
                    $("#commentResponse").html("");
                    $("#commentResponse").html("<div class='alert alert-danger' role='alert'>"+response.msg+"</div>");

                }

            },
            error:function (jqXHR , textStatus , errorThrown){
                console.log("error");
                $("#commentResponse").html("");
                $("#commentResponse").html("<div class='alert alert-danger' role='alert'>"+
                                            "<strong>Oh snap!</strong> Error occured try submitting again."+
                                            "</div>");
                $("#commentSubmit").attr("disabled",false);        
            },
            
            beforeSend: function (xhr,settings) {
                console.log("beforeSend");
                //settings.data +="&dummy=hiiiiiiii";
                $("#commentResponse").html("");
                $("#commentResponse").html("<span class='glyphicon-yen'></span>");
                $("#commentSubmit").attr("disabled",true);
            },
            
            complete: function (jqXHR, textStatus) {
                console.log("complete");
                $("#commentSubmit").attr("disabled",false);
            }
            


        });

    });

//$('#contactSubmit').(function () {
//    
//});
    

 
});//documet.ready


