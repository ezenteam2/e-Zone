<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>    
<jsp:include page="kb_w_user_MainHeader.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/kb_w_user_Main.css">
    <title>Document</title>
</head>
<body>
    <main id="Mainpage_Main">
        <div id="carousel_Div">
            <img src="Image/banner.png" id="carousel_Img">
        </div>

        <div id="SeminaZone_main_Div">
                <div class="SeminaZone_Info_Div" id="SeminaZone_Div_First"> 
                    <div class="SeminaZone_Image_div">
                        <img src="Image/Semina1.jpg" class="SeminaZone_Image">
                    </div>
                    <div class="SeminaZoneName"><h3 style="text-align: center;">다이아몬드존</h3></div>
                    <div class="SeminaZonenumber"><h3 style="text-align:right">수용인원 : 최대 40명</h3></div>
                </div>
                <div class="SeminaZone_Info_Div">
                    <div class="SeminaZone_Image_div">
                        <img src="Image/Semina2.jpg" class="SeminaZone_Image">
                    </div>
                    <div class="SeminaZoneName"><h3 style="text-align: center;">프리미엄존</h3></div>
                    <div class="SeminaZonenumber"><h3 style="text-align:right">수용인원 : 최대 40명</h3></div>
                </div>
                <div class="SeminaZone_Info_Div">
                    <div class="SeminaZone_Image_div">
                        <img src="Image/Semina3.jpg" class="SeminaZone_Image">
                    </div>
                    <div class="SeminaZoneName"><h3 style="text-align: center;">골드존</h3></div>
                    <div class="SeminaZonenumber"><h3 style="text-align:right">수용인원 : 최대 30명</h3></div>
                </div>
                <div class="SeminaZone_Info_Div">
                    <div class="SeminaZone_Image_div">
                        <img src="Image/Semina4.jpg" class="SeminaZone_Image">
                    </div>
                    <div class="SeminaZoneName"><h3 style="text-align: center;">실버존</h3></div>
                    <div class="SeminaZonenumber"><h3 style="text-align:right">수용인원 : 최대 25명</h3></div>
                </div>
        </div>
        <div id="Recom_Semina_Div">
            <div class="RecomSemina_Info_Div">
                <div class="Recom_Semina_Img_Div">
                    <img src="Image/Semina_Poster1.png" class="RecomSemina_Img">
                </div>
                <div><h3 style="text-align: center;">산업혁신아이디어</h3></div>
                <div class="RecomSemina_Date"><h3 style="text-align: right;">2020.04.10 14:00~16:00</h3></div>
                <div class="RecomSemina_SeminaZone"><h4 style="text-align: right;">프리미엄존</h4></div>
                <div class="RecomSeminanumber"><h3 style="text-align:right">신청인원 : 25/40명</h3></div>
                
            </div>
            <div class="RecomSemina_Info_Div">
                <div class="Recom_Semina_Img_Div">
                    <img src="Image/Semina_Poster2.jpg" class="RecomSemina_Img">
                </div>
                <div><h3 style="text-align: center;">틴 경제세미나</h3></div>
                <div class="RecomSemina_Date"><h3 style="text-align: right;">2020.04.11 10:00~12:00</h3></div>
                <div class="RecomSemina_SeminaZone"><h4 style="text-align: right;">프리미엄존</h4></div>
                <div class="RecomSeminanumber"><h3 style="text-align:right">신청인원 : 20/40명</h3></div>
            </div>
            <div class="RecomSemina_Info_Div">
                <div class="Recom_Semina_Img_Div">
                    <img src="Image/Semina_Poster3.jpg" class="RecomSemina_Img">
                </div>
                <div><h3 style="text-align: center;">AWS JOB GO</h3></div>
                <div class="RecomSemina_Date"><h3 style="text-align: right;">2020.04.11 16:00~18:00</h3></div>
                <div class="RecomSemina_SeminaZone"><h4 style="text-align: right;">골드존</h4></div>
                <div class="RecomSeminanumber"><h3 style="text-align:right">신청인원 : 25/30명</h3></div>
            </div>
            <div class="RecomSemina_Info_Div">
                <div class="Recom_Semina_Img_Div">
                    <img src="Image/Semina_Poster4.jpg" class="RecomSemina_Img">
                </div>
                <div><h3 style="text-align: center;">리더십 세미나</h3></div>
                <div class="RecomSemina_Date"><h3 style="text-align: right;">2020.04.11 10:00~12:00</h3></div>
                <div class="RecomSemina_SeminaZone"><h4 style="text-align: right;">다이아몬드존</h4></div>
                <div class="RecomSeminanumber"><h3 style="text-align:right">신청인원 : 15/40명</h3></div>
            </div>
        </div>  
    </main>
</body>
</html>
<jsp:include page="kb_w_user_MainFooter.jsp"/>