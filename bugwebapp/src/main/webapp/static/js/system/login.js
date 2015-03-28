var login = function(){

    var handleLogin = function() {
        $('#loginform').validate({
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
                    required: "用户名不能为空！"
                },
                password: {
                    required: "密码不能为空！"
                }
            },

            submitHandler: function (form) {
                form.submit();
            }
        });

        $('#inputusername').keypress(function (e) {
            if (e.which == 13) {
                $("#inputpassword").focus();
                return false;
            }
        }).focus();

        $('#inputpassword').keypress(function (e) {
            if (e.which == 13) {
                login();
                return false;
            }
        });

        $("#loginBtn").on("click",function(){
            login();
        });
    };

    return {
        //main function to initiate the module
        init: function () {
            handleLogin();
        }
    };

}();