//删除
function shanchu (obj){
    $('.delcon').fadeIn()
//          //确定
    $('.delcer').click(function(event){
        $(obj).parent().parent().parent().remove();
        $('.delcon').fadeOut()
    })
    //取消
    $('.delcan').click(function(event){
        $('.delcon').fadeOut()
    })
}