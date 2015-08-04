<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="com.newlecture.web.dao.mybatis.MybatisNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% // 컨트롤러
    NoticeDao noticeDao = new MybatisNoticeDao();
    
	String code = request.getParameter("c");
    
	// Notice: 알맹이 
    Notice n = noticeDao.getNotice(code);
	
	// 컨트롤러에서 request에 담는다. 
 	request.setAttribute("n", n); 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 정보 페이지</title>
</head>
<body>
	<header id="header">
		<h1>
			<img alt="뉴렉처" src="../images/logo.png" />
		</h1>
		<section>
			<h1>머리말</h1>

			<nav>
				<h1>메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<section>
				<h1>과정검색폼</h1>
				<form>
					<fieldset>
						<legend>검색정보</legend>
						<label>과정검색</label> <input type="text" /> <input type="submit"
							value="검색" />
					</fieldset>
				</form>
			</section>

			<!-- 	fieldset 은 테두리 legend는 테두리 이름
			label 은 이름
 		-->

			<nav>
				<h1>회원메뉴</h1>
				<ul>
					<li><a href=""> home</a></li>
					<li><a href=""> 로그인</a></li>
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
		<h1>고객센터</h1>
		<nav>
			<h3>고객센터메뉴</h3>
			<ul>
				<li><a href="">공지사항</a></li>
				<li><a href="">1:1고객문의</a></li>
				<li><a href="">학습안내</a></li>
			</ul>
		</nav>

		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li><a href=""><img alt="answeris"
						src="../images/answeris.png"></a></li>
				<li><a href=""><img alt="tune-a" src="../images/tune-a.png"></a></li>
			</ul>
		</nav>
		<section>
			<h1>구글광고</h1>
		</section>
	</aside>

	<main>

	<section>
		<h1>공지사항내용</h1>
		<section>
			<h1>공지사항 경로</h1>
			<ul>
				<li>홈</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ul>
		</section>

		<article>
			<!--  내용이 있으면 article  -->
			<h1>공지내용${header.host}</h1>
			<dl>
				<dt>제목</dt>
				<%-- <dt><%=n.getTitle() %></dt> --%>
				<!-- 데이터를 뽑아 쓸 때 코드가 복잡해짐, 보기어려워.. 저장소에서 데이터 추출하는 쉬운 표현 EL 도입 -->
				<%-- <dt><%=((Notice)request.getAttribute("n")).getTitle()%></dt>   --%>
				<%-- <dt>${n["title"]}</dt> --%>  <!-- EL, 코드도 간결, 자바 코드 없애기  -->
				
				<dt>작성일</dt>
<%-- 				<dd><%=n.getRegDate()%></dd> --%>
				<dd>${n.regDate}</dd>
				<!-- 예외적으로 session에서만 데이터를 뒤지고 싶을때 --> 
				<%-- <dd>${sessionScope.n.regDate}</dd>  --%>
				
				<dt>작성자</dt>
<%-- 				<dd><%=n.getWriter()%></dd> --%>
				<dd>${n.writer}</dd>                                <!-- 방법1 -->
				<%-- <dd>${n["writer"]}</dd> --%>		 <!-- 방법2 -->
				
				<dt>조회수</dt>
<%-- 				<dd><%=n.getHit()%></dd> --%>
				<dd>${n.hit}</dd>
				
				<dt>첨부파일</dt>
				<dd>아직구현안함</dd>
				
				<dt>내용</dt>
<%-- 				<dd><%=n.getContent()%></dd> --%>
				<dd>${n.content}</dd>
			</dl>
		</article>

		<nav>
			<h1>버튼 목록</h1>
			<p>
				<a href="notice.jsp"> 목록</a>
			</p>
		</nav>
	</section>
	</main>

	<aside></aside>

	<footer>

		<section>
			<h1>뉴렉처</h1>
			<section>
				<h1>관리자 정보</h1>
				<dl>
					<dt>주소:</dt>
					<dd>쌍용</dd>
					<dt>메일:</dt>
					<dd>newlecture@newlec.com</dd>
					<dt>사업자:</dt>
					<dd>2020</dd>
					<dt>통신 판매업 신고 :</dt>
					<dd>뉴렉처</dd>
					<dt>대표:</dt>
					<dd>뉴렉</dd>
					<dt>관리자:</dt>
					<dd>이하신</dd>
				</dl>
			</section>
			<section>
				<h1>저작권 정보</h1>
				<p>practice</p>
			</section>
		</section>

	</footer>

</body>
</html>
