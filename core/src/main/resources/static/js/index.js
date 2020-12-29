/*
layui.use(['form', 'layer', 'jquery'], function () {
    let form = layui.form
        , layer = layui.layer
        , $ = layui.$;

    /!**
     * 提交表单
     *!/
    form.on('submit(submitBtn)', function (data) {
        let field = data.field;
        let name = field.name, password = field.password;
        let ajaxTimeOut = $.ajax({
            url: '/rest/user/login',
            type: 'get',
            data: {
                name: name,
                password: password
            },
            success: function (res) {
                console.log(res);
                if (res.code === 2) {
                    layer.msg("该用户不存在！");
                    $("#name").val('');
                } else if (res.code === 0) {
                    layer.msg("登录成功！");
                    //let href = "pages/login-success.html" + encodeURI("?name=" + name);

                    window.location.href = '/user/user-manage';
                } else {
                    layer.msg("密码错误！");
                    $("#password").val('');
                }
            },
            error: function () {
                layer.msg("请求发送错误");
            },
            complete: function (XMLHttpRequest, status) {
                if (status === 'timeout') {//超时,status还有success,error等值的情况
                    ajaxTimeOut.abort(); //取消请求
                    layer.msg('请求超时，请重试', {icon: 2});
                }
            }
        });
        return false;
    });
});*/
