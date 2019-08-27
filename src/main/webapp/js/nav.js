$(function(){
    // nav收缩展开
    $('#aat').on('click','.nav-item>a',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            if ($(this).next().css('display') == "none") {
                //展开未展开
                $('.nav-item').children('ul').slideUp(300);
                $(this).next('ul').slideDown(300);
                $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
            }else{
                //收缩已展开
                $(this).next('ul').slideUp(300);
                $('.nav-item.nav-show').removeClass('nav-show');
            }
        }
    });
    // 标志点击样式
    $('#aat').on('click','.nav-item>ul>li',function(){
    	$('.nav-item>ul>li').css('background','none');
    	$(this).css('background','black');
    	var _link = $(this).children('a').attr('_link');
    	console.log(_link);
    	$('#mainContent').attr('src',_link);
    	//location.href='../main/showIndex2.do';
//  	$(this).siblings().css('background','none')
    })
    //nav-mini切换
    $('#mini').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            $('.nav-item.nav-show').removeClass('nav-show');
            $('.nav-item').children('ul').removeAttr('style');
            $('.nav').addClass('nav-mini');
        }else{
            $('.nav').removeClass('nav-mini');
        }
    });
});
