$(function () {
    InitPage.init();
    InitPage.action();
});

var result;
var InitPage = {
    init:function(){
        Basic.initMyMenu();
        if (window.location.href.indexOf("shopInfoMgr") > 0) {
            memMgr.initList();
        }else if(window.location.href.indexOf("AdminAccept") > 0){
            ShopMgr.showAcceptList();
        }else if (window.location.href.indexOf("customerInfoMgr") > 0) {
            alert("功能尚未开放");
        }else if (window.location.href.indexOf("AdminManagePoints") > 0) {
            PointsMgr.initList();
        }
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
                // alert("功能尚未开放");
                window.location.href = "./customerInfoMgr.html?username="+username+"&role="+role+"";
            });
            //跳转《商家管理》
            $('#AdminShopManagementBtn').on('click',function () {
                window.location.href = "./shopInfoMgr.html?username="+username+"&role="+role+"";
            });
            //跳转《发布管理》
            $('#AdminReleaseManagementBtn').on('click',function () {
                alert("功能还没开放");
                window.location.href = "./AdminReleaseManagement.html?username="+username+"&role="+role+"";
            });
            //跳转《积分管理》
            $('#AdminIntegralManagement').on('click',function () {
                // alert("功能还没开放");
                window.location.href = "./AdminManagePoints.html?username="+username+"&role="+role+"";
            });

        //侧边栏-商家管理
            //商家账号管理
            $('#shopAccMgrBtn').on('click',function(){
                //还没有这个页面
                alert("功能还没开放");
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
            type: 'GET',
            url: '/getallmerchant',
            dataType: 'json',
            success: function (result) {
                var count = 0;
                $('#tbody').empty();
                $.each(result.data, function (index, obj) {
                    $('#tbody').append(
                        "<tr>\n" +
                        "                                            <td style=\"text-align: center\"> "+ obj.merid + "</td>\n" +
                        // 这个id要动态给
                        "                                            <td style=\"text-align: center\"> " + obj.mertype + "</td>\n" +
                        "                                            <td style=\"text-align: center\" id='label+" + count + "'>\n" +
                        "                                                <span class=\"label label-inverse\">功能尚未开放</span>\n" +
                        "                                            </td>\n" +
                        "                                            <td style=\"text-align: center\">"+ obj.merarea + "</td>\n" +
                        "                                            <td style=\"text-align: center\">"+ obj.merprincipal + "</td>\n" +
                        "                                            <td style=\"text-align: center\">"+ obj.mertelphone + "</td>\n" +
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
    //《商家列表页》

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
            url : '/application/list',
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

    //《商家审核页》
    //初始化信息列表
    showAcceptList:function () {
        $.ajax({
            type : "POST",
            url : "/examine/application/list",
            dataType : "json",
            success : function (res) {
                $.each(res.data, function (index, obj) {
                    console.log(obj);
                    var urlText = "/examine/application/"+obj.acamerchant;
                    var acaid = obj.acaid;
                    $.ajax({
                        type : "POST",
                        url : urlText,
                        dataType : "json",
                        success : function (res2) {
                          // $.each(res2.date, function (index2, res2.data) {
                              // $('#shopType').find("option:selected").attr("value");
                            // console.log(this);
                            $('#acceptShopList').append(
                                "<table>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                        <td style=\"width:120px\" class=\"text-left\">商家类型</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"shopType\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"shopType\" type=\"text\" style=\"width: 700px\" placeholder='"+res2.data.mertype+"'>\n" +
                                "                        </td>\n" +
                                "                    </tr>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                        <td style=\"width:120px\" class=\"text-left\">商家名称</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"shopName\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <!--改默认显示-->\n" +
                                "                            <input id=\"shopName\" type=\"text\" placeholder=\""+res2.data.mername+"\" style=\"width: 700px\"></td>\n" +
                                "                    </tr>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                    <td style=\"width:120px\" class=\"text-left\">商家地址</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"shopAddress\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"shopAddress\" type=\"text\" placeholder=\""+res2.data.merarea+"\" style=\"width: 700px\"></td>\n" +
                                "                    </tr>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                    <td style=\"width:120px\" class=\"text-left\">联系电话</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"phoneNumber\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"phoneNumber\" type=\"text\" placeholder=\""+res2.data.mertelphone+"\" style=\"width: 700px\"></td>\n" +
                                "                    </tr>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                    <td style=\"width:120px\" class=\"text-left\">消费积分比例</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"ratio\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"ratio\" type=\"text\" placeholder=\""+res2.data.mercumpresent+"\" style=\"width: 700px\"></td>\n" +
                                "                    </tr>\n" +
                                "                    <tr align=\"center\">\n" +
                                "                    <td style=\"width:120px\" class=\"text-left\">会员积分价值比例</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"disCount\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input  id=\"disCount\" type=\"text\" placeholder=\""+res2.data.merdicpresent+"\" style=\"width: 700px\"></td>\n" +
                                "                    </tr>\n" +
                                "                    <!--分隔线-->\n" +
                                "                                        <tr>\n" +
                                "                        <td>\n" +
                                "                            <div><hr class='hr-normal' /></div>\n" +
                                "                        </td>\n" +
                                "                                                <td>\n" +
                                "                            <div><hr class='hr-normal' /></div>\n" +
                                "                        </td>\n" +
                                "                    </tr>\n" +
                                "                        <tr align=\"center\">\n" +
                                "                          <td style=\"width:100px\" class=\"text-left\">姓名</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"realName\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"realName\" type=\"text\" placeholder=\""+res2.data.merprincipal+"\" style=\"width: 700px\"></td>\n" +
                                "             </tr>\n" +
                                "             <tr align=\"center\">\n" +
                                "                      <td style=\"width:120px\" class=\"text-left\">称谓</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"sex\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"sex\" type=\"text\" style=\"width: 700px\" placeholder='"+res2.data.merappellation+"'></td>\n" +
                                "                            <!--<select id=\"sex\" style=\"width: 710px; background-color: white\">-->\n" +
                                "                                <!--<option style=\"display:none;\" disabled selected>请选择称谓</option>-->\n" +
                                "                                <!--<option value=\"male\">男士</option>-->\n" +
                                "                                <!--<option value=\"female\">女士</option>-->\n" +
                                "                            <!--</select>-->\n" +
                                "                        </td>\n" +
                                "               </tr>\n" +
                                "                  <tr align=\"center\">\n" +
                                "                   <td style=\"width:120px\" class=\"text-left\">职务</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"job\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"job\" type=\"text\" placeholder=\""+res2.data.merduty+"\" style=\"width: 700px\"></td>\n" +
                                "                </tr>\n" +
                                "            <tr align=\"center\">\n" +
                                "                        <td style=\"width:120px\" class=\"text-left\">个人手机</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"personalPhoneNumber\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"personalPhoneNumber\" type=\"text\" placeholder=\""+res2.data.merphone+"\" style=\"width: 700px\"></td>\n" +
                                "            </tr>\n" +
                                "            <tr align=\"center\">\n" +
                                "                        <td style=\"width:120px\" class=\"text-left\">传真</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"fax\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"fax\" type=\"text\" placeholder=\""+res2.data.merfax+"\" style=\"width: 700px\"></td>\n" +
                                "            </tr>\n" +
                                "             <tr align=\"center\">\n" +
                                "             <td style=\"width:120px\" class=\"text-left\">电子邮箱</td>\n" +
                                "                        <td colspan=\"4\">\n" +
                                "                            <label for=\"email\" class=\"col-sm-2 control-label\" style=\"text-align: left\"></label>\n" +
                                "                            <input id=\"email\" type=\"text\" placeholder=\""+res2.data.meremail+"\" style=\"width: 700px\"></td></tr>\n" +
                                "                     <!--保存提示按钮+提示保存-->\n" +
                                "                     <tr >\n" +
                                "             <td colspan=\"12\" >\n" +
                                "                    <h6 class='text-right'>点击审核按钮后系统发送信息通知商家并分配账号，点击驳回后也会进行短信通知未通过</h6>\n" +
                                "                    <button class='btn pull-right' onclick='ShopMgr.rejectIt("+acaid+")'>\n" +
                                "                        <i class='icon-remove'></i>\n" +
                                "                       驳回\n" +
                                "                    </button>\n" +
                                "                        <div value='"+res2.data.merid+"'></div>"+
                                "                    <button class='btn pull-right' onclick='ShopMgr.acceptIt("+acaid+")'>\n" +
                                "                        <i class='icon-ok'></i>\n" +
                                "                        同意\n" +
                                "                    </button>\n" +
                                "                    </td>\n" +
                                "                    </tr>\n" +
                                "\n" +
                                "            </table>"
                            );
                          // })
                        },
                    });
                }
                )
            }
        });
    },

    acceptIt:function (getPrev) {
        var urlText = "/examine/application/"+getPrev+"/agree";
        console.log(getPrev);
        $.ajax({
            type : "POST",
            url : urlText,
            dataType : "json",
            success : function (res) {
                if(res.code == 0){
                    alert("审核通过");
                    window.location.reload(); // 刷新页面
                }else(
                    alert("后台错误，添加失败")
                )
            },
            error : function (res) {
                alert("服务器故障，添加失败");
            },
        });
    },

    rejectIt:function (getPrev) {
        var urlText = "/application/"+getPrev+"/disagree";
        $.ajax({
            type : "POST",
            url : urlText,
            dataType : "json",
            success : function (res) {
                if(res.code == 0){
                    alert("驳回成功");
                    window.location.reload(); // 刷新页面
                }else(
                    alert("后台错误，添加失败")
                )
            },
            error : function (res) {
                alert("服务器故障，添加失败");
            },
        });
    },
}

var PointsMgr = {

    initList:function () {
        $('#tbody').empty();
        $.ajax({
            type : "GET",
            url : "../consumecredit/submit/list",
            dataType : "json",
            success : function (result) {
                // alert("查询成功");
                $.each(result.data, function (index, obj) {
                    //未处理的记录
                    if(obj.csstat == null){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.csid+"</td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            // "                                                <span class=\"label label-success\">已完成</span>\n" +
                            // "                                                <!--<span class=\"label label-important\">已驳回</span>-->\n" +
                            "                                                <span class=\"label label-warning\">未处理</span>\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.cscredit+"</td>\n" +
                            // "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.csid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' href='#' onclick='PointsMgr.pass(" + obj.csid + ")'>\n" +
                            "                                                        <i class='icon-pencil'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#' onclick='PointsMgr.reject(" + obj.csid + ")'>\n" +
                            "                                                        <i class='icon-remove'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>"
                        );
                    }
                    //驳回的记录
                    else if(obj.csstat == false){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.csid+"</td>\n" +

                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            // "                                                <span class=\"label label-success\">已完成</span>\n" +
                            "                                                <span class=\"label label-important\">已驳回</span>\n" +
                            "                                                <!--<span class=\"label label-warning\">未处理</span>-->\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.cscredit+"</td>\n" +
                            // "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.csid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' href='#' onclick='alert(\"该记录已处理\")'>\n" +
                            "                                                        <i class='icon-pencil'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#' onclick='alert(\"该记录已处理\")'>\n" +
                            "                                                        <i class='icon-remove'></i>\n" +
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>"
                        );
                    }
                    //完成的记录
                    else if(obj.csstat == true){
                        $('#tbody').append(
                            "<tr>\n" +
                            "                                            <td style=\"text-align: center\" >"+obj.csid+"</td>\n" +

                            "                                            <td style=\"text-align: center\">"+obj.merid+"</td>\n" +
                            "                                            <td style=\"text-align: center\" id=\"state\">\n" +
                            "                                                <span class=\"label label-success\">已完成</span>\n" +
                            "                                                <!--<span class=\"label label-important\">已驳回</span>-->\n" +
                            "                                                <!--<span class=\"label label-warning\">未处理</span>-->\n" +
                            "                                            </td>\n" +
                            "                                            <td style=\"text-align: center\">"+obj.cscredit+"</td>\n" +
                            // "                                            <td style=\"text-align: center\">"+obj.recordtime+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <div value ='"+obj.csid+"'></div>\n" +
                            "                                                <div class='text-right'>\n" +
                            "                                                    <a class='btn btn-success btn-mini' href='#' onclick='alert(\"该记录已处理\");'>\n" +
                            "                                                        <i class='icon-pencil' ></i>\n" +
                            "                                                    </a>\n" +
                            "                                                    <a class='btn btn-danger btn-mini' href='#' onclick='alert(\"该记录已处理\");'>\n" +
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
            url: "/record/list",
            dataType: "json",
            success: function (result) {
                $.each(result.data, function (index, obj) {
                    var thiscsid = $(btn).parents().prev().attr('value');
                    var state = "";

                    if(obj.csid == thiscsid){
                        if(obj.transferstate == null){
                            state = "未处理"
                        }else if(obj.transferstate == 0){
                            state = "已驳回"
                        }else{
                            state = "已处理"
                        }

                        $('#csidText').attr('placeholder',thiscsid);
                        $('#memidText').attr('placeholder',obj.memid);
                        $('#meridText').attr('placeholder',obj.merid);
                        $('#adminidText').attr('placeholder',obj.adminid);
                        $('#cscreditText').attr('placeholder',obj.cscredit);
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

    reject:function (acid) {
        $.ajax({
            type: "POST",
            url: "/consumecredit/submit/update/" + acid,
            dataType: "json",
            data: {
                state: "false"
            },
            success:function(res) {
                if (res.code == 0) {
                    alert("驳回请求成功");
                    window.location.reload();
                } else {
                    alert("服务器错误");
                }
            },
            error: function () {
                alert("服务器繁忙");
            }
        });
    },

    pass:function (acid) {
        // alert("上缴");
        $.ajax({
            type: "POST",
            url: "/consumecredit/submit/update/" + acid,
            dataType: "json",
            data: {
                state: "true"
            },
            success:function(res) {
                if (res.code == 0) {
                    alert("通过审核成功");
                    window.location.reload();
                } else {
                    alert("服务器错误");
                }
            },
            error: function () {
                alert("服务器繁忙");
            }
        });

    }
};
