<%-- 
    Document   : headfootlink
    Created on : Oct 6, 2022, 11:35:56 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/scss/main/General/mainMenu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/scss/main/General/footer.css">

<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>
<script src="https://kit.fontawesome.com/1287d4f6f9.js" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/Assets/scripts/headfootscript.js"></script>

<c:if test="${sessionScope.userID!=null}">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/scss/main/General/todaynumbers.css">
    <script src="${pageContext.request.contextPath}/Assets/scripts/todaynumbers.js"></script>
</c:if>