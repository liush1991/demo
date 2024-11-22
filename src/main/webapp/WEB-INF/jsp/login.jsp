<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<% String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>快乐运动</title>

    <script  src="<%=basePath%>js/jquery-3.5.1.min.js" ></script>
    <script></script>
</head>
    <body >
       <p>${login}</p>
        <img src="<%=basePath%>image/hero0.png" alt="hero0.png" >
        <img src="<%=basePath%>image/hero0.png" alt="hero0.png" >
        <div>
            <button id="butn">按钮1</button>
            <button id="butn2">按钮2</button>
            <button id="butn3">按钮3</button>

        </div>
       <a href="${pageContext.request.contextPath }/downloadController/loadpage.do">跳转下载页面</a>
       <p>${pageContext.request.contextPath }</p> <%--  /demo--%>
       <p><%=path%></p><%--  /demo--%>
       <p><%=basePath%></p> <%-- http://localhost:8080/demo/--%>
       <script type="text/javascript">
           var butn= document.getElementById("butn");
           butn.onclick=function(){
               console.log("ffffff")
               var xhr = new XMLHttpRequest();
               xhr.open('GET', 'Ajax.do?param=2222');
               xhr.send();
               xhr.onreadystatechange = function() {
                   // 当前 this 为 xhr
                   if (this.readyState == 4) {
                       if (this.status === 200 || this.status === 304) {
                           console.log("成功")
                           var res = this.response
                           var resText = this.responseText
                           var resXml = this.responseXML
                           console.log(res[0]) // 分别打印三者
                       }
                   }
               };
           }
           var butn2= document.getElementById("butn2");
           butn2.onclick=function(){
               console.log("ffffff222")
               var xhr1 = new XMLHttpRequest();
               xhr1.open('POST', 'Ajax.do');
               xhr1.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
               xhr1.send("param=2222");
               xhr1.onreadystatechange = function() {
                   // 当前 this 为 xhr
                   if (this.readyState == 4) {
                       if (this.status === 200 || this.status === 304) {
                           console.log("成功")
                       }
                   }
               };
           }

       </script>
    <script >
     //   $(document).ready(function(){});
        var butn3= document.getElementById("butn3");
        butn3.onclick=function(){
            console.log('111')
           /* $.ajax({
                method: 'post',
                url: 'Ajax.do',
                data: {
                    param:1111,
                    b:2
                }
            }).then(data => {
                console.log("data  "+data)
                console.log(data.sss)
            }).catch(e => {
                console.log('/Ajax.do', e)
            })*/
            $.ajax({
                url:"Ajax.do",
                data:{param:'1111'},
                type:"post",
                dataType:"json",
                success:function(obj){
                    console.log("成功1");
                    console.log(obj);
                }
            })
        }

    </script>
    </body>

</html>
