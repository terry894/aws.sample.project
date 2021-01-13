var main = {
    init : function(){
        var _this = this;

        $('#btn-update').on('click',function(){
            console.log("update");
            _this.update();
        })

        $('#btn-delete').on('click',function(){ㅇ
            _this.delete();
        })

        $('#btn-save').on('click', function(){
            _this.save(); // 클릭이벤트가 발생했을때 실행되도록 설정
        })
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type: 'POST', //
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
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
        type: 'DELETE',
        url: '/api/v1/posts/'+ id,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제 되었습니다.')
            window.location.href='/';
        }).fail(function(error){
            alert(Json.stringify(error));
        });

    },
    update : function() {
        var data ={
            title:$('#title').val(),
            content:$('#content').val()
        }


        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+ id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정 되었습니다.');
            window.location.href='/';
        }).fail(function(error){
            alert(Json.stringify(error));
        });
    }
};

main.init();

//var index = {..}를 사용한 이유 : 브라우저 공용 scope를 가지고 있어서 index.js 이후에 불리는 js 파일에서
//init, save function을 사용하는 경우 문제가 발생 할 수 잇기 때문에