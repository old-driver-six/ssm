$(function () {
    $.ajax({
        url:path+'/leave/getLeaveAvice.do',
        type:'post',
        data:{'lid':$("#from").html()},
        /* data:{'lid':'1e3c660b461f4c2282ae2d75b9e05402'},*/
        dataType:'json',
        success:function (e) {
            console.log(e)
            if(e.code==0){
                createFrom(e.data);
            }
            if(e.code==-1){
                alert(e.msg);
            }
        },
        error:function (e) {
            console.log(e)
        }
    })
    function createFrom(date) {
        console.log();
        var $divs= $('.showAndHind');
        if(date.advicegroupstate){
            $($divs[0]).addClass('show');
        }
        if(date.advicepartstate){
            $($divs[1]).addClass('show');
        }
        if(date.advicesumstate){
            $($divs[2]).addClass('show');
        }
        $('#pressing').get(0).selectedIndex=date.advicegroupstate;
        $('#leaveReason').html(date.advicegroup);
        $('#pressing1').get(0).selectedIndex=date.advicepartstate;
        $('#leaveReason1').html(date.advicepart);
        $('#pressing2').get(0).selectedIndex=date.advicesumstate;
        $('#leaveReason2').html(date.advicesum);

    }
})