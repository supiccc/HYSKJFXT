$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        Basic.initMainPageMenuBtn();
    },
    action:function f() {
        $('#RegisPageBtn').on('click',function(){
            window.location.href = "../Login/sign_up.html";
        });
    }
};

var Basic = {
    //设置登录按钮样式、触发方法
    initMainPageMenuBtn:function(){
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        $('#accountStateDiv').empty();
        //修改样式
        if(role == "member"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">会员:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else if(role == "admin"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">平台管理员:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else if(role == "merchantAdmin"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家管理员:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else if(role == "merchantFrontDesk"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家前台:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else if(role == "merchantCManager"){
            // alert("西兰");
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家客户经理:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else if(role == "merchantDManager"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家部门经理:"+username+"</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            // });
            $('#cancelPageBtn').on('click', function () {
                $.ajax({
                    type : 'GET',
                    url : '/logout',
                    dataType : 'json',
                    success: function(res) {
                        // result = res;
                        if (res.code == 0) {
                            // alert("获取成功");
                            window.location.href = "../Login/sign_in.html";
                        } else {
                            alert("服务器繁忙，请稍后再试");
                        }
                    },
                    error:function () {
                        alert("服务器繁忙，请稍后再试");
                    }
                });
            });
        }else{
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">登录</a>"
            );
            $('#LoginPageBtn').on('click',function () {
                window.location.href = "../Login/sign_in.html";
            });
            // $('#shopPageBtn').on('click',function () {
            //     window.location.href = "./memberShopInfo.html";
            // });
            $('#cancelPageBtn').empty();
        }
    },


    //获取url传过来到参数
    getPassingStr:function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
        var context = "";
        if (r != null)
            context = r[2];
        reg = null;
        r = null;
        return context == null || context == "" || context == "undefined" ? "" : context;
    },
}