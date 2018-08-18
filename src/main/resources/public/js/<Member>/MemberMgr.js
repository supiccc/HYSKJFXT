$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        Basic.initMyMenu();
        Basic.initMainPageMenuBtn();
    },
    //注册按钮
    action:function () {
        //导航栏
            //跳转《首页》
            $('#indexBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./indexReal.html?username="+username+"&role="+role+"";
            });
            //跳转《平台商家》
            $('#shopListBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
            })
            //跳转《我的信息》

        //侧边栏：消费记录
            //跳转《储值/现金消费记录》
            $('#shoppingListBtn').on('click', function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./memberShoppingList.html?username="+username+"&role="+role+"";
            });
            //跳转《积分消费记录》
            $('#pointShoppingListBtn').on('click', function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./memberpointShoppingList.html?username="+username+"&role="+role+"";
            });

        //侧边栏：我的卡包
            //跳转《我的会员卡》
            $('#myCardsBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./memberCardList.html?username="+username+"&role="+role+"";
            });
            //跳转《补卡记录》
            $('#changeCardHistoryBtn').on('click',function () {
                var username = Basic.getPassingStr("username");
                var role = Basic.getPassingStr("role");
                window.location.href = "./memberCardHistoryList.html?username="+username+"&role="+role+"";
            });
    },
};

