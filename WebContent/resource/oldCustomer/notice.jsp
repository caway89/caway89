<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.dao.mybatis.MybatisNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 활용방법 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   <!-- 날짜 변환 -->
<!-- core or control 라이브러리를 따서 "c" http://java.sun.com/jsp/jstl/core 에서 처리해 주겠다는 뜻 -->

<% /* Controler */
 	//NoticeDao noticeDao = new MybatisNoticeDao(); 
  	//List<Notice>list =  //검색어 1페이지
	NoticeDao noticeDao = new MybatisNoticeDao();
  	
  	/* List가 여기서 Model이다. */
  	List<Notice> list = noticeDao.getNotices();
  	
  	//공통데이터 저장소에 집어넣는다. 여기서는 request에 집어 넣는 것이다.
  	request.setAttribute("list", list);
 %>
 
<!DOCTYPE html><!-- View -->
<!-- div를 section으로 다 바꿈!! 이미지를 추가하기전 -->
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 페이지</title>
<link href="../css/style.css" type="text/css" rel="stylesheet"/>

<style>
/* 스타일 주기 위한 대상을 지정해줌, 선택을 잘해야 함! 태그를 통해서 선택하는 경우 
특화된것 들어감*/
</style>

</head>
<body>

	<header id="header">
		<h1>
			뉴렉처
			<!--  body안에 커다란 제목이 있는데 들여쓰기해야한다. 들여간다는것은 안쪽에 섹션이 따로 있다는 것이다. -->
		</h1>

		<section class="h1">
			<!-- 왜 section으로 했나요? -->
			<h1>머릿말</h1>
			<!-- section으로 따로 나눴으므로 <h2>에서 <h1>으로 변경 -->

			<nav id="main-menu"> <!-- 부모 -->
				<h1>메인메뉴</h1>
				<!-- nav라는 섹션으로 나뉘었기 때문에 h3에서 h1으로 변경 -->
				<ul>
				
					<li> <!-- 자식1(첫째) -->
						<a href="">학습가이드</a>
					</li>
					
					<li> <!-- 자식2(둘째) -->
						<a href="">뉴렉과정</a>
					</li>
					
					<li> <!-- 자식3(셋째) -->
						<a href="">강좌선택</a>	
					</li>
					
				</ul>
			</nav>
			
			<section id = "test">
				<h1>나와라</h1>
					<section>
						<h1>여기도 나오나??</h1>
					</section>
			</section>

			<!-- <section> -->
			<section id="lecture-search-form">
				<h1 class="h1">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend>검색정보</legend>
						<label>과정검색</label> 
						<input type="text" /> 
						<input type="submit" value="검색" />
					</fieldset>
				</form>
			</section>

			<nav>
				<h1>회원메뉴</h1>
				<ul>
					<li><a href="">HOME</a></li>
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>

			<nav>
				<h1>고객메뉴</h1>
				<ul>
					<li><a href="">마이페이지</a></li>
					<li><a href="">고객센터</a></li>
				</ul>
			</nav>
		</section>

	</header>

	<aside>
		<h1 class="h1">고객센터</h1>
		<!-- 제목인데, 몇번이 되야하지?-->

		<nav>
			<h1>고객센터 메뉴</h1>
			<ul>
				<li><a href="">공지사항</a></li>
				<li><a href="">1:1고객문의</a></li>
				<li><a href="">학습안내</a></li>
			</ul>
		</nav>

		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li><a href="">answeris</a></li>
				<li><a href="">tune-a</a></li>
			</ul>
		</nav>
	</aside>

	<main> <!--테이블--> <!--메인은 이 문서에서의 메인이다. body내에서만 main태그 한번만  쓸 수 있다. -->
		<section class="h1">
			<h1>공지사항</h1>
	
			<nav>
				<h1>경로</h1>
				<ul>
					<li><a href="">Home</a></li>
					<li><a href="">고객센터</a></li>
					<li><a href="">공지사항</a></li>
				</ul>
			</nav>
	
			<section>
			
				<h1>공지사항 검색폼</h1>
				
				<form>
					<fieldset>
						<legend>공지사항 검색정보</legend>
						<label>검색필드</label> 
						
						<select>
							<option>제목</option>
							<option>작성자</option>
						</select> 
						
						<label>검색어</label> 
						<input type="text" /> 
						<input type="submit"value="검색" />
						
					</fieldset>
				</form>
			</section>
	
			<nav>
			<c:forEach var="a" begin="1" end="3"> <!-- doStart, doEnd 등 다른 클래스에서 사용됨 -->
				<h1>${a}공지사항 목록</h1>
			</c:forEach>	
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${list}">
						<%-- <% for(int i=0; i<10; i++){%> --%>
							<tr>
								<%-- <td><%=list.get(i).getCode() %></td> --%>
								<td>${n.code}</td>
								<%-- <td><a href="noticeDetail.jsp?c=<%= list.get(i).getCode()%>"><%=list.get(i).getTitle()%></a></td> --%>
								<td><a href="noticeDetail.jsp?c=${n.code}">${n.title}</a></td>
								<td>${n.writer}</td>
								<%-- <td>${regDate }</td> --%>
								<td><fmt:formatDate value="${n.regDate }" pattern="yyyy-MM-dd"/></td>
								<td>${hit }</td>
					<!-- 			<td>admin</td>
								<td>2015-06-29</td>
								<td>1</td> -->
							</tr>
						 <%-- <%}%> --%>
						 </c:forEach>	
					</tbody>
				</table>
			</nav>
			
	
			<section>
				<h1>현재 페이지 번호</h1>
				<p>1 of 3pages</p>
			</section>
	
			<nav>
				<h1>페이지</h1>
				<ul>
					<li><a href="">1</a></li>
					<li><a href="">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">4</a></li>
					<li><a href="">5</a></li>
				</ul>
			</nav>
			
		</section>
	</main>

	<footer>
		<section>
			<h1>뉴렉처</h1>
			<section>
				<h1>관리자 정보</h1>
				<dl>
					<dt>주소 :</dt>
					<dd>서울특별시 동대문고 장안1동 423-4번지 윤진빌딩 4층</dd>
					<dt>관리자메일 :</dt>
					<dd>admin@newlecture.com</dd>
					<df>전화 :</df>
					<dd>02-478-4084</dd>
					<df>사업자등록번호 :</df>
					<dd>132-18-46763</dd>
					<df>통신 판매업 신고 :</df>
					<dd>제 2013-서울강동-0969 호 상호뉴렉처</dd>
					<df>대표 :</df>
					<dd>박용우</dd>
					<df>관리자 :</df>
					<dd>전성일</dd>
				</dl>
			</section>
			<section>
				<h1>저작권 정보</h1>
				<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
					Contact admin@newlecture.com for more information</p>
			</section>
		</section>
	</footer>
	
</body>
</html>