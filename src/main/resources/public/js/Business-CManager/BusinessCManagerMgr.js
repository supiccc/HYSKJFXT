$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        Basic.initMyMenu();
        if (window.location.href.indexOf("customerManagerMemberInfoAdd") > 0) {
            $("#regisCustomerBtn").on('click', function () {
                // alert("点击注册");
                customerMgr.regisCustomer();
            })
        } else if (window.location.href.indexOf("customerManagerRecharge") > 0){
            $("#recharge").on('click', function () {
                rechargeMgr.recharge();
            })
        } else if (window.location.href.indexOf("customerManagerCard") > 0){
            $("#addCard").on('click', function () {
                customerMgr.regisCustomerCard();
            });
        } else if(window.location.href.indexOf("customerManagerMemberInfoChange") > 0) {
            alert("此功能尚未开放");
        } else if (window.location.href.indexOf("customerManagerMemberInfoChangeHistory") > 0) {
            alert("此功能尚未开放");
        } else if (window.location.href.indexOf("customerManagerConsume") > 0) {
            $("#zhuzhiBtn").on('click', function () {
                checkIn.zhuzhiRegis();
            });
            $("#xianjinBtn").on('click', function () {
                checkIn.xianjinRegis();
            });
            $("#pointBtn").on('click', function () {
                checkIn.pointRegis();
            });
        } else if (window.location.href.indexOf("customerManagerRechargeHistory") > 0) {
            alert("此功能尚未开放");
        }
    },
    action:function () {
        var username = Basic.getPassingStr("username");
        var role = Basic.getPassingStr("role");
        //导航栏
            //会员管理
            $('#memberMgrBtn').on('click',function () {
                window.location.href = "./customerManagerMemberInfoAdd.html?username="+username+"&role="+role+"";
            });
            //消费充值管理
            $('#checkInBtn').on('click',function () {
                window.location.href = "./customerManagerConsume.html?username="+username+"&role="+role+"";
            });

        //侧边栏-会员管理
            //会员信息登记
            $('#regisMemBtn').on('click',function () {
                window.location.href = "./customerManagerMemberInfoAdd.html?username="+username+"&role="+role+"";
            });
            //会员信息变更
            $('#updateMemInfoBtn').on('click',function () {
                //导航栏，侧边栏以此页面为准
                window.location.href = "./customerManagerMemberInfoChange.html?username="+username+"&role="+role+"";
            });
            //变更历史查询
            $('#updateHistoryBtn').on('click',function () {
                window.location.href = "./customerManagerMemberInfoChangeHistory.html?username="+username+"&role="+role+"";
            });
            // 会员卡发放
            $('#regisMemCardBtn').on('click',function () {
                window.location.href = "./customerManagerCard.html?username="+username+"&role="+role+"";
            });
            // 会员卡补卡-未开放
            $('#changeMemCardBtn').on('click',function () {
                alert("补卡功能正在搭建中，稍候一下哦亲");
            });
            //会员卡补卡历史查询
            $('#changeHistoryBtn').on('click',function () {
                alert("补卡功能正在搭建中，稍候一下哦亲");
            });
        //侧边栏-消费充值管理
            //消费登记
            $('#regisConsumeBtn').on('click',function () {
                //以此页面为准
                window.location.href = "./customerManagerConsume.html?username="+username+"&role="+role+"";
            });
            //充值
            $('#rechargeBtn').on('click',function () {
                window.location.href = "./customerManagerRecharge.html?username="+username+"&role="+role+"";
            });
            //充值记录查询
            $('#rechargeHistoryBtn').on('click',function () {
                window.location.href = "./customerManagerRechargeHistory.html?username="+username+"&role="+role+"";
            });
            //会员积分结算
            $('#memPointDealBtn').on('click',function () {
                window.location.href = "./customerManagerUnsettledPoint.html?username="+username+"&role="+role+"";
            });
            //会员积分统计
            $('#memPointcountBtn').on('click',function () {
                alert("图表功能尚未开放，敬请期待啊亲");
            });

        //下拉菜单
            //积分管理
            $('#pointsMgrBtn').on('click',function () {
                window.location.href = "./customerManagerAllPoint.html?username="+username+"&role="+role+"";
            });
            //修改密码
            $('#updatePwdBtn').on('click',function () {
                window.location.href = "../Login/changePassword.html?username="+username+"&role="+role+"";
            });
            //意见反馈
            $('#adviceBtn').on('click',function () {
                    alert("还懒得补");
            });
            //注销
            $('#cancelBtn').on('click',function () {
                window.location.href = "../Member/indexReal.html";
            });

        //其他
        // $('#regisConsumeBtn').on('click',function(){
        //    customerMgr.regisCustomer();
        // });
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

        $('#updatePwdBtn').attr("href","../Login/changePassword.html");

        $('#adviceBtn').on('click', function () {
            Basic.showFeedback();
        });

        $('#cancelBtn').attr("href", "../Member/indexReal.html");
    },

};

