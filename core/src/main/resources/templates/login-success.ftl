<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <link crossorigin="anonymous"
          integrity="sha512-vyxxV30jroFLGg73wC/TL0VLiHywDHPM271unnBGBR9V43CHX0acAZI4Cm2a2nWnClCQbso+PoC8fLV6aQ7+vA=="
          href="https://lib.baomitu.com/layui/2.6.0/css/layui.css" rel="stylesheet">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend id="name"></legend>
</fieldset>
<script crossorigin="anonymous"
        integrity="sha512-WNLxfP/8cVYL9sj8Jnp6et0BkubLP31jhTG9vhL/F5uEZmg5wEzKoXp1kJslzPQWwPT1eyMiSxlKCgzHLOTOTQ=="
        src="https://lib.baomitu.com/jquery/3.5.1/jquery.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-qV4do3P6FgF7Bi3XFx0BPecT0RfBqia3ZcTKa7/goJbPpVTXvAHfPn/XBtm0XSG5N1HM1WuA/iz49vAIIMH/vA=="
        src="https://lib.baomitu.com/layui/2.6.0/layui.js"></script>
<script type="text/javascript" src="/js/util.js"></script>
</body>
<script type="text/javascript">

    $(document).ready(function () {
        let name = getPathVariable("name");
        $("#name").text('欢迎您，' + name);
    });
</script>
</html>