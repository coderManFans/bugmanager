/**
 * Created by fcs on 2015/3/30.
 */

var bugtagList = function(){
     var basePath = "http://localhost:8089/bugweb";

    /* function submitBugcontent(){
         var $submitForm  = $("#submitBugContent");
             $submitForm.submit();
     }*/
     var handleForm = function(){
         $('').validate({
           rules: {
               tagTypeSelect: {
                   required: true
               },
               bugTypeSelect: {
                   required: true
               }
           },
             messages: {
                 tagTypeSelect: {
                     required : "请选择标签"
                 },
                 bugTypeSelect: {
                     required: "请选择错误类型"
                 }
             },

             invalidHandler: function(){

             }
         });
     }


    $("#submitBtn").on("click",function(){
        $.ajax({
            url: "/buginfo/bugcontent/add",
            data: JSON.stringify({
                bugReason: $("#bugReasonId").val(),
                bugCode: $("#bugCodeId").val(),
                consoleError : $("#consoleErrorId").val(),
                hasSolved: false,
                upDate: new Date().toString(),
                bugTypeList: $("#bugTypeSelect").val(),
                tagTypeList: $("#tagTypeSelect").val(),
                bugAnswerList: $("#bugAnswerId").val()
            }),
            contentType: "application/json; charset=utf-8",
            type: "post",
            success: function (data) {
               alert("data = "+data);
            }
        });
    });

    return {
        init:function(){
        }
    }
}();
