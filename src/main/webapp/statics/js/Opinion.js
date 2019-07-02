var index=null;     //富文本对象的id
var layedit=null;   //layui调用富文本的对象
layui.use('layedit', function(){
    layedit = layui.layedit;
    index=layedit.build('demo'); //建立编辑器
});
$(function () {
    $('#Preservation').on('click',function () {
        $.ajax({
            url:path+'/leave/saveAdvice.do',
            type:'post',
            data:{
                'sid':$.cookie('uId'),
                'opinion':layedit.getContent(index),
                'state':$('#pressing').val(),
                'leaveTime':$('#from').html(),
                'lid':$('#from1').html(),
                'uid':$('#from3').html()
            },
            dataType:'json',
            success:function (e) {
                console.log(e);
                if(e.code==200){
                    layer.msg(e.msg);
                    window.location.href=path+'/index.html';
                }else {
                    layer.msg("系统故障请稍后重试");
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    })
})