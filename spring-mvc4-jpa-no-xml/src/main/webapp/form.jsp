<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<!DOCTYPE html>
<html>
<head>
<title>form.jsp</title>
</head>
<body>
<br>
<ol><li>
            <a href='<%=request.getContextPath()%>/helloAction/sayHello1.do?ename=peter1�d�ç�'>forward-1</a>
<br>
<br><br>
</li><li>
            <form method="get" action="<%=request.getContextPath()%>/helloAction/sayHello2.do">
                     �п�J�z���W�r:
               <input type="text" name="ename" value="peter2�d�ç�"><p>
               <input type="submit" value="forward-2">
            </form>
<br><br>
</li><li>

            <form method="post" action="<%=request.getContextPath()%>/helloAction/sayHello3_Redirect.do">
                     �п�J�z���W�r:
               <input type="text" name="ename" value="peter3�d�ç�"><p>
               <input type="submit" value="redirect">
            </form>
</li></ol>
</body>
</html>