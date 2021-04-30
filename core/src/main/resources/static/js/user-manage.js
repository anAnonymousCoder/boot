layui.use(['table', 'layer'], function () {
    let table = layui.table
        , layer = layui.layer;

    /**
     * 渲染表格
     */
    let tableIns = table.render({
        elem: '#user-list'
        , height: 'full-200'
        , id: 'user-list'
        , url: '/rest/user/page'
        , page: true
        , toolbar: 'default'
        , cols: [[
            {type: 'checkbox'}
            , {field: 'number', title: '编号', width: '20%', align: 'center', sort: true}
            , {field: 'username', title: '用户名', width: '20%', align: 'center',}
            , {field: 'age', title: '年龄', width: '20%', align: 'center', sort: true}
            , {field: 'gender', title: '性别', width: '20%', align: 'center', templet: '#genderTpl'}
            , {field: 'options', title: '操作', align: 'center', templet: '#optBar', fixed: 'right'}
        ]]
    });

    table.on('tool(user-list)', function (obj) {
        if (obj.event === 'check') {
            layer.open({
                type: 2,
                title: 'demo',
                area: ['1200px', '650px'],
                shadeClose: true,
                maxmin: true,
                content: '/',
            });
        }
    });
});