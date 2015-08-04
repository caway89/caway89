<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL 활용방법 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 날짜 변환 -->
<!-- core or control 라이브러리를 따서 "c" http://java.sun.com/jsp/jstl/core 에서 처리해 주겠다는 뜻 -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<% 

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>공지사항</title>
<link href="../resource/customer/notice.css" type="text/css"
   rel="stylesheet" />
</head>
<body>
   <!-- 헤더영역 -->>
   <tiles:insertAttribute name="header"/>
   <%-- <jsp:include page="../inc/header.jsp"/> --%>

   <div id="visual" class="customer">
      <div class="top-wrapper"></div>
   </div>
   <div id="main">
      <div class="top-wrapper clear">
         <!-- 바디부분 -->
          <tiles:insertAttribute name="body"/>
		<!-- 어사이드 부분 -->
		 <tiles:insertAttribute name="aside"/>
      </div>
   </div>
  <!-- 푸터부분 -->
   <tiles:insertAttribute name="footer"/>
</body>
</html>