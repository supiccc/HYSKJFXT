$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {

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

var AcceptInfoMgr = {

};