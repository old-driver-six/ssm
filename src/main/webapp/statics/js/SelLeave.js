$(function () {
    var id;      //定时器延时加载分页的代码
    var sid=$.cookie('uId');     //获取用户id
    var cot;     //存放页面显示总数的变量
    var pageSize=10;  //每页显示多少条
    var pageThis=1;    //当前是第几页
    function show(pageSize,pageThis){
        $.ajax({
            url:path+'/leave/showLeave.do',
            type:'post',
            data:{"sid":sid,"pageSize":pageSize,"pageThis":pageThis},
            //contentType:"application/json;charset=utf-8",
            dataType:'json',
            success:function (e) {
                if(e.code==0){
                    $("#show").empty();
                    cot=e.count;
                    console.log(e.data);
                    createShowLeave(e.data);
                }else{
                    layer.msg("暂无数据,快去添加吧!")
                }
            }
            ,error:function (e) {
                console.log(e);
            }
        });
    }
    show(pageSize,pageThis);
    /**
     * 分页的功能回调
     * */
    function satrt(){
        if(id){
            return;
        }
        id=setTimeout(function () {
            layui.use('laypage', function(){
                var laypage = layui.laypage;
                laypage.render({
                    elem: 'test1'
                    ,count: cot //数据总数，从服务端得到
                    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                    ,jump: function(obj, first){
                        //obj包含了当前分页的所有参数，比如：
                        pageThis=obj.curr; //得到当前页，以便向服务端请求对应页的数据。
                        pageSize=obj.limit; //得到每页显示的条数
                        //首次不执行
                        if(!first){
                            show(pageSize,pageThis);
                        }
                    }
                });
            });
        },200)
    }
    satrt();     //调用函数
    /**
     * 遍历json取出数据
     * @param LeaveData
     */
    function createShowLeave(LeaveData){
        for(var i=0;i<LeaveData.length;i++){
            var _sname=LeaveData[i].staffName;      //获取姓名
            var _depNmae=LeaveData[i].depName;      //部门
            var _positionName=LeaveData[i].positionName;
            var _time=LeaveData[i].leaveTime;
            var _lstate=LeaveData[i].leaveState;
            var _lceateTime=LeaveData[i].leaveCeatetime;
            var _leaveId=LeaveData[i].leaveId;
            crateLeave(_sname,_depNmae,_positionName,_time,_lstate,_lceateTime,_leaveId);
        }
    }

    /**
     * 创建tr显示数据
     * @param sname  员工姓名
     * @param dname  所属部门
     * @param pname  职务
     * @param time   请假时间
     * @param lstate 请假状态
     * @param lceateTime 创建时间
     * @param leaveId    请假条
     * @param leaveType   请假类型
     */
    function crateLeave(sname,dname,pname,time,lstate,lceateTime,leaveId) {
        if(lstate==0){
            lstate='审核通过'
        }else{
            lstate='未审核'
        }
        var lceTime=new Date(lceateTime);      //格式时间!
        lceateTime=lceTime.getFullYear()+" 年 "+(lceTime.getMonth()+1)+" 月 "+lceTime.getDate()+" 日";
        var _tr='<tr>'+
            '<td>'+sname+'</td>'+
            '<td>'+pname+'</td>'+
            '<td>'+dname+'</td>'+
            '<td>'+lstate+'</td>'+
            '<td>'+time+'</td>'+
            '<td>'+lceateTime+'</td>'+
            '</tr>';
        var $tr=$(_tr);
        //给tr上面绑定上请假id数据
        $tr.data("leaveId",leaveId);
        $("#show").append($tr);       //将数据挂在树上
    }
    /*点击tr显示请假详细信息!事件*/
    $("#show").on("click","tr",showLeaveInfo);
    function showLeaveInfo() {
        var leaveId= $(this).data("leaveId");
        layui.use('layer', function(){
            var layer = layui.layer;
            var index=layer.open({
                type: 2
                ,area:['800px','700px']
                ,content: "showleave.html"
                ,shade: 0.6
                ,moveType: 1 //拖拽模式，0或者1
                ,title: '查看请假详情！' //不显示标题栏
                ,offset:['0px','400px']
                ,closeBtn: 1
                ,anim: 1
                ,id: '12' //设定一个id，防止重复弹出
                ,btnAlign: 'c'
                ,success:function (layero, index) {
                    var body=layer.getChildFrame('body',index);
                    LeaveInfo(body,leaveId);
                }
            });
        });

    }

    /**
     * 查询请假条信息
     * @constructor
     */
    function LeaveInfo (body,leaveId) {
        $.ajax({
            url:path+"/leave/getLeave.do",
            type:'post',
            data:{"leaveId":leaveId},
            dataType:'json',
            sync:true,
            success:function (e) {
                console.log(e);
                if (e.code==200){
                    body.find("#leaveTitle").val(e.data.leaveTitle);
                    body.find("#leaveId").val(e.data.leaveId);
                    body.find("#pressing").get(0).selectedIndex=e.data.leaveProcessing;
                    body.find("#LeaveNumber").val(e.data.leaveTime);
                    body.find("#ltype").get(0).selectedIndex=e.data.leaveType;
                    body.find("#showJuit").html(e.data.leaveReason);
                    body.find("#date1").val(e.data.leaveStarttime);
                    body.find("#date2").val(e.data.leaveSendtime);
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    }
    /*查询按钮事件*/
    $("#SelClick").on('click',SelClick)
    function SelClick() {
        $.ajax({
            url:path+'/leave/selLeaveJuit.do',
            type:'post',
            data:{
                "sid":sid,
                "pageSize":pageSize,
                "pageThis":pageThis,
                "getLeave":JSON.stringify({"createDate":$("#date1").val(),
                    "sendDate":$("#date2").val(),
                    "leaveTime":$("#leaveNumber").val(),
                    "sendTime":$("#leaveNumber2").val()})

            },
            dataType:'json',
            success:function (e) {
                if(e.code==0){
                    $("#show").empty();
                    cot=e.count;
                    console.log(e.data);
                    createShowLeave(e.data);
                }else {
                    alert(e.msg);
                }
            },
            error:function (e) {
                console.log(e);
            }
        })
    }

    /**
     * 显示请假详情函数!
     */
    function examine() {
        var u=window.location;//获取地址栏
        var s=u.toString();
        s=s.split("?")[1];
        console.log(s.split("&"));
    }
    examine();

})