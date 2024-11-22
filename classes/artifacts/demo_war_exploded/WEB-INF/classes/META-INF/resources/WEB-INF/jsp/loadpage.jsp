<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/3/30
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #d1 {
        background-color: aquamarine;
        width: 500px;
        height: 200px;
        float: left;

    }

    #d2 {
        background-color: cadetblue;
        width: 500px;
        height: 200px;
        float: left;
    }

    #a1 {
        background-color: blue;
        font-size: 20px;
        color: red;
        width: 100px;
        display: block;
        margin-top: 20px;
    }

    #a2 {

        background-color: blue;
        color: red;
    }
    html,body{
        margin: 0px;
        adding:0px;
    }
</style>
<body>

<div id="d1">
    <a id="a1" style="margin-top:20px;"
       href="${pageContext.request.contextPath }/downloadController/download1.do">下载文件1</a><br>
    <a id="a2" href="${pageContext.request.contextPath }/downloadController/download2.do">下载文件2</a><br>
    <a id="a3" href="${pageContext.request.contextPath }/xls/EmployeeBatchDPAdd.xls">下载文件3</a>
</div>
<div id="d2">
    <div>单文件上传
        <form method="post" action="${pageContext.request.contextPath }/downloadController/upload.do"
              enctype="multipart/form-data">
            <input type="file" name="file"><br>
            <input type="submit" value="上传">
        </form>
    </div>
    <div >多文件上传
        <form method="post" action="${pageContext.request.contextPath }/downloadController/upload2.do"
              enctype="multipart/form-data">
            <input type="file" name="file"><br>
            <input type="file" name="file"><br>
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</body>
</html>
