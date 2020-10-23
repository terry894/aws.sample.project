var main = {
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        })
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
         alert('글이 등록되었습니다.');
         window.location.href='/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }

};

main.init();

//var index = {..}를 사용한 이유 : 브라우저 공용 scope를 가지고 있어서 index.js 이후에 불리는 js 파일에서
//init, save function을 사용하 경우 문제가 발생 할 수 잇기 때문에