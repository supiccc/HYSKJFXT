$(function () {

});

var InitPage = {
    init:function () {
        Basic.initMyMenu();
    },
    action:function () {
        //导航栏
            //会员管理
            $('#memberMgrBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./customerManagerMemberInfoAdd.html?username="+username+"&role="+role+"";
            });
            //消费充值管理
            $('#checkInBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./customerManagerConsume.html?username="+username+"&role="+role+"";
            });

        //侧边栏


    },
};

var Basic = {
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

    //根据账户信息初始化《我的》按钮
    initMyMenu:function(){
        alert("进来啦西兰");
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        //这里需要补充账户类型
        //会员
        $("#myMenu").empty();
        $('#myMenu').append(
            "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
            "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
            "                            <span class='user-name hidden-phone'>"+username+"</span>\n" +
            "                            <b class='caret'></b>\n" +
            "                        </a>\n" +
            "                        <!--点开菜单后弹出的内容-->\n" +
            "                        <ul class='dropdown-menu'>\n" +
            "                             <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
            "                            <!--修改密码-->\n" +
            "                            <li>\n" +
            "                                <a id=\"pointsMgrBtn\">\n" +
            "                                    <i class='icon-cog'></i>\n" +
            "                                    积分管理\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                <a id=\"updatePwdBtn\">\n" +
            "                                    <i class='icon-cog'></i>\n" +
            "                                    修改密码\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <!--反馈-->\n" +
            "                            <li>\n" +
            "                                <a id=\"adviceBtn\">\n" +
            "                                    <i class='icon-frown'></i>\n" +
            "                                    发送反馈\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <!--分隔线-->\n" +
            "                            <li class='divider'></li>\n" +
            "                            <li>\n" +
            "                                <a id=\"cancelBtn\">\n" +
            "                                    <i class='icon-signout'></i>\n" +
            "                                    注销退出\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                        </ul> "
        );
        $('#pointsMgrBtn').on('click',function () {

        });

        $('#updatePwdBtn').attr("href","../<Login>/changePassword.html");

        $('#adviceBtn').on('click', function () {
            Basic.showFeedback();
        });

        $('#cancelBtn').attr("href", "../<Member>/indexReal.html");
    },

};

//会员管理
var customerMgr = {
    //我的会员-登记会员信息：customerManagerMemberInfoAdd.html

    //我的会员-会员信息变更：缺页面，列表有啥内容？

    //我的会员-变更历史查询：缺页面，列表有啥内容？

    //会员卡发放：customerManagerCard.html

    //会员卡补卡：缺页面，表单有啥内容？

    //会员卡补卡历史：缺页面，列表有啥内容？
};

// 消费管理-消费登记
var checkIn = {

    //储值：customerManagerConsume.html

    //现金：customerManagerConsume.html

    //积分：customerManagerConsume.html
};

// 消费管理-充值管理
var rechargeMgr = {
    //充值：customerManagerRecharge.html

    //充值记录查询：缺页面，列表有啥内容？
}

var pointsMgr = {
    //积分管理
    //缺页面：与<Business-Admin>一样，基本照搬即可
}