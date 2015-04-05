/**
 * Created by fcs on 2015/3/30.
 */

var bugtagList = function(){
     var basePath = "http://localhost:8089/bugweb";

     function submitBugcontent(){
         $("#submitBtn").on("click",function(){
             var $submitForm  = $("#submitBugContent");
             $submitForm.submit();
         });
     }
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

    return {
        init:function(){
            submitBugcontent();
        }
    }
}();
