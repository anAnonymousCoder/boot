<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>
    <link crossorigin="anonymous"
          integrity="sha512-vyxxV30jroFLGg73wC/TL0VLiHywDHPM271unnBGBR9V43CHX0acAZI4Cm2a2nWnClCQbso+PoC8fLV6aQ7+vA=="
          href="https://lib.baomitu.com/layui/2.6.0/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/index.css"/>
    <link rel="stylesheet" href="/css/public.css">
</head>
<body>
<div class="ws-body">
    <div class="ws-cnt absolute-center">
        <div class="form-cnt">
            <div class="title">
                <span>登录</span>
                <img src="http://cdn.wuqingyu.site/boot/images/logo/paw2.png" width="30" height="30">
            </div>
            <form class="layui-form" action="/formLogin" method="post">
                <div class="layui-row layui-form-item layui-col-space16">
                    <div class="layui-col-sm12 layui-col-md12">
                        <!--                        <label class="layui-form-label">-->
                        <!--                            <i class="layui-icon layui-icon-username" style="font-size: 24px; margin-right: 5px"></i>-->
                        <!--                            用户名-->
                        <!--                        </label>-->
                        <div class="layui-input-block" style="margin-left: 0">
                            <input type="text" id="username" name="username" autocomplete="off" placeholder="请输入用户名"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-row layui-form-item layui-col-space16">
                    <div class="layui-col-sm12 layui-col-md12">
                        <!--                        <label class="layui-form-label">-->
                        <!--                            <i class="layui-icon layui-icon-password" style="font-size: 24px; margin-right: 5px"></i>-->
                        <!--                            密&#12288;码-->
                        <!--                        </label>-->
                        <div class="layui-input-block" style="margin-left: 0">
                            <input type="password" id="password" name="password" placeholder="请输入密码" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-row layui-form-item layui-col-space16">
                    <div class="layui-col-sm12 layui-col-md12">
                        <span class="register-btn">没有账号？点此注册</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block ws-btn">
                        <button type="submit" class="layui-btn layui-btn-normal layui-btn-fluid" lay-submit="">登录
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- 气泡 !-->
    <div class="wrapper">
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
<script crossorigin="anonymous"
        integrity="sha512-WNLxfP/8cVYL9sj8Jnp6et0BkubLP31jhTG9vhL/F5uEZmg5wEzKoXp1kJslzPQWwPT1eyMiSxlKCgzHLOTOTQ=="
        src="https://lib.baomitu.com/jquery/3.5.1/jquery.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-qV4do3P6FgF7Bi3XFx0BPecT0RfBqia3ZcTKa7/goJbPpVTXvAHfPn/XBtm0XSG5N1HM1WuA/iz49vAIIMH/vA=="
        src="https://lib.baomitu.com/layui/2.6.0/layui.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript" src="/js/util.js"></script>
</body>
</html>
