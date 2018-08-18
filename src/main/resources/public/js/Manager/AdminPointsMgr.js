$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        PointsMgr.initList();
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

        $('#rejectBtn').on('click',function () {
                PointsMgr.reject();
        });
        $('#passBtn').on('click',function () {
                PointsMgr.pass();
        })
    }
};

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