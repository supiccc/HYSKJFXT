$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage={
    init:function () {

    },

    action:function () {
        $('#loginBtn').on('click',function () {
            accountMgr.login();
        })
    }
};

var accountMgr={

    login:function () {
        username = $('#phoneNumber').val();
        password = $('#passWord').val();
        role = $('#userType').val();
        roleString = '';
        if ($("input[type=checkbox]").is(':checked')) {
            rememberMeString = 1;
        } else {
            rememberMeString = 0;
        }
        if(role=='1'){
            roleString = "member";
        }else if(role=='2'){
            roleString = "merchant";
        }else{
            roleString = "admin";
        }

        if(role!='1'&&role!='2'&&role!='3'){
            alert("请选择账户类型");
            return;
        }else if(username == ''){
            alert("请输入账户名");
            return;
        }else if(password == ''){
            alert("请输入密码");
            return;
        }else{
            $.ajax({
                type : 'POST',
                url : '/login',
                data : {
                    username : username,
                    pwd : password,
                    role : roleString,
                    rememberMe: rememberMeString
                },
                dataType : 'json',
                success : function(res) {
                    if (res.code == 0) {
                        // 登录成功
                        alert("登陆成功，欢迎用户"+username);
                        var to = "";
                        switch (role) {
                            case '1':
                                to = "indexReal.html";
                                break;
                            case '2':
                                // to = "./county_main.html";
                                break;
                            case '3':
                                // to = "./city_main.html";
                                break;
                            case '4':
                                // to = "./leader_main.html";
                                break;
                            default:
                                break;
                        }
                        window.location.href = to;
                    } else {
                        alert(res.msg);
                        return;
                    }
                },
                error : function() {
                    alert('服务器异常');
                    return;
                }
            });
        }
    }
};