$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function(){
        Basic.initMyMenu();
    },
    action:function () {
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");

        //导航栏按钮
            //跳转《入盟申请审核》
            $('#AdminAcceptBtn').on('click',function () {
                window.location.href = "./AdminAccept.html?username="+username+"&role="+role+"";
            });
            //跳转《会员管理》
            $('#AdminMemberBtn').on('click',function () {
                window.location.href = "./customerInfoMgr.html?username="+username+"&role="+role+"";
            });
            //跳转《商家管理》
            $('#AdminShopManagementBtn').on('click',function () {
                window.location.href = "./shopInfoMgr.html?username="+username+"&role="+role+"";
            });
            //跳转《发布管理》
            $('#AdminReleaseManagementBtn').on('click',function () {
                window.location.href = "./AdminReleaseManagement.html?username="+username+"&role="+role+"";
            });
            //跳转《积分管理》
            $('#AdminIntegralManagement').on('click',function () {
                window.location.href = "./AdminManagePoints.html?username="+username+"&role="+role+"";
            });

        //侧边栏-商家管理
            //商家账号管理
            $('#shopAccMgrBtn').on('click',function(){
                //还没有这个页面
            });
            //商家统计信息
            $('#shopCountBtn').on('click',function () {
                alert("功能还没开放");
            })

        //侧边栏-发布管理
            //轮播窗
            $('#advertiseMgrBtn').on('click',function(){
                alert("功能还没开放");
            });
            //推荐商家
            $('#pointOutShopBtn').on('click',function () {
                alert("也还没开放啊")
            });

        //侧边栏-积分管理
            $('#allRecord').on('click',function(){


            });
            $('#treatedRecord').on('click',function(){


            });
            $('#untreatedRecord').on('click',function(){


            });
            $('#failedRecord').on('click',function(){


            });
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

        $('#updatePwdBtn').attr("href","../Login/changePassword.html");

        $('#adviceBtn').on('click', function () {
            alert("还没加modal代码进到html啊")
            Basic.showFeedback();
        })

        $('#cancelBtn').attr("href", "../Member/indexReal.html");
    },
};

var memMgr = {
    //刷新列表
    //有可变数量的标签的列表更新
    initList: function () {
        $.ajax({
            type: '',
            url: '',
            dataType: 'json',
            success: function (result) {
                var count = 0;
                $.each(result, function (index, obj) {
                    $('#tbody').append(
                        "<tr>\n" +
                        "                                            <td style=\"text-align: center\">2131212</td>\n" +
                        // 这个id要动态给
                        "                                            <td style=\"text-align: center\" id='label+" + count + "'>\n" +
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
                    var name = "#label" + count;
                    //按标签个数要套个循环
                    $(name).append(
                        //这里放入商家标签
                    );
                    //count要变化
                    count++;
                });
            },
        });
    },
    //展示信息
    showInfo: function(){

    },
    //修改信息
    updateInfo:function () {

    }
}

var ShopMgr = {
    //刷新列表
    initList:function () {
        // $('#tbody').empty();
        $('#tfoot').empty();
        $('#tfoot').append(
            "<tr>\n" +
            "                                    <th style='text-align: center'>\n" +
            "                                        <input style=\"text-align: center; width: 128px\" id=\"newMerID\" placeholder=\"编号\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: center'>\n" +
            "                                        <input style=\"text-align: center; width: 140px\" id=\"newMerType\" placeholder=\"类型\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: center'>\n" +
            // 这里应该是选择框
            "                                        <input style=\"text-align: center; width: 140px\" id=\"newMerType\" placeholder=\"标签\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: center'>\n" +
            "                                        <input style=\"text-align: center; width: 180px\" id=\"newMerAddress\" placeholder=\"地址\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: center'>\n" +
            "                                        <input style=\"text-align: center; width: 130px\" id=\"newMerManagerName\" placeholder=\"联系人\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: center'>\n" +
            "                                        <input style=\"text-align: center; width: 115px\" id=\"newMerPhoneNumber\" placeholder=\"联系电话\">\n" +
            "                                    </th>\n" +
            "                                    <th style='text-align: right'>\n" +
            "                                        <p><button id=\"fat-btn\" data-loading-text=\"loading...\" class=\"btn btn-primary\" style='width: 82px;height: 25px'>提交</button></p>\n" +
            "                                    </th>\n" +
            "                                </tr>"
        );
        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/examine/application/list',
            datatype : 'json',
            success : function (result) {
                $.each(result.data,function(index, obj){
                    //筛掉未处理的
                    if(obj.data.acastat != "未处理"){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.acaid+"</td>\n" +
                            "                                            <td style=\"text-align: center\">饮食</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"labels\"></td>\n" +
                            "                                            <td style=\"text-align: center\">四川省成都市</td>\n" +
                            "                                            <td style=\"text-align: center\">西兰</td>\n" +
                            "                                            <td style=\"text-align: center\">2144365234234</td>\n" +
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
                        //获取标签数
                        for(var i=0;i<obj.data.labels;i++){
                            $('#labels').append(
                                "<span class=\"label label-inverse\">火锅</span>"
                            );
                        }
                    }
                });
            }
        })
    },

    //展示信息
    showInfo:function () {

    },

    //修改信息
    updateInfo:function () {

    },
}

