$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage={
    init:function () {

    },

    action:function () {
        $("#submitBtn").on('click', function () {
            join();
        })
    }
};

function join() {
    // alert("Hello");
    // username = $('#phoneNum').val();
    $.ajax({
        type : 'POST',
        url : '/merchantJoin/independentJoin',
        data : {
            mertype: $("#shopType").find("option:selected").text(),
            mername: $("#shopName").val(),
            merarea: $("#shopAddress").val(),
            mertelphone: $("#phoneNumber").val(),
            mercumpresent: $("#ratio").val(),
            merdicpresent: $("#disCount").val(),
            merprincipal: $("#realName").val(),
            merappellation: $("#sex").find("option:selected").text(),
            merduty: $("#job").val(),
            merphone: $("#personalPhoneNumber").val(),
            merfax: $("#fax").val(),
            meremail: $("#email").val()
        },
        dataType : 'json',
        success: function (re) {
            if (re.code == 0) {
                alert("申请成功，请等待审核");
                window.location.href = "/";
            } else {
                alert('发送失败')
            }
        },
        error: function () {
            alert('服务器异常')
        }
    })
}

var isPhone = function (string) {
    var pattern = /^1[34578]\d{9}$/;
    if (pattern.test(string)) {
        return true;
    }
    alert('登录名格式不正确');
    return false;
};