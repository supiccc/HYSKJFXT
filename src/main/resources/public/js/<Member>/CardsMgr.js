$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        // memberHistoryMgr.loadShoppingList();
    },
    action:function () {
        //侧边栏
        //跳转《我的会员卡》
        $('#myCardsBtn').on('click',function () {
            window.location.href = "./memberCardList.html";
        });
        //跳转《补卡记录》
        $('#changeCardHistoryBtn').on('click',function () {
            window.location.href = "./memberCardHistoryList.html";
        });

        //导航栏
        //跳转《首页》
        $('#indexBtn').on('click',function () {

        });
        //跳转《平台商家》
        $('#shopListBtn').on('click',function () {
            window.location.href = "./memberShopInfo.html";
        })

        //我的菜单
        //弹出《我的积分》
        $('#totalPointBtn').on('click',function () {
            memberHistoryMgr.show();
        });
        //弹出《我的资料》
        $('#myInfoBtn').on('click',function () {
            memberHistoryMgr.showIntegral();
        });
        //弹出《意见反馈》
        $('#adviceBtn').on('click',function () {
            memberHistoryMgr.showFeedback();
        })
        //跳转《我的记录》
        $('#memberSearchBtn').on('click',function () {
            window.location.href="./memberShoppingList.html";
        });
        //跳转《我的卡包》
        $('#cardListBtn').on('click',function () {

        })

        //跳转《修改密码》
        $('#updatePwdBtn').on('click',function () {

        })

        //跳转《修改交易密码》
        $('#updatePayPwdBtn').on('click',function () {

        })

        //跳转《注销》
        $('#shopListBtn').on('click',function () {

        })

    },
};

var memberHistoryMgr = {
    initList:function(){
        //初始化列表
    },

    infoModal:function(){
        //展示详细信息
    },

    show:function(){
        //获取总积分
        $('#modal-container-625459').modal('show');
    },

    showIntegral:function(){
        //获取我的资料
        $('#modal-container-Integral').modal('show');
    },

    showFeedback:function(){
        //获取
        $('#modal-container-feedback').modal('show');
    },

    loadShoppingList:function () {
        window.location.href = "./memberShoppingList.html"
    },
    loadPointsShoppingList:function () {
        window.location.href = "./memberpointShoppingList.html"
    },
};