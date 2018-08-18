$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage={
    init:function () {

    },

    action:function () {
        $('#sendSMS').on('click',function () {
            foget.send();
        })
        $('#update').on('click',function(){
            foget.update();
        })
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
