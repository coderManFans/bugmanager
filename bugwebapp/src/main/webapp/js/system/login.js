/**
 * Created by fcs on 2015/3/28.
 */
var LoginJs = function(){
     function login(){
         var $loginForm = $("#loginform");
         if($loginForm.validator().form()){
             var $password = $("#password");
             $password.val($password.val().md5());
         }
     }
     var handleLogin = function(){
         $("#loginform").validator({
              roles:{
                  username:{
                      required:true
                  },
                  password:{
                      required:true
                  }
              },
              messages:{
                  username:{
                      required: "用户名不能为空"
                  },
                  password:{
                      required: "密码不能为空"
                  }
              },
              invalidHandler:function(event ,validator){
                  $('.alert-danger', $('#loginform')).show();
              },
              success:function(label){
                  label.closest('control-group').removeClass('has-error');
                  label.remove();
              },
              errorPlacement:function(error,element){
                error.insertAfter(element.closest('.input-icon'));
              },
              submitHandler:function(form){
                  form.submit();
              }
         }),
         $("#userName").keypress(function (e) {
             if(e.which == 13){
                 $("#userName").focus();
                 return false;
             }
         }),
         $("#password").keypress(function (e) {
             if(e.which == 13){
                 $("#password").focus();
                 return false;
             }
         }),
         $("#loginbtn").("onclick",function(){
                  login();
              });

         };
    return {
        //初始化登陆模块的函数
        init: function(){
            handleLogin();
        }
    };

}();