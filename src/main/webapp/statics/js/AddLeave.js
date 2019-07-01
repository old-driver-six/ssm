var index=null;     //富文本对象的id
var layedit=null;   //layui调用富文本的对象
layui.use('layedit', function(){
    layedit = layui.layedit;
    index=layedit.build('demo'); //建立编辑器

});
$(function () {
    var $leaveTitle=$("#leaveTitle").val();     //获取到请假标题
    var $pressing=$("#pressing").val();         //获取到请假紧急程度!
    var
});
