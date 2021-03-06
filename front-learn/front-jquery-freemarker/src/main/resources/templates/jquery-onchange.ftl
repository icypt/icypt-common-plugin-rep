<!DOCTYPE html>
<html lang="en">
<head>
<#include "common/header.ftl">
    <script>
        /**
         * 默认图片地址
         * @param defaultUrl
         */
        function defaultImgLoad(defaultUrl){
            //重写onerror防止递归调用
            var img=event.srcElement;
            img.src=defaultUrl;
            img.onerror=null;
        }
    </script>
</head>
<body>
<div class="container">
    <h4>Jquery下拉选联动</h4>
    <form class="form-horizontal" action="commit" method="post">
        <div class="row">
            <div class="col-xs-4">
                <div class="form-group">
                    <label class="col-xs-4 control-label">用户类型：</label>
                    <div class="col-xs-8">
                        <select class="form-control" id="userType" name="userType">
                            <option value="">请选择</option>
                            <option value="1">平台用户</option>
                            <option value="2">机构用户</option>
                            <option value="3">商户用户</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label class="col-xs-4 control-label">所属机构：</label>
                    <div class="col-xs-8">
                        <select class="form-control" id="orgCode" name="orgCode">
                            <option value="">请选择</option>
                            <option value="001">机构一</option>
                            <option value="002">机构二</option>
                            <option value="003">机构三</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label class="col-xs-4 control-label">所属商户：</label>
                    <div class="col-xs-8" id="selecatMerch">
                        <select class="form-control" id="merchNo" name="merchNo">
                            <option value="">请选择</option>
                            <option value="001">商户一</option>
                            <option value="002">商户二</option>
                            <option value="003">商户三</option>
                        </select>
                    </div>
                    <div class="col-xs-8" id="inputMerch">
                       <input type="hidden" class="form-control" name="MerchNo" id="inputMerchNo">
                       <input type="text" class="form-control" name="inputMerchName" id="inputMerchName" value="" readonly>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <button class="btn-primary btn-sm" type="submit"> 提交</button>
            </div>
        </div>
    </form>
    <h4>图片是否加载成功判断</h4>
    <img src="/1/learnStyle/img/1.png" id="imgTest" onerror="defaultImgLoad('/1/learnStyle/img/1.png')">
</div>


<#include "common/footer.ftl">
<script>
    $(function () {
        $("#inputMerch").hide();
        $("#inputMerchNo").attr("disabled","disabled");
        $("#inputMerchName").attr("disabled","disabled");
       $("#userType").change(function () {
          var userType = $("#userType").val();
          if(userType == "1") {
              $("#orgCode").val("001");
              $("#orgCode").attr("disabled","disabled");
              if(!$("#selecatMerch").is(":hidden")) {
                  $("#selecatMerch").hide();
                  $("#merchNo").attr("disabled","disabled");
              }
              if($("#inputMerch").is(":hidden")) {
                  $("#inputMerch").show();
                  if($("#inputMerchNo").attr("disabled")) {
                      $("#inputMerchName").val("--");
                      $("#inputMerchNo").removeAttr("disabled");
                      $("#inputMerchName").removeAttr("disabled");
                  }
              }
          } else {
              $("#orgCode").val("");
              if($("#orgCode").attr("disabled")) {
                  $("#orgCode").removeAttr("disabled");
              }
              if($("#selecatMerch").is(":hidden")) {
                  $("#selecatMerch").show();
                  $("#merchNo").removeAttr("disabled");
                  $("#merchNo").val("");
              }
              if(!$("#inputMerch").is(":hidden")) {
                  $("#inputMerch").hide();
                  if(!$("#inputMerchNo").attr("disabled")) {
                      $("#inputMerchNo").attr("disabled","disabled");
                      $("#inputMerchName").attr("disabled","disabled");
                  }
              }
          }
       });
       $('#userType').val("1").trigger('change');
    });
</script>
</body>
</html>