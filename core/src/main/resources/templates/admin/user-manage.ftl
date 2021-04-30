<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link crossorigin="anonymous"
          integrity="sha512-vyxxV30jroFLGg73wC/TL0VLiHywDHPM271unnBGBR9V43CHX0acAZI4Cm2a2nWnClCQbso+PoC8fLV6aQ7+vA=="
          href="https://lib.baomitu.com/layui/2.6.0/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/user-manage.css"/>
</head>
<body>
<table id="user-list" lay-filter="user-list"></table>
<script type="text/javascript" src="/lib/jquery1.11.3.min.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-qV4do3P6FgF7Bi3XFx0BPecT0RfBqia3ZcTKa7/goJbPpVTXvAHfPn/XBtm0XSG5N1HM1WuA/iz49vAIIMH/vA=="
        src="https://lib.baomitu.com/layui/2.6.0/layui.js"></script>
<script type="text/javascript" src="/js/user-manage.js"></script>
<script type="text/javascript" src="/js/util.js"></script>
</body>

<script type="text/html" id="genderTpl">
    {{# if(d.gender === null || d.gender === '') { }}
    <span></span>
    {{# } else if(d.gender === 'male') { }}
    <span>男</span>
    {{# } else { }}
    <span>女</span>
    {{# } }}
</script>

<script id="optBar" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="check">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>

</html>