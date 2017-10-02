///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
// $(document).ready(function () {
//
//    $('#applySubmit').click(function () {
//        
//        var dataString = $("#applyForm").serialize();
//        $.ajax({
//             url:'ApplyOnline',
//             type:'post',
//             datatype:'json',
//             data:dataString,
//             success: function (data, textStatus, jqXHR) {
//                console.log("data:"+data);
//                var response = $.parseJSON(data);
//                console.log("data x:"+response.valid);
//                if(response.valid)
//                {
//                   console.log("1");
//                  
//                   $("#applyResponse").html("");
//                   $("#applyResponse").html("<div class='alert alert-success' role='alert'>"+response.msg+"</div>");
//                   $('#applyForm').trigger("reset");
//                   console.log("ok");
//                }
//                else{
//                    console.log("2");
//                    $("#applyResponse").html("");
//                    $("#applyResponse").html("<div class='alert alert-danger' role='alert'>"+response.msg+"</div>");
//
//                }
//
//            },
//            error:function (jqXHR , textStatus , errorThrown){
//                console.log("error");
//                $("#applyResponse").html("");
//                $("#applyResponse").html("<div class='alert alert-danger' role='alert'>"+
//                                            "<strong>Oh snap!</strong> Error occured try submitting again."+
//                                            "</div>");
//                $("#applySubmit").attr("disabled",false);        
//            },
//            
//            beforeSend: function (xhr,settings) {
//                console.log("beforeSend");
//                //settings.data +="&dummy=hiiiiiiii";
//                $("#applyResponse").html("");
//                $("#applyResponse").html("<span class='glyphicon-yen'></span>");
//                $("#applySubmit").attr("disabled",true);
//            },
//            
//            complete: function (jqXHR, textStatus) {
//                console.log("complete");
//                $("#applySubmit").attr("disabled",false);
//            }
//            
//
//
//        });
//
//    });
// 
//});//documet.ready
//
//
