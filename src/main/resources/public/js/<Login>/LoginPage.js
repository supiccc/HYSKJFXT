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
        $('#submitBtn').on('click',function () {
            accountMgr.register();
        })
    }
};

var accountMgr={

    login:function () {
        username = $('#phoneNumber').val();
        password = $('#passWord').val();
        role=$('#userType').val();
        roleString = '';
        if(role=='1'){
            roleString = "admin";
        }else if(role=='2'){
            roleString = "member";
        }else{
            roleString = "merchant";
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
                url : 'http://localhost:8080/login',
                data : {
                    username : username,
                    pwd : password,
                    role : roleString
                },
                dataType : 'json',
                success : function(res) {
                    if (res.code == 0) {
                        // 登录成功
                        alert("登陆成功，欢迎用户"+username);
                        var to = "";
                        switch (user_type) {
                            case '1':
                                // to = "./school_main.html";
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
                        // window.location.href = to;
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
    },

    register:function () {
        alert('registing'+$('#email').val());
        if($('#email').val()!=""){
            $.ajax({
                type : 'POST',
                url: 'http://localhost:8080/merchantJoin/independentJoin',
                data: {
                    mertype : $('#shopType').val(),
                    mername : $('#shopName').val(),
                    //暂存地址
                    merarea: $('#shopAddress').val(),
                    mertelphone: $("#phoneNumber").val(),
                    mercumpresent: $('#ratio').val(),
                    merdicpresent: $('#disCount').val(),
                    merprincipal: $('#realName').val(),
                    merappellation: $('#sex').val(),
                    merduty: $('#job').val(),
                    merphone: $('#personalPhoneNumber').val(),
                    merfax: $('#fax').val(),
                    meremail: $('#email').val()
                },
                dataType: 'json',
                success: function (result) {
                    if(result.code == 0){
                        alert('申请成功，我们回第一时间回复您的!');
                    }else{
                        alert('申请失败，后台故障');
                    }
                },
                error: function (result) {
                    alert(result.code+' : 申请失败，服务器异常');
                }

            });
        }

    }
};