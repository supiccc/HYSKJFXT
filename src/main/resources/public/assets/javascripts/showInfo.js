$(function () {
    console.log("王德发："+$('.file-input-wrapper').attr("class"));

    $('.file-input-wrapper').remove();
    $('.filePicker').append(
        "<input id=\"fileImage\" name=\"fileImage\" type=\"file\" multiple=\"\" accept=\"image/jpeg,image/x-png\" style=\"left: 3.67188px; top: 1px;\">"
    );
    // $('.filePicker').attr("top","1");
    // alert("这个警告框一定能出来");
});

var InitPage = {

};

var showInfoMgr = {

  getBasicInfo:function () {
      var banks = $('.all').sibling().children();
      $('.all>input').click(function () {
          var flag = $(this).prop('checked');
          banks.prop('checked', flag);
      });
      banks.click(function () {
          // 如果有1个没选中，全选按钮不选中
          var num = 0;
          banks.each(function () {
              if($(this).prop('checked')){
                  num++;
              }
          })
          if(num == banks.length){
              $('.all>input').prop('checked',true);
          }else{
              $('.all>input').prop('checked',false);
          }
      })
  }
};