var PointsMgr = {

    initList:function () {
        $.ajax({
            type : "POST",
            url : "/creditconsume/record/list",
            dataType : "json",
            success : function (result) {
                alert("查询成功");
                $.each(result.data, function (index, obj) {
                    //未处理的记录
                    if(obj.transferstate == null){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.creconid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.memid+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            // "                                                <span class=\"label label-success\">已完成</span>\n" +
                            // "                                                <!--<span class=\"label label-important\">已驳回</span>-->\n" +
                            "                                                <span class=\"label label-warning\">未处理</span>\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.credits+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.creconid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' href='#' onclick='PointsMgr.showInfo(this)'>\n" +
                            "                                                        <i class='icon-pencil'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#'>\n" +
                            "                                                        <i class='icon-remove'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>"
                        );
                    }
                    //驳回的记录
                    else if(obj.transferstate == 0){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.creconid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.memid+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            // "                                                <span class=\"label label-success\">已完成</span>\n" +
                            "                                                <span class=\"label label-important\">已驳回</span>\n" +
                            "                                                <!--<span class=\"label label-warning\">未处理</span>-->\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.credits+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.creconid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' href='#' onclick='PointsMgr.showInfo(this)'>\n" +
                            "                                                        <i class='icon-pencil'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#'>\n" +
                            "                                                        <i class='icon-remove'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>"
                        );
                    }
                    //完成的记录
                    else if(obj.transferstate == 1){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.creconid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.memid+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            "                                                <span class=\"label label-success\">已完成</span>\n" +
                            "                                                <!--<span class=\"label label-important\">已驳回</span>-->\n" +
                            "                                                <!--<span class=\"label label-warning\">未处理</span>-->\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.credits+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.creconid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' onclick='PointsMgr.showInfo(this)'>\n" +
                            "                                                        <i class='icon-pencil' ></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#'>\n" +
                            "                                                        <i class='icon-remove'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>"
                        );
                    }
                });
            },
            error : function (result) {
                alert(result.code+":查询失败，服务器异常");
            }
        });
    },

    showInfo:function (btn) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/creditconsume/record/list",
            dataType: "json",
            success: function (result) {
                $.each(result.data, function (index, obj) {
                    var thisCreconid = $(btn).parents().prev().attr('value');
                    var state = "";

                    if(obj.creconid == thisCreconid){
                        if(obj.transferstate == null){
                            state = "未处理"
                        }else if(obj.transferstate == 0){
                            state = "已驳回"
                        }else{
                            state = "已处理"
                        }

                        $('#creconidText').attr('placeholder',thisCreconid);
                        $('#memidText').attr('placeholder',obj.memid);
                        $('#meridText').attr('placeholder',obj.merid);
                        $('#adminidText').attr('placeholder',obj.adminid);
                        $('#creditsText').attr('placeholder',obj.credits);
                        $('#valueText').attr('placeholder',obj.value);
                        $('#recordtimeText').attr('placeholder',obj.recordtime);
                        $('#transferstateText').attr('placeholder',state);
                        $('#handletimeText').attr('placeholder',obj.handletime);

                        $('#pointsInfoModal').modal('show');
                    }
                })
            }
        });
    },

    reject:function () {

    },

    pass:function () {

    }
};