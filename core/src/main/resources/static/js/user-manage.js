layui.use(['table', 'layer'], function () {
    let table = layui.table
        , layer = layui.layer;

    /**
     * 渲染表格
     */
    var tableIns = table.render({
        elem: '#user-list'
        , height: 'full-200'
        , url: '/rest/users/page'
        , page: true
        , toolbar: 'default'
        , cols: [[
            {type: 'checkbox'}
            , {field: 'number', title: '编号', width: '20%', align: 'center', sort: true}
            , {field: 'name', title: '姓名', width: '20%', align: 'center',}
            , {field: 'age', title: '年龄', width: '20%', align: 'center', sort: true}
            , {field: 'gender', title: '性别', width: '20%', align: 'center', templet: '#genderTpl'}
            , {field: 'options', title: '操作', align: 'center', templet: '#optBar', fixed: 'right'}
        ]]
    });

});