$(function () {
    InitPage.Init();
    InitPage.action();
    // alert("为什么进不来!?!?");
});

var InitPage = {
  Init:function () {

  },
  action:function () {
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

      //侧边栏
      //商家资料维护
      $('#showInfoMgrBtn').on('click',function () {
          window.location.href = "./shopAdminShowInfo.html"
      });
      //产品维护
      $('#productInfoMgrBtn').on('click',function () {
          window.location.href = "./shopAdminShowInfoProduct.html";
      });

      //跳转《所有站内消息》
      $('#InfoBtn').on('click',function () {

      });
  },
};

var shopInfoMgr = {

};