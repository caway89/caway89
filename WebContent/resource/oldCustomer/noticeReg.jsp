<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="com.newlecture.web.dao.mybatis.MybatisNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
  //	if(request.getMethod().equals("POST"))  // EQUAL or POST
	//{
		/* String title = request.getParameter("title"); */
		/* 바꿔주는게 너무 불현함!!!! -> 서블릿 필터 필요  */
		
		/*이렇게 일일이 UTF-8로 바꾸어주면 불편하다.*/
		/*그래서 필터를 만드는것이고 방법은 두가지가 있는데 */
		/*1. xml  2. annotation */
		/* String title = new String(request.getParameter("title").getBytes("ISO8858-1"),"UTF-8"); */
//		String title = request.getParameter("tilte");
	//	String file = request.getParameter("file");
	//	String content = request.getParameter("content");
		
	//	Notice notice = new Notice();
	//	notice.setTitle(title);
	//	notice.setWriter("newlec");
	//	notice.setContent(content);
		
		// 파일은 다른방식으로 저장
		
	//	NoticeDao noticeDao = new MybatisNoticeDao();
	//	noticeDao.addNotice(notice);
	
		//notice.jsp 페에지로 이동
	//	response.sendRedirect("notice.jsp"); 
	//} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록 페이지</title>
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

		<section>
			<h1>공지내용${header.host}</h1>
			<form action="noticeReg.jsp" method="POST">  <!-- 자기자신은 생략가능 -->
				<fieldset>
					<legend>공지사항 정보</legend>
					<dl>
						<dt>제목</dt>
						<dd>
							<input name="title"/>
						</dd>

						<dt>첨부파일</dt>
						<dd>
							<input type="file" name="file"/>
						</dd>

						<dt>내용</dt>
						<dd>
							<textarea cols="40" rows="20" name="content"></textarea>
						</dd>
					</dl>
					<div>
						<input type="submit" value="등록" />
					</div>
				</fieldset>
			</form>
		</section>

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