//会员管理
var customerMgr = {
    //我的会员-登记会员信息
    regisCustomer:function () {
        // alert("注册会员");
        var memcer = $('#memcer').find("option:selected").text();
        var memcerid = $('#memcerid').val();
        var memname = $('#memname').val();

        var memsex = $('#memsex').find("option:selected").text();
        var membirth = $('#membirth').val();
        var memphone = $('#memphone').val();
        var mememail = $('#mememail').val();
        var memadress = $('#memadress').val();

        var pwd = $('#pwd').val();
        var pwdAgain = $('#pwdAgain').val();

        var shopPwd = "111111";
        if(pwd != pwdAgain){
            alert("密码前后两次输入不一致");
        }else if(memcer == null || memcerid == null || memname == null){
            alert("请输入必填信息");
        }else{
            $.ajax({
                type : "POST",
                url : "http://localhost:8080/memberAcc/addAcc",
                data : {
                    memcer : memcer,
                    memcerid : memcerid,
                    memname : memname,
                    memsex : memsex,
                    // membirth : membirth,
                    memphone : memphone,
                    mememail : mememail,
                    memadress : memadress,
                    pwd : pwd,
                    shoppwd : shopPwd,
                    membirth: membirth,
                    memcredit: 0
                },
                dataType : "json",
                success : function(res){
                    if(res.code === 0){
                        alert("注册成功");
                        window.location.reload();
                    }else{
                        alert("请检查信息格式");
                    }
                },
                error : function () {
                    alert("服务器故障，注册失败");
                },
            });
        }
    },

    //我的会员-会员信息变更：缺页面，列表有啥内容？

    //2018.8.18 Hwalv 补充会员信息变更页面 customerManagerMemberInfoChange
    //侧边栏中有会员信息变更
    //列表中应该包含的信息有，即从后台获得的数据：
    //证件类型、证件号、会员名、性别、生日、电话、邮箱、地址
    //因为会员号不可修改，所以列表中不应该有会员号
    //传给后台的数据为主编号和修改的内容

    //我的会员-变更历史查询：缺页面，列表有啥内容？

    //2018.8.18 Hwalv 变更历史查询

    //会员卡发放
    regisCustomerCard:function () {
      var memphone = $('#memphone').val();
      $.ajax({
          type : "POST",
          url : "/memberAcc/addMemCard",
          data : {
              memphone : memphone,
              mcenable : true
          },
          dataType : "json",
          success : function (res) {
              if(res.code == 0){
                  alert("注册成功，会员卡号为："+res.data);
              }else{
                  alert("后台故障，注册失败");
              }
          },
          error : function () {
              alert("服务器故障，注册失败");
          }
      });
    },

    //会员卡补卡：缺页面，表单有啥内容？

    //会员卡补卡历史：缺页面，列表有啥内容？
};

// 消费管理-消费登记
var checkIn = {

    //储值：customerManagerConsume.html
    zhuzhiRegis:function () {
        var mcid = $('#zhuzhiCardNum').val();
        var money = $('#zhuzhiMoney').val();//float不知道可不可以
        var pwd = $('#zhuzhiPass').val();
        // var macid = Basic.getPassingStr("username");

        $.ajax({
           type : "POST",
           url : "/memberConsumption/storeConsumption",
           data : {
               mcid: mcid,
               money: money,
               pwd: pwd
           },
            success : function(res){
                if(res.code === 0){
                    alert("消费成功");
                    window.location.reload();
                } else if (res.code === -2) {
                    alert("会员卡号错误");
                } else if (res.code === -3) {
                    alert("消费密码错误");
                } else if (res.code == -5) {
                    alert("储值不足");
                } else {
                    alert("服务器未知错误");
                }
            },
            error : function () {
                alert("服务器繁忙");
            },
        });
    },
    //现金：customerManagerConsume.html
    xianjinRegis:function () {
        var mcid = $("#xianjinCardNum").val();
        var money = $('#xianjinRealMoney').val();//float不知道可不可以
        // var macid = Basic.getPassingStr("username");

        $.ajax({
            type : "POST",
            url : "/memberConsumption/cashConsumption",
            data : {
                mcid : mcid,
                money : money
            },
            success : function(res){
                if(res.code === 0){
                    alert("消费成功");
                    window.location.reload();
                } else if (res.code === -2) {
                    alert("会员卡号错误");
                } else {
                    alert("后台故障，登记失败");
                }
            },
            error : function () {
                alert("服务器故障，登记失败");
            },
        });
    },

    //积分：customerManagerConsume.html
    pointRegis:function () {
        var mcid = $('#CardNum').val();
        var money = $('#pointconsumeMoney').val();//float不知道可不可以
        var pwd = $('#consumePass').val();
        // var macid = Basic.getPassingStr("username");

        $.ajax({
            type : "POST",
            url : "/memberConsumption/creditConsumption",
            data : {
                mcid : mcid,
                money : money,
                pwd : pwd
            },
            success : function(res){
                if(res.code === 0){
                    alert("消费成功");
                    window.location.reload();
                } else if (res.code === -2){
                    alert("会员卡号错误");
                } else if (res.code === -3){
                    alert("消费密码错误");
                } else if(res.code === -4){
                    alert("积分不足");
                } else{
                    alert("未知错误");
                }
            },
            error : function () {
                alert("服务器繁忙，登记失败");
            }
        });
    }
};

// 消费管理-充值管理
var rechargeMgr = {
    //充值：customerManagerRecharge.html
    recharge: function () {
        $.ajax({
            type : "POST",
            url : "/memberAcc/recharge",
            data : {
                cardId : $("#CardNum").val(),
                money : $("#rechargeMoney").val()
            },
            datatype: "json",
            success: function (res) {
                if (res.code === 0) {
                    alert("充值成功");
                    window.location.reload();
                } else if (res.code === -2) {
                    alert("会员卡号错误");
                } else {
                    alert("服务器内部错误，充值失败");
                }
            },
            error: function () {
                alert("服务器繁忙");
            }
        })
    }
    //充值记录查询：缺页面，列表有啥内容？
}

var pointsMgr = {
    //积分管理
    //缺页面：与<Business-Admin>一样，基本照搬即可
}