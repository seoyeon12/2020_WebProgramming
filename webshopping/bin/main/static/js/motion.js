$(document).ready(function(){

    console.log("=====Init Motion.js=====");

    $('.top_nav').mouseenter(function(){
        $('.submenu').stop().fadeIn('slow');
    });
    
    $('.top_nav').mouseleave(function(){
        $('.submenu').stop().fadeOut('fast');
    });

    setInterval( $.slideMotion, 3000);
});

$.slideMotion = function(){
    $('.slide>ul>li:first')
    .fadeOut(2000)
    .next()
    .fadeIn(2000)
    .end()
    .appendTo('.slide>ul');
};