//其他方法
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

    //为什么修改无效？
    initMainPageMenuBtn:function(){
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        $('#accountStateDiv').empty();
        if(username == "member"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">会员:"+username+"</a>"
            );
        }else if(username == "admin"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">平台管理员:"+username+"</a>"
            );
        }else if(username == "merchantAdmin"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家管理员:"+username+"</a>"
            );
        }else if(username == "merchantFrontDesk"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家前台:"+username+"</a>"
            );
        }else if(username == "merchantCManager"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家客户经理:"+username+"</a>"
            );
        }else if(username == "merchantDManager"){
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">商家部门经理:"+username+"</a>"
            );
        }else{
            $('#accountStateDiv').append(
                "<a id=\"LoginPageBtn\">登录</a>"
            );
        }
        $('#LoginPageBtn').on('click',function () {
            window.location.href = "./memberShopInfo.html?username="+username+"&role="+role+"";
        });
    },

    //根据账户信息初始化《我的》按钮
    initMyMenu:function(){
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        //这里需要补充账户类型
        //会员
        $("#myMenu").empty();
        if(role == "member"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>会员:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--总积分-->\n" +
                "                            <li>\n" +
                "                                <a id=\"totalPointBtn\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    总积分\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <li>\n" +
                "                                <a id=\"memberSearchBtn\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    消费记录\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--我的资料 同账户管理-->\n" +
                "                            <li>\n" +
                "                                <a id=\"myInfoBtn\">\n" +
                "                                    <i class='icon-info'></i>\n" +
                "                                    我的资料\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--我的卡包-->\n" +
                "                            <li>\n" +
                "                                <a  id=\"cardListBtn\">\n" +
                "                                    <i class='icon-credit-card'></i>\n" +
                "                                    我的卡包\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--修改登录密码-->\n" +
                "                            <li>\n" +
                "                                <a href='#' id=\"updatePwdBtn\">\n" +
                "                                    <i class='icon-cog'></i>\n" +
                "                                    修改登录密码\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--修改交易密码-->\n" +
                "                            <li>\n" +
                "                                <a id=\"updatePayPwdBtn\">\n" +
                "                                    <i class='icon-cog'></i>\n" +
                "                                    修改交易密码\n" +
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
                "                                <a btn=\"cancelBtn\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            //我的菜单
            //弹出《我的积分》
            $('#totalPointBtn').on('click',function () {
                alert('click');
                Basic.showIntegral();
            });
            //弹出《我的资料》
            $('#myInfoBtn').on('click',function () {
                Basic.show();
            });
            //弹出《意见反馈》
            $('#adviceBtn').on('click',function () {
                Basic.showFeedback();
            })
            //跳转《我的记录》
            $('#memberSearchBtn').on('click',function () {
                window.location.href = "./memberShoppingList.html?username="+username+"&role="+role+"";
            });
            //跳转《我的卡包》
            $('#cardListBtn').on('click',function () {
                window.location.href = "./memberCardHistoryList.html?username="+username+"&role="+role+"";
            })
            //跳转《修改密码》
            $('#updatePwdBtn').attr("href","../Login/changePassword.html");

            //跳转《修改交易密码》
            $('#updatePayPwdBtn').attr("href","../Login/changePayPassword.html");

            //跳转《注销》
            $('#shopListBtn').on('click',function () {
                window.location.href = "./indexReal.html";
            })


        }
        //平台-管理员
        else if(role == "admin"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>平台管理员:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--管理系统-->\n" +
                "                            <li>\n" +
                "                                <a id=\"mgrSystemBtn\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    管理系统\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--反馈-->\n" +
                "                            <li>\n" +
                "                                <a id=\"adviceBtn2\">\n" +
                "                                    <i class='icon-frown'></i>\n" +
                "                                    发送反馈\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--分隔线-->\n" +
                "                            <li class='divider'></li>\n" +
                "                            <li>\n" +
                "                                <a btn=\"cancelBtn2\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            $('#mgrSystemBtn').on('click',function () {
                window.location.href = "../Manager/AdminAccept.html?username="+username+"&role="+role+"";
            });
            $('#adviceBtn2').on('click',function () {
                Basic.showFeedback();
            });
            $('#cancelBtn2').on('click',function () {
                window.location.href = "./indexReal.html";
            });
        }
        //商家-管理员
        else if(role == "merchantAdmin"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>商家管理员:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--管理系统-->\n" +
                "                            <li>\n" +
                "                                <a id=\"mgrSystemBtn4\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    管理系统\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--反馈-->\n" +
                "                            <li>\n" +
                "                                <a id=\"adviceBtn3\">\n" +
                "                                    <i class='icon-frown'></i>\n" +
                "                                    发送反馈\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--分隔线-->\n" +
                "                            <li class='divider'></li>\n" +
                "                            <li>\n" +
                "                                <a btn=\"cancelBtn3\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            $('#mgrSystemBtn2').on('click',function () {
                window.location.href = "../Business-Admin/shopAdminAccountManagement.html?username="+username+"&role="+role+"";
            });
            $('#adviceBtn3').on('click',function () {
                Basic.showFeedback();
            });
            $('#cancelBtn3').on('click',function () {
                window.location.href = "./indexReal.html";
            });
        }
        //商家-前台
        else if(role == "merchantFrontDesk"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>商家前台:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--管理系统-->\n" +
                "                            <li>\n" +
                "                                <a id=\"mgrSystemBtn3\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    管理系统\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--反馈-->\n" +
                "                            <li>\n" +
                "                                <a id=\"adviceBtn4\">\n" +
                "                                    <i class='icon-frown'></i>\n" +
                "                                    发送反馈\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--分隔线-->\n" +
                "                            <li class='divider'></li>\n" +
                "                            <li>\n" +
                "                                <a btn=\"cancelBtn4\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            $('#mgrSystemBtn3').on('click',function () {
                window.location.href = "../Business-FrontDesk/frontDeskConsume.html?username="+username+"&role="+role+"";
            });
            $('#adviceBtn4').on('click',function () {
                Basic.showFeedback();
            });
            $('#cancelBtn4').on('click',function () {
                window.location.href = "./indexReal.html";
            });
        }
        //商家-客户经理
        else if(role == "merchantCManager"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>商家客户经理:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--管理系统-->\n" +
                "                            <li>\n" +
                "                                <a id=\"mgrSystemBtn3\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    管理系统\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--反馈-->\n" +
                "                            <li>\n" +
                "                                <a id=\"adviceBtn4\">\n" +
                "                                    <i class='icon-frown'></i>\n" +
                "                                    发送反馈\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--分隔线-->\n" +
                "                            <li class='divider'></li>\n" +
                "                            <li>\n" +
                "                                <a btn=\"cancelBtn4\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            $('#mgrSystemBtn4').on('click',function () {
                window.location.href = "../Business-CManager/customerManagerMemberInfoAdd.html?username="+username+"&role="+role+"";
            });
            $('#adviceBtn5').on('click',function () {
                Basic.showFeedback();
            });
            $('#cancelBtn5').on('click',function () {
                window.location.href = "./indexReal.html";
            });
        }
        //商家-部门经理
        else if(role == "merchantDManager"){
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>商家部门经理:"+username+"</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n" +
                "                        <!--点开菜单后弹出的内容-->\n" +
                "                        <ul class='dropdown-menu'>\n" +
                "                            <!--点击菜单项后跳转的页面或弹出模态框-->\n" +
                "                            <!--管理系统-->\n" +
                "                            <li>\n" +
                "                                <a id=\"mgrSystemBtn3\">\n" +
                "                                    <i class='icon-key'></i>\n" +
                "                                    管理系统\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--反馈-->\n" +
                "                            <li>\n" +
                "                                <a id=\"adviceBtn4\">\n" +
                "                                    <i class='icon-frown'></i>\n" +
                "                                    发送反馈\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <!--分隔线-->\n" +
                "                            <li class='divider'></li>\n" +
                "                            <li>\n" +
                "                                <a btn=\"cancelBtn4\">\n" +
                "                                    <i class='icon-signout'></i>\n" +
                "                                    注销退出\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>"
            );
            $('#mgrSystemBtn5').on('click',function () {
                window.location.href = "../Business-DManager/departManagerAlliance.html?username="+username+"&role="+role+"";
            });
            $('#adviceBtn6').on('click',function () {
                Basic.showFeedback();
            });
            $('#cancelBtn6').on('click',function () {
                window.location.href = "./indexReal.html";
            });
        }
        //未登录
        else{
            $('#myMenu').append(
                "<a class='dropdown-toggle' data-toggle='dropdown' href='../Login/sign_in.html'>\n" +
                "                            <!--身份或者名称 建议显示的是身份就可以了-->\n" +
                "                            <span class='user-name hidden-phone'>登录</span>\n" +
                "                            <b class='caret'></b>\n" +
                "                        </a>\n"
            );
        }
    },

    //其他
    //获取总积分:modal-container-625459
    show:function(){
        $('#modal-container-625459').modal('show');
    },

    //获取我的资料:modal-container-Integral
    showIntegral:function(){
        $('#modal-container-Integral').modal('show');
    },

    //意见反馈:modal-container-feedback
    showFeedback:function(){
        $('#modal-container-feedback').modal('show');
    },

    //加载消费记录
    loadShoppingList:function () {
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        window.location.href = "./memberShoppingList.html"
    },

    //加载储值消费记录
    loadPointsShoppingList:function () {
        window.location.href = "./memberpointShoppingList.html"
    },
};

//平台商家页
var shopMgr = {
    // 缺少一个跳转链接
    //缺少一个商家详情页面
    //缺少一个产品详情页面
};

//消费记录页
var shoppingRecordMgr = {
    //memberpointShoppingList.html
};

//我的资料模态框
var accInfoMgr = {

};

//我的卡包页
var cardMgr = {
    //补卡记录：memberCardHistoryList.html（列表项是什么）
    //我的会员卡：memberCardList.html（列表项是什么）
};