$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {

    },
    action:function () {
        //侧边栏
        $('#shoppingListBtn').on('click',function () {
            pointShoppingMgr.loadShoppingList();
        });
        $('#pointsShoppingListBtn').on('click',function () {
            pointShoppingMgr.loadPointsShoppingList();
        });

        //导航栏
        //跳转《首页》
        $('#indexBtn').on('click',function () {

        });
        //跳转《平台商家》
        $('#shopListBtn').on('click',function () {
            window.location.href = "./memberShopInfo.htmll";
        })


        //我的菜单
        //弹出《我的积分》
        $('#totalPointBtn').on('click',function () {
            pointShoppingMgr.show();
        });
        //弹出《我的资料》
        $('#myInfoBtn').on('click',function () {
            pointShoppingMgr.showIntegral();
        });
        //弹出《意见反馈》
        $('#adviceBtn').on('click',function () {
            pointShoppingMgr.showFeedback();
        })
        //跳转《我的记录》
        $('#memberSearchBtn').on('click',function () {
            window.location.href = './memberShopInfo.html';
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

var pointShoppingMgr = {
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
        alert("调试");
        window.location.href = "./memberShoppingList.html"
    },
    loadPointsShoppingList:function () {
        window.location.href = "./memberpointShoppingList.html"
    },
};