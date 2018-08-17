$(function () {
    InitPage.init();
    InitPage.action();
});

var InitPage = {
    init:function () {
        ShopInfoMgr.initList();
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
    },
};

var ShopInfoMgr = {
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

    showInfo:function () {

    }
}