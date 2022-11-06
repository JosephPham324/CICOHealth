<%-- 
    Document   : TodayNumbers
    Created on : Nov 6, 2022, 6:33:57 AM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gDAO" class="DAO.GoalDAO" scope="request"></jsp:useBean>
<c:set var ="numbers" value ="${gDAO.getTodayNumbers(sessionScope.userID)}"></c:set>
    <div class="today-numbers">
        <div class="cal-eaten" id="cal-eaten">
            <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[4]}"/>
    </div>
    <div class="all-numbers">
        <div class="goals">
            <div class="cal">Kcal: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[0]}"/>
            </div>
            <div class="protein">P: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[1]}"/>g</div>
            <div class="fat">F: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[2]}"/>g</div>
            <div class="carb">C: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[3]}"/>g</div>
        </div>
        <div class="consumed">
            <div class="cal">Kcal: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[4]}"/></div>
            <div class="protein">P:<fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value=" ${numbers[5]}"/>g</div>
            <div class="fat">F: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[6]}"/>g</div>
            <div class="carb">C: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[7]}"/>g</div>
        </div>
        <div class="burned">
            <div class="cal">Kcal: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[8]}"/></div>
        </div>
        <div class="remaining">
            <div class="cal">Kcal: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[0]-(numbers[4]-numbers[8])}"/></div>
            <div class="protein">P: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[1]-numbers[5]}"/>g</div>
            <div class="fat">F: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[2]-numbers[6]}"/>g</div>
            <div class="carb">C: <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${numbers[3]-numbers[7]}"/>g</div>
        </div>
    </div>
</div>
