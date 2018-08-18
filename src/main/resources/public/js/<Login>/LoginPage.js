$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage={
    init:function () {

    },

    action:function () {
        //登陆
        $('#loginBtn').on('click',function () {
            accountMgr.login();
        })
        $('#submitBtn').on('click',function () {
            accountMgr.register();
        })
        //入盟

        //忘记密码
        $('#sendSMS').on('click',function () {
            foget.send();
        })
        $('#update').on('click',function(){
            foget.update();
        })
    }
};

var accountMgr={

    login:function () {
        username = $('#phoneNumber').val();
        password = $('#passWord').val();
        role=$('#userType').val();
        roleString = '';
        if ($("input[type='checkbox']").is(':checked')) {
            vc = 1;
        } else {
            vc = 0;
        }
        // 只返回三个类型不够用
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
                url : 'http://localhost:8080/login',
                data : {
                    username : username,
                    pwd : password,
                    role : roleString,
                    rememberMe: vc
                },
                dataType : 'json',
                success : function(res) {
                    if (res.code == 0) {
                        // 登录成功
                        alert("登陆成功，欢迎用户"+username);
                        var roleName = "";
                        $.each(res, function(index, obj){
                            if(roleString == "merchant"){
                                if(obj.macacctype == 11 || obj.macacctype == 1){
                                    roleName = "merchantAdmin";
                                }else if(obj.macacctype == 12 || obj.macacctype == 2){
                                    roleName = "merchantFrontDesk";
                                }else if(obj.macacctype == 13 || obj.macacctype == 3){
                                    roleName = "merchantCManager";
                                }else if(obj.macacctype == 14){
                                    roleName = "merchantDManager";
                                }else{
                                    roleName = "null";
                                }
                            }else if(roleString == "member"){
                                roleName = "member";
                            }else{
                                roleName = "admin";
                            }
                        });
                        alert("登录成功，欢迎"+roleName+"用户 : "+username);
                        window.location.href = "../Member/indexReal.html?username="+username+"&role="+roleName+"";
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

var foget = {
    send:function () {
        username = $('#phoneNum').val();
        if (isPhone(username)) {
            $.ajax({
                type : 'POST',
                url : '/sendSMS',
                data : {
                    username : username
                },
                dataType : 'json',
                success: function (re) {
                    if (re.code == 0) {
                        alert('发送验证码成功');
                        var time = 20;
                        $('#sendSMS').setAttribute("disabled");
                        var timer = setInterval(function(){
                            var tmp = time;
                            if (tmp <= 0) {
                                $('#sendSMS').removeAttribute("disabled");
                                clearInterval(timer);
                            }
                        }, 1000);
                    } else {
                        alert('发送失败')
                    }
                },
                error: function () {
                    alert('服务器异常')
                }
            })
        }
    },
    update:function () {
        username = $('#phoneNum').val();
        password1 = $('#passWord1').val();
        password2 = $('#passWord2').val();
        checknum = $('#checkNum').val();
        role = $("input[type=radio]:checked").val();
        if (password1 !== password2) {
            alert("两次输入的密码不一致");
            return;
        }
        $.ajax({
            type: 'POST',
            url: '/forget',
            data: {
                username: username,
                pwd: password1,
                vc: checknum,
                role: role
            },
            dataType: 'json',
            success:function(res){
                if (res.code == 0) {
                    alert('密码修改成功，请继续登录');
                    window.location.href = "sign_in.html"
                } else {
                    alert(res.data);
                }
            },
            error:function () {
                alert('服务器错误');
            }
        })
    }
};

var isPhone = function (string) {
    var pattern = /^1[34578]\d{9}$/;
    if (pattern.test(string)) {
        return true;
    }
    alert('登录名格式不正确');
    return false;
};