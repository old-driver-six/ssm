$(function () {
    function checkWork(){
        layui.use('table', function() {
            var table = layui.table;
            //第一个实例
            // 因为是js模拟的数据, 所以分页,指定每页记录数功能暂无法体现 ,待换成servlet即可
            table.render({
                elem: '#demo'
                , limit: 2
                , limits: [2, 4, 6]
                , height: 312
                , url: path + '/workLog/selLimit.do' //数据接口 , 这里我用js模拟了一个要请求的数据, 将来要用servlet来响应
                , method: "get"
                , where: {
                    "sid": $.cookie('uId'),
                    "data1":$("#date1").val(),
                    "data2":$("#date2").val(),
                    "type":$("#interest").val()
                }
                , page: true //开启分页
                , cols: [[ //表头 ,注意：field的值必须和json中的数据的键名保持一致
                    //title是用来显示的字段名
                    //员工姓名；手机号；邮箱；身份证号码；职位工资；入职时间；性别；备注
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'worklogId', title: '日志id', sort: true, fixed: 'left'}
                    , {field: 'worklogName', title: '日志名称'}
                    , {field: 'worklogCreatedate', title: '创建时间'}
                    , {field: 'worklogContent', title: '日志内容'}
                    , {field: 'worklogUpdatetime', title: '日志修改时间'}
                    ,{field:'toolbar', title: '操作',align:'center',toolbar: '#barDemo'}
                ]]
                , parseData: function (res) {
                    console.log(res)
                    return {
                        "code": res.code,//解析接口状态
                        "msg": res.msg,//解析提示文件
                        "count": res.count,//解析数据长度
                        "data": res.data//解析数据列表
                    }
                }
            });

        });
    }
    checkWork();        //页面加载完毕后自己调用!
    $("#selWork").on('click',checkWork);
})