<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>SpringBoot</title>
    <meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
</head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="<%=basePath%>js/jquery-3.5.1.min.js"  type="text/javascript"></script>
<script src="<%=basePath%>js/index.js" type="text/javascript"></script>

<link href="<%=basePath%>css/index.css" rel="stylesheet" type="text/css"/>

<body>
<div id="d1">
<p style="display: inline-block;height: 20px;width:20px;">dfsf</p>
</div>
<div id="d2">
    <div id="d3">
        <div></div>
        <ul>
            <li title="下载"><div>下载1</div></li>
            <li title="登陆"><div>登陆1</div></li>
        </ul>
    </div>
    <div id="d4">
        <iframe id="tab1"  class="tab" title="tab1" src="<%=basePath%>downloadController"  frameborder="0"></iframe>
        <iframe id="tab2" class="tab" title="tab2" src="<%=basePath%>testController/login.do"  frameborder="0"></iframe>

    </div>
</div>

</body>

</html>
