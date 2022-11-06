<%-- 
    Document   : TodayNumbers
    Created on : Nov 6, 2022, 6:33:57 AM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var ="numbers" value ="${sessionScope.todayNumbers}"></c:set>
<div class="today-numbers">
    <div class="cal-eaten" id="cal-eaten">
        2000
    </div>
    <div class="all-numbers">
        <div class="goals">
            <div class="cal">Kcal: ${numbers[0]}</div>
            <div class="protein">P: ${numbers[1]}g</div>
            <div class="fat">F: ${numbers[2]}g</div>
            <div class="carb">C: ${numbers[3]}g</div>
        </div>
        <div class="consumed">
            <div class="cal">Kcal: ${numbers[4]}</div>
            <div class="protein">P: ${numbers[5]}g</div>
            <div class="fat">F: ${numbers[6]}g</div>
            <div class="carb">C: ${numbers[7]}g</div>
        </div>
        <div class="burned">
            <div class="cal">Kcal: ${numbers[8]}</div>
        </div>
        <div class="remaining">
            <div class="cal">Kcal: ${numbers[0]-(numbers[4]-numbers[8])}</div>
            <div class="protein">P: ${numbers[1]-numbers[5]}g</div>
            <div class="fat">F: ${numbers[2]-numbers[6]}g</div>
            <div class="carb">C: ${numbers[3]-numbers[7]}g</div>
        </div>
    </div>
</div>
