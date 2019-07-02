var id;
var index;     //富文本对象的id
var layedit;   //layui调用富文本的对象
layui.use('layedit', function(){
    layedit = layui.layedit;
    index=layedit.build('demo'); //建立编辑器
});
$(function () {
    if(id){
        return;
    }
    id=setTimeout(function () {
        // alert($("#showJuit").html())
        //将请假内容显示在富文本编辑器中
        layedit.setContent(index,$("#showJuit").html());
    },100);
    $("#Preservation").on("click",function () {
        var $leaveId=$("#leaveId").val();           //请假条
        var $Title=$("#leaveTitle").val();       //获取到请假表题
        var $pressing=$("#pressing").val();      //请假紧急程度!
        var $LeaveNumber=$("#LeaveNumber").val();   //请假天数
        var $Type=$("#ltype").val();                //请假类型
        var $createDate=$("#date1").val();          //请假起始时间
        var $sendDate=$("#date2").val();            //请假结束时间
        var demo=layedit.getContent(index);         //获取到请假原因
        console.log("请假原因:"+demo);
        console.log("请假天数"+$LeaveNumber)
        $.ajax({
            url:path+"/leave/update.do",
            type:"post",
            data:JSON.stringify({
                "leaveProcessing":$pressing,
                "leaveTitle":$Title,
                "leaveType":$Type,
                "leaveTime":$LeaveNumber,
                "leaveStarttime":$createDate,
                "leaveSendtime":$sendDate,
                "leaveReason":demo,
                "leaveId":$leaveId,
            }),
            contentType:"application/json;charset=utf-8",
            dataType:'json',
            success:function (e) {
                console.log(e);
                if(e.code==0){
                    layer.msg("修改成功！")
                }else {
                    layer.msg(e.msg);
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    })
})