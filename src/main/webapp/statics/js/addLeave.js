var index=null;     //富文本对象的id
var layedit=null;   //layui调用富文本的对象
layui.use('layedit', function(){
    layedit = layui.layedit;
    index=layedit.build('demo'); //建立编辑器
});
$(function () {
    $("#Preservation").on("click",function () {
        var $Title=$("#leaveTitle").val();       //获取到请假表题
        var $pressing=$("#pressing").val();      //请假紧急程度!
        var $LeaveNumber=$("#LeaveNumber").val();   //请假天数
        var $Type=$("#ltype").val();                //请假类型
        var $createDate=$("#date1").val();          //请假起始时间
        var $sendDate=$("#date2").val();            //请假结束时间
        var demo=layedit.getContent(index);         //获取到请假原因
        $.ajax({
            url:path+"/leave/saveLeave.do",
            type:"post",
            data:JSON.stringify({
                "leaveProcessing":$pressing,
                "leaveTitle":$Title,
                "leaveType":$Type,
                "leaveTime":$LeaveNumber,
                "leaveStarttime":$createDate,
                "leaveSendtime":$sendDate,
                "leaveReason":demo,
                'leaveStaffId':$.cookie('uId'),
            }),
            contentType:"application/json;charset=utf-8",
            dataType:'json',
            success:function (e) {
                if(e.code==200){
                    layer.msg(e.msg);
                }else{
                    layer.msg("系统故障!请稍后重试")
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    })
})