<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 활용방법 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreePosts</title>
 <link href="../css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<style>
	
	#top {
	  	 height: 30px;
	  	 background:green;
	}
	
	
	#header {
	  	height:100px;
	  	background:grey;	   
	} 

	
	#body {
	  	min-height:300px;
	  	background:yellow;
	}
	
	#footer {
	  	min-height:200px;
	  	background:purple;
	}
	
	
	
	/* 세번쨰 방 */
	
	#main{
		float: left; 
	}
	
	
	#main-header{
		height:inherit;
		width:920px;
		background:blue;
	
	}
	
	#main-content{
		min-height:inherit;
		width:920px;
		background:cyan;
	
	
	}
	
	#aside{
		height:inherit;
		background:white;
		
		margin-left: 10px;
		
		
	}
	
	
	
	
	.content-wrapper 
	{
	   /* height: 100%; */
	   min-height:inherit;
	   width: 1152px; /* 왼쪽 정렬 된다. */
	   margin-left: auto; /* 오른쪽 정렬 된다.*/
	   margin-right: auto; /* margin을 왼쪽, 오른쪽 다주면 가운데 정렬 된다. */
	   
	   /* opacity: 0.5; */
	}
	
	.clearfix:after/* 동생이 있지만 보이지 않으면 안된다. (존재하지 않는 슈도 동생) clerfix 생성되면 알아서 생성 된다.*/
	{
	   /* 숨기기 
	   visibility: hidden; (존재하지만 안보이는것 뿐 투명망토)
	   display null (공간도 없고 아예 사라짐)
	   */
	   content: ".";
	   display: block; 
	   clear: both; 
	   visibility: hidden;
	   line-height: 0;
	   height: 0;    
	}
	
	/*** 특이 클래스 ***/
	h1.hidden {
    display: none;
	}

</style>




</head>
<body>
	<h1 class="hidden">게시판</h1>
	<header>
		<section>
			<h1 class="hidden">헤더메뉴</h1>
				
				<div id="top">
				<div class="content-wrapper">
				<nav>
					<h1>최상단 메뉴</h1>
						<ul>
							<li>홈</li>
							<li>게시판 카테고리</li>
							<li>즐겨찾기</li>
							<li>스크랩</li>
							<li>ID</li>
							<li>설정</li>
						</ul>
				</nav>
				</div>
				</div>
				
				<div id="header">
				<div class="content-wrapper">
				<section>
					<h1>상단메뉴</h1>
						<p>로고</p>
						<p>살어리 살어리낫다.</p>
				</section>
				</div>
				</div>
				
				
		</section>	
	</header>
	
	<div id="body">
	<div class="content-wrapper clearfix">
	<main>
		<section>
			<h1 class="hidden">게시판 메인</h1>
			
				<div id="main-header">
				
				<header>
					<section>
						<h1>게시판 헤더</h1>
						
						<p>게시판이름</p>
						<p>게시판 설명 + 상시 공지</p>
						<p><a href="">공지사항 클릭시 openup</a></p>
					</section>				
				</header>
				
				</div>
				
				<div id="main">
				<div id="main-content">
				<nav>
					<h1>게시판 글 목록</h1>
						
						<table>
							<thead>
								<tr>
									<th>글 번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>등록일</th>
									<th>조회수</th>
									<th>추천</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>10</td>
									<td>몇일전 갑자기 목소리가 안나왕 [12]</td>
									<td>하퍼리</td>
									<td>2015.07.19</td>
									<td>132</td>
									<td>14/2</td>
								</tr>
								<tr>
									<td>10</td>
									<td>몇일전 갑자기 목소리가 안나왕 [12]</td>
									<td>하퍼리</td>
									<td>2015.07.19</td>
									<td>132</td>
									<td>14/2</td>
								</tr>
								
								
							</tbody>
						</table>
				</nav>
				
			
		
				<nav>
					<h1>게시판 하단 네비</h1>
						<p>이전 페이지</p>
						<p>다음 페이지</p>
						<p>글 쓰기</p>
				</nav>
				
				<nav>
					<h1>게시판 페이지 이동</h1>
						
						<ul>
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
						</ul>
				</nav>
		
				</div>
		
		
		
			
		</section>
		
	</main>
	
	
		<div id="aside">
		<aside>
			<h1>게시판 어사이드 메뉴</h1>
				<p>게시판 베스트 가기</p>
				<p>이 게시판 즐겨찾기 추가</p>
				
				<caption>게시판 최근 댓글</caption>
				<ul>
					<li>최근 댓글 내용1</li>
					<li>최근 댓글 내용2</li>
					<li>최근 댓글 내용3</li>
					<li>최근 댓글 내용4</li>
					<li>최근 댓글 내용5</li>
				</ul>				
		</aside>
		</div>
		
	</div>		
	</div>	
	</div>
	
	
	<div id="footer">
	<div class="content-wrapper">
	<footer>
		<section>
			<h1>저작 정보</h1>
		</section>
	</footer>
	</div>
	</div>
</body>
</html>