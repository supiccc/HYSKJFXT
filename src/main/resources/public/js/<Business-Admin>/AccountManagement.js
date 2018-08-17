var qiantaiCount = 0;
var kehujingliCount = 0;
var bumenjingliCount = 0;


$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage={
    init:function () {
        $.ajax({
            type : 'POST',
            //现在是查询所有账号，迟些界面连起来后要记得该成查询相关的子账号
            url: "http://localhost:8080/merchantAccManage/queryAll",
            dataType: 'json',
            success: function (result) {
                if(result.code == 0){
                    // accountManagement.getAccountList(result);
                    accountManagement.initList(result);
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
        })

    },

    action:function () {
      // $('#addBtn').on('click',function () {
      //     //添加子账号的触发方法
      //     accountManagement.addAccount();
      // });
            //商家管理员
            //跳转《账户管理》
            $('#AccountMrgBtn').on('click',function () {
                window.location.href = "./shopAdminAccountManagement.html";
            });
            //跳转《展示信息》
            $('#InfoMrgBtn').on('click',function () {
                window.location.href = "./shopAdminShowInfo.html";
            });
            //跳转《同盟管理》
            $('#AllianceBtn').on('click',function () {
                window.location.href = "./shopAdminAlliance.html";
            });

            //我的
            //跳转《积分管理》
            $('#pointsMgrBtn').on('click',function () {
                window.location.href = "./";
            });
            //弹出《配置管理》
            $('#settingBtn').on('click',function () {

            });
            //修改密码
            $('#updatePwdBtn').on('click',function () {

            });
            //弹出《发送反馈》
            $('#adviceBtn').on('click',function () {

            });


            //跳转《所有站内消息》
            $('#InfoBtn').on('click',function () {

            });
    }
};

var accountManagement = {
    // getAccountList:function(result){
    //     $.ajax({
    //        type: "POST",
    //        url: "testJson/accountManagement.json",
    //        dataType: "json",
    //        success: function (result) {
    //            accountManagement.initList(result);
    //        }
    //     });
    // },

    initList:function(result){
        $('#content-wrapper').empty();
        qiantaiCount = 0;
        kehujingliCount = 0;
        bumenjingliCount = 0;
        $('#content-wrapper').append(
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
            "                    <button class='btn' id=\"addBtn\" onclick='accountManagement.addAccount()'>\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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
                $('#content-wrapper').append(
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
                    "                                <button class='btn' onclick='accountManagement.updateInfo(this)' >\n" +
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

    deleteAccount:function (abtn) {
        alert("别删俺");
        //删除json操作
        InitPage.init();
    }
};