$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        Basic.initMyMenu();
        // AccMgr.initList();
        // AccMgr.getInfo();
        var thisLocation = window.location.href;
        if(thisLocation.indexOf("AccountManagement") != -1){
            AccMgr.getInfo();
        }
    },
    action:function () {
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        //账户管理
        $('#AccountMrgBtn').on('click',function () {
            window.location.href = "./shopAdminAccountManagement.html?username="+username+"&role="+role+"";
        });

        //展示信息
        $('#InfoMrgBtn').on('click',function () {
            window.location.href = "./shopAdminShowInfo.html?username="+username+"&role="+role+"";
        });

        //同盟管理
        $('#AllianceBtn').on('click',function(){
            window.location.href = "./shopAdminAlliance.html?username="+username+"&role="+role+"";
        });

        //侧边栏
        //展示信息
            //商家信息维护
            $('#showInfoMgrBtn').on('click', function () {
                window.location.href = "./shopAdminShowInfo.html?username="+username+"&role="+role+"";
            });
            //产品维护
            $('#productInfoMgrBtn').on('click', function () {
                window.location.href = "./shopAdminShowInfoProduct.html?username="+username+"&role="+role+"";
            });

        //同盟管理
            //申请入盟
            $('#joinBtn').on('click',function(){
                window.location.href = "./shopAdminAlliance.html?username="+username+"&role="+role+"";
            });
            //报表
            $('#diagramBtn').on('click',function(){
                alert("报表功能没开放啊！");
            });
            //统计
            $('#countBtn').on('click',function(){
                alert("统计也没开放，不要急！");
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
            "                            <!--总积分-->\n" +
            "                              <li>\n" +
            "                                <a id=\"pointsMgrBtn\">\n" +
            "                                    <i class='icon-info'></i>\n" +
            "                                    积分管理\n" +
            "                                </a>\n" +
            "                            </li>\n" +
            "                            <!--配置管理-->\n" +
            "                            <li>\n" +
            "                                <a id=\"settingBtn\">\n" +
            "                                    <i class='icon-puzzle-piece'></i>\n" +
            "                                    <!--菜单项-->\n" +
            "                                    配置管理\n" +
            "                                </a>\n" +
            "                            </li>\n" +
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
        //积分管理
        $('#pointsMgrBtn').on('click', function () {
            var username = Basic.getPassingStr("username");
            var role = Basic.getPassingStr("role");
            window.location.href = "./shopAdminPointsMgr.html?username="+username+"&role="+role+"";
        });

        //配置管理
        $('#settingBtn').on('click', function () {
            var username = Basic.getPassingStr("username");
            var role = Basic.getPassingStr("role");
            alert("还没做配置管理页面呢");
            // window.location.href = "./shopAdminPointsMgr.html?username="+username+"&role="+role+"";
        });

        $('#updatePwdBtn').attr("href","../Login/changePassword.html");

        $('#adviceBtn').on('click', function () {
            Basic.showFeedback();
        })

        $('#cancelBtn').attr("href", "../Member/indexReal.html");
    },

    //意见反馈:modal-container-feedback
    showFeedback:function(){
        alert("我好像还没放modal代码进到html");
        $('#modal-container-feedback').modal('show');
    },
};

//账户管理
var AccMgr = {

    //获取信息#废弃
    getInfo:function(){
        //拉取所有（端口错误）
        $.ajax({
            type : 'POST',
            //现在是查询所有账号，迟些界面连起来后要记得该成查询相关的子账号
            url: "http://localhost:8080/merchantAccManage/queryByMerID",
            data : {
                merid : Basic.getPassingStr("username");
            }
            dataType: 'json',
            success: function (result) {
                if(result.code == 0){
                    AccMgr.initList(result);
                    // return result;
                    alert("查询成功，找到"+result.data.length+"条记录,正在加载中");
                }else{
                    alert("查询失败，后台故障");
                    return;
                }
            },
            error: function () {
                alert("查询失败，服务器异常");
                return;
            }
        });
    },

    //初始化列表
    initList:function(result){
        // $.ajax({
        //     type : 'POST',
        //     //现在是查询所有账号，迟些界面连起来后要记得该成查询相关的子账号
        //     url: "http://localhost:8080/merchantAccManage/queryAll",
        //     dataType: 'json',
        //     success: function (res) {
        //         if(res.code == 0){
        //             // accountManagement.getAccountList(result);
        //             result = res;
        //             alert("查询成功，找到"+result.data.length+"条记录,正在加载中");
        //         }else{
        //             alert("查询失败，后台故障");
        //             return;
        //         }
        //     },
        //     error: function () {
        //         alert("查询失败，服务器异常");
        //         return;
        //     }
        // });

        $('#content-wrapper-acc-list').empty();
        qiantaiCount = 0;
        kehujingliCount = 0;
        bumenjingliCount = 0;
        $('#content-wrapper-acc-list').append(
            "<br/>\n" +
            "            <!--添加子账号设置开始-->\n" +
            "                <div class='row-fluid'>\n" +
            "                    <div class='span12 box'>\n" +
            "                        <div class='box-header dark-background'>\n" +
            "                            <div class='title'>\n" +
            "                                <div class='icon-plus'></div>\n" +
            "                                添加子账号\n" +
            "                            </div>\n" +
            "                            <div class='actions'>\n" +
            "                                <!--<a href=\"#\" class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>-->\n" +
            "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <!--选择账号类型设置开始-->\n" +
            "                    <div class='box-content'>\n" +
            "                        <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
            "                            <!--选择账号类型-->\n" +
            "                            <div class='control-group'>\n" +
            "                                <label class='control-label'>选择账号类型</label>\n" +
            "                            <div class='controls'id=\"addUserType\">\n" +
            "                                <label class='radio inline'>\n" +
            "                                    <input type='radio' value='' name=\"typeRadios\" />前台</label>\n" +
            "                                <label class='radio inline'>\n" +
            "                                    <input type='radio' value='' name=\"typeRadios\"/>客户经理</label>\n" +
            "                                <label class='radio inline'>\n" +
            "                                    <input type='radio' value='' name=\"typeRadios\" checked/>部门经理</label>\n" +
            "                            </div>\n" +
            "                    </div>\n" +
            "                    <!--选择账号类型设置结束-->\n" +
            "                <!--商家账号手机号输入-->\n" +
            "                    <hr class='hr-normal' />\n" +
            "                    <div class='control-group'>\n" +
            "                        <label class='control-label' for='addPhoneNumber'>账号</label>\n" +
            "                    <div class='controls'>\n" +
            "                        <input id='addPhoneNumber' placeholder='输入手机号码' type='text' required=\"required\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <!--商家账号手机号输入结束-->\n" +
            "                <!--选择账号启用状态-->\n" +
            "                <hr class='hr-normal' />\n" +
            "                <div class='control-group'>\n" +
            "                    <label class='control-label'>选择账号启用状态</label>\n" +
            "                    <div class='controls'>\n" +
            "                        <div class=\"checkbox\">\n" +
            "                            <label>\n" +
            "                                <input type=\"checkbox\" checked disabled=\"disabled\">启用\n" +
            "                            </label>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <!--选择子账号启用状态结束-->\n" +
            "                <div class='form-actions' style=\"text-align: right\">\n" +
            "                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
            "                    <button class='btn' id=\"addBtn\" onclick=AccMgr.addAccount()'>\n" +
            "                        <i class='icon-save'></i>\n" +
            "                        确认添加\n" +
            "                    </button>\n" +
            "                    <!--<button class='btn' type='submit'>取消</button>-->\n" +
            "                </div>\n" +
            "            </form>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"
        );
        for (var i = 0; i < result.data.length; i++) {
            // 启用的《前台》账号
            if ((result.data[i].macacctype == 2 || result.data[i].macacctype == 12) && result.data[i].macenable == 1) {
                qiantaiCount++;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               前台#"+qiantaiCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\" checked>启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            // 未启用的《前台》账号
            else if ((result.data[i].macacctype == 2 || result.data[i].macacctype == 12) && result.data[i].macenable != 1) {
                qiantaiCount++;
                info = "qiantaiClose_"+qiantaiCount;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               前台#"+qiantaiCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\">启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            // 启用的《客户经理》账号
            else if ((result.data[i].macacctype == 3 || result.data[i].macacctype == 13 )&& result.data[i].macenable == 1) {
                kehujingliCount++;
                info = "kehujingliOpen_"+kehujingliCount;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               客户经理#"+kehujingliCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\" checked>启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            // 未启用的《客户经理》账号
            else if ((result.data[i].macacctype == 3 || result.data[i].macacctype == 13 )&& result.data[i].macenable != 1) {
                kehujingliCount++;
                info = "kehujingliClose_"+kehujingliCount;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               客户经理#"+kehujingliCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\">启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            // 启用的《部门经理》账号
            else if (result.data[i].macacctype == 4 && result.data[i].macenable == 1) {
                bumenjingliCount++;
                info = "bumenjingliOpen_"+bumenjingliCount;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               部门经理#"+bumenjingliCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\" checked>启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            // 未启用的《部门经理》账号
            else if (result.data[i].macacctype == 4 && result.data[i].macenable != 1) {
                bumenjingliCount++;
                info = "bumenjingliClose_"+bumenjingliCount;
                $('#content-wrapper-acc-list').append(
                    "<br/>\n" +
                    "                <!--添加子账号设置开始-->\n" +
                    "                <div class='row-fluid'>\n" +
                    "                    <div class='span12 box'>\n" +
                    "                        <div class='box-header dark-background'>\n" +
                    "                            <div class='title'>\n" +
                    "                               部门经理#"+bumenjingliCount+""+
                    "                            </div>\n" +
                    "                            <div class='actions'>\n" +
                    "                                <a onclick='accountManagement.deleteAccount(this)' class=\"btn box-remove btn-mini btn-link\"><i class='icon-remove'></i></a>\n" +
                    "                                <a href=\"#\" class=\"btn box-collapse btn-mini btn-link\"><i></i></a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!--选择账号类型设置开始-->\n" +
                    "                        <div class='box-content'>\n" +
                    "                            <form accept-charset=\"UTF-8\" action=\"#\" class=\"form form-horizontal\" method=\"post\" style=\"margin-bottom: 0;\" /><div style=\"margin:0;padding:0;display:inline\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input name=\"authenticity_token\" type=\"hidden\" value=\"CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=\" /></div>\n" +
                    "                            <!--选择账号类型-->\n" +
                    //prev+7
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号类型</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='qiantaiChecked'>前台</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' checked value='kehujingliChecked'>客户经理</label>\n" +
                    "                                    <label class='radio inline'>\n" +
                    "                                        <input type='radio' name='userType' value='bumenjingliChecked'>部门经理</label>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--选择账号类型设置结束-->\n" +
                    "                            <!--商家账号手机号输入-->\n" +
                    //prev+6
                    "                            <hr class='hr-normal' />\n" +
                    //prev+5
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>账号</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input id='phoneNum' value='"+result.data[i].macacc+"' type='text' required=\"required\"/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+4
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>重置密码</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='输入新密码' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    //prev+3
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>再次输入</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <input placeholder='再次输入新密码以完成重置' type='text'/>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <!--商家账号手机号输入结束-->\n" +
                    "                            <!--选择账号启用状态-->\n" +
                    //prev+2
                    "                            <hr class='hr-normal' />\n" +
                    //prev+1
                    "                            <div class='control-group'>\n" +
                    "                                <label class='control-label'>选择账号启用状态</label>\n" +
                    "                                <div class='controls'>\n" +
                    "                                    <div class=\"checkbox\">\n" +
                    "                                        <label>\n" +
                    "                                            <input id='isOn' type=\"checkbox\">启用\n" +
                    "                                        </label>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    // parent
                    "                            <!--选择子账号启用状态结束-->\n" +
                    "                            <div class='form-actions' style=\"text-align: right\">\n" +
                    "                                <!--点击保存后应该还要弹出信息框提示保存成功-->\n" +
                    //onclick='accountManagement.updateInfo(info)'
                    "                                <button class='btn' onclick='AccMgr.updateInfo(this)' >\n" +
                    "                                    <i class='icon-save''></i>\n" +
                    "                                    确认修改\n" +
                    "                                </button>\n" +
                    "                                <!--<button class='btn' type='submit'>取消</button>-->\n" +
                    "                            </div>\n" +
                    "                            </form>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
            }
            else {
                alert("无法识别数据源 : "+result.data[i].macid);
            }
        }
    },

    //更新信息
    updateInfo:function(btn) {
        //获取填写信息
        var phoneNumberText = $(btn).parents().prev().prev().prev().prev().prev().children().eq(1).children().eq(0).val();
        var pwdText = $(btn).parents().prev().prev().prev().prev().children().eq(1).children().eq(0).val();
        var pwdTextAgain = $(btn).parents().prev().prev().prev().children().eq(1).children().eq(0).val();

        // 判断用户类型
        var isQiantai = $(btn).parents().prev().prev().prev().prev().prev().prev().prev().children().eq(1).children().eq(0).
        children().eq(0).attr("checked");
        var isKehujingli = $(btn).parents().prev().prev().prev().prev().prev().prev().prev().children().eq(1).children().eq(1).
        children().eq(0).attr("checked");
        var isBumenjingli = $(btn).parents().prev().prev().prev().prev().prev().prev().prev().children().eq(1).children().eq(2).
        children().eq(0).attr("checked")
        var userTypeText = "";

        if(isQiantai == "checked"){
            userTypeText = "qiantai";
        }else  if (isKehujingli == "checked"){
            userTypeText = "kehujingli";
        } else{
            userTypeText = "bumenjingli";
        }

        //获取启用状态
        var isOn = $(btn).parents().prev().children().eq(1).children().eq(0).children().eq(0).children().eq(0).attr("checked");

        alert("修改内容为: [账号]"+phoneNumberText+"[密码]"+pwdText+"[再次输入密码]"+pwdTextAgain+"[账户类型]"+userTypeText+"[启用状态]"+isOn);
    },

    //添加子账号
    addAccount:function () {
        var isQiantai = $('#addUserType').children().eq(0).children().eq(0).attr("checked");
        var isKehujingli = $('#addUserType').children().eq(1).children().eq(0).attr("checked");
        var isBumenjingli = $('#addUserType').children().eq(2).children().eq(0).attr("checked");

        var userTypeText = "";

        if (isQiantai == "checked") {
            userTypeText = 12;
        } else if (isKehujingli == "checked") {
            userTypeText = 13;
        } else {
            userTypeText = 4;
        }

        var phoneNumberText = $('#addPhoneNumber').val();

        alert("添加内容为:[账号]" + phoneNumberText + "[用户类型]" + userTypeText);

        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/merchantAccManage/addAffiliateAccount',
            data : {
                merid : 2,
                macacc : phoneNumberText,
                //初始密码123456
                macpasswd : "123456",
                macacctype : userTypeText,
                //默认开启
                macenable : 1
            },
            dataType: 'json',
            success : function (result) {
                if(result.code == 0){
                    alert('子账号申请成功');
                    InitPage.init();
                }else{
                    alert('子账号申请失败，后台异常');
                }
            },
            error : function () {
                alert('子账号申请失败，服务器异常')
            }

        })
    },
};

//入盟申请
var AllianceMgr = {
    //只有申请加盟：shopAdminAlliance.html
};
//信息维护
var infoMgr = {
    //商家信息维护：shopAdminShowInfo.html
    //产品信息维护：shopAdminShowInfoProduct.html
        //产品信息查询接口（根据商家编号/产品编号）？
        //产品信息展示接口？
        //产品信息删除接口？
};
//积分管理
var pointsMgr = {
    //shopAdminPointsMgr.html（补充按钮：全部提交）
        //查询接口
        //提交接口
};

//配置管理
var settingMgr = {
    //缺失页面
};