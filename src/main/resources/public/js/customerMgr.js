$(function () {
    // 在这里调用InitPage的方法
    InitPage.Init();
    InitPage.action();
});

var InitPage = {
    Init:function () {

    },
    action:function () {
        //导航栏的按钮
        //导航栏按钮
        //跳转《入盟申请审核》
        $('#AdminAcceptBtn').on('click',function () {
            window.location.href = './AdminAccept.html';
        });
        //跳转《会员管理》
        $('#AdminMemberBtn').on('click',function () {
            window.location.href = './customerInfoMgr.html';
        });
        //跳转《商家管理》
        $('#AdminShopManagementBtn').on('click',function () {
            window.location.href = './shopInfoMgr.html';
        });
        //跳转《发布管理》
        $('#AdminReleaseManagementBtn').on('click',function () {

        });
        //跳转《积分管理》
        $('#AdminIntegralManagement').on('click',function () {
            window.location.href = './AdminManagePoints.html';
        });
        //跳转《所有站内消息》
        $('#InfoBtn').on('click',function () {

        });
        //我的按钮
        //跳转《修改密码》
        $('#updatePwdBtn').on('click',function () {

        });
        //注销
        $('#cancelBtn').on('click',function () {

        })
    }
};

var customerInfoMgr = {
    //有可变数量的标签的列表更新
    initList:function () {
        $.ajax({
            type : '',
            url : '',
            dataType : 'json',
            success : function (result) {
                var count = 0;
                $.each(result, function (index, obj) {
                    $('#tbody').append(
                        "<tr>\n" +
                        "                                            <td style=\"text-align: center\">2131212</td>\n" +
                                                                     // 这个id要动态给
                        "                                            <td style=\"text-align: center\" id='label+"+count+"'>\n" +
                        "                                                <span class=\"label label-inverse\">火锅</span>\n" +
                        "                                                <span class=\"label label-inverse\">快餐</span>\n" +
                        "                                                <span class=\"label label-inverse\">火锅</span>\n" +
                        "                                                <span class=\"label label-inverse\">快餐</span>\n" +
                        "                                            </td>\n" +
                        "                                            <td style=\"text-align: center\">西兰</td>\n" +
                        "                                            <td style=\"text-align: center\">女</td>\n" +
                        "                                            <td style=\"text-align: center\">2010年10月1日</td>\n" +
                        "                                            <td style=\"text-align: center\">214436522@qq.com</td>\n" +
                        "                                            <td>\n" +
                        "                                                <div class='text-right'>\n" +
                        "                                                    <a class='btn btn-success btn-mini' href='#' onclick='ShopInfoMgr.showInfo(this)'>\n" +
                        "                                                        <i class='icon-pencil'></i>\n" +
                        "                                                    </a>\n" +
                        "                                                    <a class='btn btn-danger btn-mini' href='#'>\n" +
                        "                                                        <i class='icon-remove'></i>\n" +
                        "                                                    </a>\n" +
                        "                                                </div>\n" +
                        "                                            </td>\n" +
                        "                                        </tr>"
                    );
                    var name = "#label"+count;
                    //按标签个数要套个循环
                    $(name).append(
                        //这里放入商家标签
                    );
                    //count要变化
                    count++;
                });
            },
        });
    }
};