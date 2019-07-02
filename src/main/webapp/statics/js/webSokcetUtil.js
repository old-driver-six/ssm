var websocket = null;
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/websocket/socketServer.do");
    console.log("正在连接!")
}
else if ('MozWebSocket' in window) {
    websocket = new MozWebSocket("ws://localhost:8080/websocket/socketServer.do");
}
else {
    websocket = new SockJS("http://localhost:8080/sockjs/socketServer.do");
}
websocket.onopen = onOpen;
websocket.onmessage = onMessage;
websocket.onerror = onError;
websocket.onclose = onClose;

function onOpen(openEvt) {
    console.log("连接成功!")
}

function onMessage(evt) {
    //alert(evt.data);        //接收到消息触发!
    msgTO(evt.data);
}
function onError() {}
function onClose() {}

/*function doSend() {
    if (websocket.readyState == websocket.OPEN) {
        var msg = document.getElementById("inputMsg").value;
        websocket.send(msg);//调用后台handleTextMessage方法
        alert("发送成功!");
    } else {
        alert("连接失败!");
    }
}*/


window.close=function()
    {
        websocket.onclose();
    }

/***
 * 处理消息的函数
 * @param data
 */
function msgTO(data){
    alert("你有一个新的请假审核请注意查收!");
    var _li='<li class="menu-current">'+
        '<a href="html/personnel/LeaveExamination.html?'+data+'" class="title-send">'+
        '<i class="iconfostatics/htmlnt">&#xe6a7;</i>'+
        '<cite>请假审核</cite>'+
        '</a>'+
        '</li >';
  /*  $(_li).data('TableKey',data);*/
    $('#Toexamine').append($(_li));
    layer.use('element',function () {
        layui.element.init();
    });

}


