// 定义一个匿名函数,直接运行
(function () {
  //1 点击菜单,展开子菜单项
  var mxnav = document.getElementsByClassName("mx-nav")[0];
  //得到两个元素数组,长度和下标一一对应:
  var mxmenutitle = mxnav.getElementsByClassName("mx-menu-title");
  var mxsubmenu = mxnav.getElementsByClassName("mx-submenu");
  //循环,判断是哪个菜单被点击
  for (var i = 0, len = mxmenutitle.length; i < len; i++) {
    //给每个mxmenu[i]绑定一个click事件
    mxmenutitle[i].addEventListener('click', (function (index) {
      return function () {
        for (var j = 0; j < len; j++) {
          // 菜单(i)的下标与子菜单(j)下标一样
          // 通过当前的点击的i判断子菜单是否已打开
          if (index == j) {
            //判断点击的这个子菜单是否已经打开
            if (mxsubmenu[index].style.display == "block") {
              //如果已经打开,则关闭
              mxsubmenu[index].style.display = "none";
            } else {
              //如果没有打开,则显示
              mxsubmenu[index].style.display = "block";
            }
          } else {
            //把其他的子菜单关闭
            //mxsubmenu[j].style.display = "none";
          }
        }
      }
    })(i), false);//把外循环的i传给匿名函数function (index)的index

    //这种写法也行,直接使用mxmenu[i]的onclick事件
    // mxmenutitle[i].onclick = (function (i) {//把i传给一个匿名函数
    //   return function() {
    //     for (var j = 0; j < len; j++) {
    //       // 菜单(i)的下标与子菜单(j)下标一样
    //       // 通过当前的点击的i判断子菜单是否已打开
    //       if(i == j){
    //         //判断点击的这个子菜单是否已经打开
    //         if(mxsubmenu[i].style.display=="block"){
    //           //如果已经打开,则关闭
    //           mxsubmenu[i].style.display="none";
    //         }else{
    //           //如果没有打开,则显示
    //           mxsubmenu[i].style.display="block";
    //         }
    //       }else{
    //         //把其他的子菜单关闭
    //         mxsubmenu[j].style.display="none";
    //       }
    //     }
    //   }
    // })(i);//别忘记这个参数
  };
  //2 设置子菜单项点击背景颜色改变
  var mxmenuitem = mxnav.getElementsByClassName("mx-menu-item");
  for (var k = 0; k < mxmenuitem.length; k++){
    mxmenuitem[k].addEventListener('click',function (){
      for (var k = 0; k < mxmenuitem.length; k++){
        mxmenuitem[k].classList.remove('mx-menu-item-active');
      }
      this.classList.add('mx-menu-item-active');
    },false)
  };


})()

//退出系统
function logout(url){
  window.location.replace(url);
}

//点击左侧导航,iframe加载新的模块
function changeto(url) {
  document.getElementById("mxiframe").src=url;
}

