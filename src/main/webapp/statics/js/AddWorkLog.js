var index=null;     //富文本对象的id
var layedit=null;   //layui调用富文本的对象
layui.use('layedit', function(){
    layedit = layui.layedit;
    index=layedit.build('demo'); //建立编辑器
});
$(function () {
    var sid=$.cookie('uId');
    $("#Preservation").on('click',function () {
        $.ajax({
            url:path+"/workLog/save.do",
            type:'post',
            data:{
                "worklogCreateid":sid,
                'worklogName':$("#worklogName").val(),
                'worklogContent':layedit.getContent(index)
            },
            dataType:'json',
            success:function (e) {
                console.log(e);
                layer.msg(e.msg);
            },
            error:function (e) {
                console.log("错误信息!"+e)
            }
        })
    })
})