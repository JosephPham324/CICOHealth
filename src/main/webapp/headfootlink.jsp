<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<link rel="stylesheet" href="./css/boostrap.css">
<link rel="stylesheet" href="./css/mainMenu.css" />
<link rel="stylesheet" href="./css/footer.css">
<link rel="icon" type="image/png" href="favicon.png"/>
<!--        <link rel="stylesheet" href="./font/fontawesome-free-6.1.1-web/css/all.min.css"/>-->
<script src="https://kit.fontawesome.com/1287d4f6f9.js" crossorigin="anonymous"></script>
<% 
    if (request.getSession().getAttribute("userID")!=null){
    out.println("<link rel='stylesheet' href='css/todaynumbers.css'>");
    out.println("<script src='scripts/todaynumbers.js'></script>'");
    }
%>