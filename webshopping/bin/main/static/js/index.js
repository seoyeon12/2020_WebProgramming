$(document).ready(function(){
    console.log("Start Serve");
    console.log(sessionStorage.getItem('username'));

    //Menu findAll
    $.ajax({
        type: "GET",
        url: "/api/menu",
        contentType: "application/json",
        success: function (response) {
            console.log("MenuList 불러오기 성공");
            console.log(response);
            for(var i = 0; i < response.length; i++){
                console.log(JSON.stringify(response[i])); 
                $('.top_nav').append(
                    "<li> <a href= '#' class='MenuName'>" + response[i].name + "</a>" + 
                    "<ul class='submenu sub" + (i+1) + "'></ul>"
                    +"</li>"
                );
                $.getSubMenu(i+1);
            }
        },
        error: function (state, error) {
            console.log("MenuList 불러오기 에러", state, error);
            alert("MenuList 불러오기 에러가 발생하였습니다.");
        }
    });
    $.getProductAll();

    if (sessionStorage.getItem('username') !== null) {
        console.log("이미 로그인이 된 상태입니다.");
        $('#loginBox').fadeOut('fast');
        $('.modal_bg').fadeOut('fast');
        $('#userName').html(sessionStorage.getItem('username'));
    }else{
        //로그인 하기
        $('#login_btn').click(function(){
            let loginId = $('#account').val();
            let loginPassWord = $('#password').val();
            console.log("로그인 버튼 클릭");

            $.ajax({
                type: 'POST',
                url: '/api/user/login',
                contentType: "application/json",
                data: JSON.stringify({
                    account: loginId,
                    password: loginPassWord,
                }),
                success: function (response) {
                    if(response != ""){
                        console.log("로그인 성공");
                        console.log(response);
                        //LocalStore에 User 정보 넣기
                        $('#loginBox').fadeOut('fast');
                        $('.modal_bg').fadeOut('fast');
                        sessionStorage.setItem('userid',response.id);
                        sessionStorage.setItem('username',response.username);
                        alert("로그인 성공. 어서오십시오.");
                        $('#userName').html(response.username);
                    }else{
                        console.log("로그인 실패");
                        alert("아이디 혹은 비밀번호가 틀렸습니다. 다시 시도해주십시오.");
                    }
                },
                error: function (state, error) {
                    console.log("로그인 에러", state, error);
                    alert("로그인 에러가 발생하였습니다.");
                }
            });
        });
        //회원가입 하러가기
        $('#Injoin').click(function(){
            $('#joinBox').fadeIn('fast');
        });
        //회원가입 하기
        $('#join_btn').click(function(){
            let joinAccount = $('#joinId').val();
            let joinPassword = $('#joinPW').val();
            let joinName = $('#name').val();
            let joinTel = $('#tel').val();
            let joinPhone = $('#phone').val();
            let joinAddress = $('#address').val();
            let joinEmail = $('#email').val();

            $.ajax({
                type: 'POST',
                url: '/api/user',
                contentType: "application/json",
                data: JSON.stringify({
                    account: joinAccount,
                    password: joinPassword,
                    username: joinName,
                    tel: joinTel,
                    phone: joinPhone,
                    zipcode: "",
                    address: joinAddress,
                    email: joinEmail
                }),
                success: function (response) {
                    if(response != 1){
                        console.log("회원가입 실패");
                        alert("회원가입에 실패했습니다. 다시 시도해주십시오.");
                    }else{
                        console.log("회원가입 성공");
                        console.log(response);
                        alert("회원가입 성공. 로그인 해주십시오.");
                        $('#joinBox').css('display','none');
                    }
                },
                error: function (state, error) {
                    console.log("회원가입 에러", state, error);
                    alert("회원가입 에러가 발생하였습니다.");
                }
            });
        });
    }

});

//submenu 받아오기
$.getSubMenu = function(menuid){
    //SubMenu findByMenuId
    $.ajax({
        type: "GET",
        url: '/api/subMenu/menuid?menuid=' + menuid,
        contentType: "application/json",
        success: function (response) {
            console.log("SubMenuList 불러오기 성공");
            var subul = $('.top_nav').children().find('.sub' + menuid);
            for(var i = 0; i< response.length; i++){
                console.log(response[i].name);
                $(subul).append(
                    "<li><a href='#'>" + response[i].name + "</a></li>"
                );
            }
        },
        error: function (state, error) {
            console.log("SubMenuList 불러오기 에러", state, error);
            alert("SubMenuList 불러오기 에러가 발생하였습니다.");
        }
    });
};

//product findAll 목록 받아오기
$.getProductAll = function(){
    //product findAll
    $.ajax({
        type: "GET",
        url: '/api/product',
        contentType: "application/json",
        success: function (response) {
            console.log("product 불러오기 성공");
            console.log(response);
            //var subul = $('.top_nav').children().find('.sub' + menuid);
            // for(var i = 0; i < 8; i++){
            //     $('.productList').append(
                    
            //     );
            // }
        },
        error: function (state, error) {
            console.log("product findAll 불러오기 에러", state, error);
            alert("product findAll 불러오기 에러가 발생하였습니다.");
        }
    });
};