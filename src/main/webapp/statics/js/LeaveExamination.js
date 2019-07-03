$(function () {
    //var sid=$.cookie('uId');
    var location = window.location.toString();
    var TableKay=location.split("?")[1];
    console.log(TableKay);
    if(TableKay){
        $.ajax({
            url:path+'/leave/getStfLeave.do',
            type:'post',
            data:{'lid':TableKay},
            dataType:'json',
            success:function (e) {
                if(e.code==0){
                    //解析数据给下面的输入框赋值!
                    console.log(e.data);
                    creatFrom(e.data);
                    //数据解析完成之后将隐藏的按钮启用
                }else {
                    layer.msg(e.msg);
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    }
    function creatFrom(data) {
        $('#leaveName').val(data.staffName);
        $('#leaveDep').val(data.depName);
        $('#leaveTitle').val(data.dataInfo[0].leaveTitle);
        $('#pressing').get(0).selectedIndex=data.dataInfo[0].leaveProcessing;
        $('#LeaveNumber').val(data.dataInfo[0].leaveTime);
        $('#ltype').get(0).selectedIndex=data.dataInfo[0].leaveType;
        $('#date1').val(data.dataInfo[0].leaveStarttime);
        $('#date2').val(data.dataInfo[0].leaveSendtime);
        $('#leaveReason').html(data.dataInfo[0].leaveReason);
        $('#lid').data('lid',data.dataInfo[0].leaveId);
        $('#leaveName').data('uid',data.dataInfo[0].leaveStaffId);
        if(data.dataInfo[0].leaveState==1){
            $('#leaveState').val("审核不通过!");
        }
        if(data.dataInfo[0].leaveState==0){
            $('#leaveState').val("已审核通过!")
        }
        if(!data.dataInfo[0].leaveState){
            $('#leaveState').val('未审核!')
        }

        $('#leavePow').val(data.positionName);
    }

    /**
     * 动态绑定审核事件
     */
    $('#Preservation').on('click',function () {
        layui.use('layer', function(){
            var layer = layui.layer;
            var index=layer.open({
                type: 2
                ,area:['600px','400px']
                ,content: "Opinion.html"
                ,shade: 0.6
                ,moveType: 1 //拖拽模式，0或者1
                ,title: '领导审核意见' //不显示标题栏
                ,offset:['0px','400px']
                ,closeBtn: 1
                ,anim: 1
                ,id: '12' //设定一个id，防止重复弹出
                ,btnAlign: 'c'
                ,success:function (layero, index) {
                    var body=layer.getChildFrame('body',index);
                    body.find('#from').html($('#LeaveNumber').val())
                    body.find('#from1').html($('#lid').data('lid'));
                    body.find('#from3').html($('#leaveName').data('uid'));
                }
            });
        });
    })

    /**
     * 动态绑定领导意见查询事件
     */
    $('#sel').on('click',function () {
        layui.use('layer', function(){
            var layer = layui.layer;
            var index=layer.open({
                type: 2
                ,area:['600px','400px']
                ,content: "ShowOpinion.html"
                ,shade: 0.6
                ,moveType: 1 //拖拽模式，0或者1
                ,title: '领导意见' //不显示标题栏
                ,offset:['0px','400px']
                ,closeBtn: 1
                ,anim: 1
                ,id: '12' //设定一个id，防止重复弹出
                ,btnAlign: 'c'
                ,success:function (layero, index) {
                    var body=layer.getChildFrame('body',index);
                    body.find('#from').html($('#lid').data('lid'));
                }
            });
        });
    })
})