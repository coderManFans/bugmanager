/**
 * Created by fcs on 2015/4/4.
 */

var Register = function(){
    function register(){
        var $registerForm = $('.form-horizontal');
        if($registerForm.validate().form()){
            $registerForm.submit();
        }
    }
    var handleRegister = function(){
        $('.form-horizontal').validate({
           rules: {
               username: {
                   required: true
               },
               password: {
                   required: true
               }
           },
            messages: {
                username: {
                    required: "用户名不能为空"
                },
                password: {
                    required: "密码不能为空"
                }
            },
            invalidHandler: function(event,valdator){   //display error alert on form submit
                $('.alert-danger',$('.form-horizontal')).show();
            },

            success: function(label){
                label.closest('form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error,element){
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form){
                form.submit();
            }
        });

        $("#username").keypress(function(e){
           if (e.which == 13){
               $().focus();
               return false;
           }
        }).focus();

        $("#password").keypress(function(e){
            if(e.which == 13){
                register();
                return false;
            }
        });

        $("#loginBtn").on("click",function(){
           register();
        });
    };
    return {
        init: function(){
            handleRegister();
        }
    }
}();