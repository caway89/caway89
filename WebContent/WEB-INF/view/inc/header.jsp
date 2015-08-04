
<div id="header">
   <div class="top-wrapper">
      <h1 id="logo">
         <a href="../index.jsp"><img src="../images/logo.png" alt="뉴렉처" /></a>
      </h1>
      <h2 class="hidden">메인메뉴</h2>
      <ul id="mainmenu" class="block_hlist">
         <li><a href="">학습가이드</a></li>
         <li><a href="">과정선택</a></li>
         <li><a href="">인기과정</a></li>
      </ul>
      <form id="searchform" action="" method="get">
         <fieldset>
            <legend class="hidden"> 과정검색폼 </legend>
            <label for="query">과정검색</label> <input type="text" name="query" />
            <input type="submit" class="button" value="검색" />
         </fieldset>
      </form>
      <h3 class="hidden">로그인메뉴</h3>
      <ul id="loginmenu" class="block_hlist">
         <li><a href="../index.jsp">HOME</a></li>
         <li>
            <%-- <c:if test="${empty pageContext.request.userPrincipal }">
                  <a href="../joinus/login">로그인</a>
               </c:if>
               <c:if test="${not empty pageContext.request.userPrincipal }">
                  <a href="${ctxName }/j_spring_security_logout">${pageContext.request.userPrincipal.name } 로그아웃</a>
               </c:if> --%> <a href="../joinus/login">로그인</a> <a
            href="${ctxName }/j_spring_security_logout"><security:authentication
                  property="name" /> 로그아웃</a> <security:authentication
               property="authorities" var="auths" /> <c:forEach items="${auths }"
               var="auth">
                     ${auth.authority }
                  </c:forEach>
         </li>



         <li><a href="../joinus/join.jsp">회원가입</a></li>
      </ul>
      <h3 class="hidden">회원메뉴</h3>
      <ul id="membermenu" class="clear">
         <li><a href=""><img src="../images/menuMyPage.png"
               alt="마이페이지" /></a></li>
         <li><a href="notice.jsp"><img
               src="../images/menuCustomer.png" alt="고객센터" /></a></li>
      </ul>
   </div>
</div>




<%--       <div class="top-wrapper">
         <h1 id="logo">
            <a href="../index.jsp"><img src="../resource/images/logo.png"
               alt="뉴렉처" /></a>
         </h1>
         <h2 class="hidden">메인메뉴</h2>
         <ul id="mainmenu" class="block_hlist">
            <li><a href="">학습가이드</a></li>
            <li><a href="">과정선택</a></li>
            <li><a href="">인기과정</a></li>
         </ul>
         <form id="searchform" action="" method="get">
            <fieldset>
               <legend class="hidden"> 과정검색폼 </legend>
               <label for="query">과정검색</label> <input type="text" name="query" />
               <input type="submit" class="button" value="검색" />
            </fieldset>
         </form>
         <h3 class="hidden">로그인메뉴</h3>
         <ul id="loginmenu" class="block_hlist">
            <li><a href="../index.jsp">HOME</a></li>
            <li>
            <!-- 다른 페이지 에서는 안보여짐 다른 페이지 에서도 넣어 줘야함 -> 페이지 집중화 필요 -->
            <c:if test="${empty pageContext.request.userPrincipal}">
                  <a href="../joinus/login">로그인</a>
               </c:if> 
               
               <c:if test="${not empty pageContext.request.userPrincipal}">
                  <a href="${ctxName}/j_spring_security_logout">${pageContext.request.userPrincipal.name}로그아웃</a>
               </c:if></li>
            
               <a href="../joinus/login">로그인</a>
                    <a href="${ctxName}/j_spring_security_logout"><security:authentication property="name"/>로그아웃</a>
               
               <security:authentication property="authorities" var="authorities"/>
               <c:forEach items="${authorities}" var="auth">
                  ${auth.authority}
               </c:forEach> --% ><%-- 권한정보
            </li>
            <li>
            <a href="../joinus/join.jsp">회원가입</a>
            </li>
         </ul>
         <h3 class="hidden">회원메뉴</h3>
         <ul id="membermenu" class="clear">
            <li><a href=""><img
                  src="../resource/images/menu-myPage.png" alt="마이페이지" /></a></li>
            <li><a href="notice.jsp"><img
                  src="../resource/images/menu-customer.png" alt="고객센터" /></a></li>
         </ul>
      </div>
      <div class="top-wrapper">
         <h1 id="logo">
            <a href="../index.jsp"><img src="../resource/images/logo.png"
               alt="뉴렉처" /></a>
         </h1>
         <h2 class="hidden">메인메뉴</h2>
         <ul id="mainmenu" class="block_hlist">
            <li><a href="">학습가이드</a></li>
            <li><a href="">과정선택</a></li>
            <li><a href="">인기과정</a></li>
         </ul>
         <form id="searchform" action="" method="get">
            <fieldset>
               <legend class="hidden"> 과정검색폼 </legend>
               <label for="query">과정검색</label> <input type="text" name="query" />
               <input type="submit" class="button" value="검색" />
            </fieldset>
         </form>
         <h3 class="hidden">로그인메뉴</h3>
         <ul id="loginmenu" class="block_hlist">
            <li><a href="../index.jsp">HOME</a></li>
            <li>
            <!-- 다른 페이지 에서는 안보여짐 다른 페이지 에서도 넣어 줘야함 -> 페이지 집중화 필요 -->
            <c:if test="${empty pageContext.request.userPrincipal}">
                  <a href="../joinus/login">로그인</a>
               </c:if> 
               
               <c:if test="${not empty pageContext.request.userPrincipal}">
                  <a href="${ctxName}/j_spring_security_logout">${pageContext.request.userPrincipal.name}로그아웃</a>
               </c:if></li>
            
               <a href="../joinus/login">로그인</a>
                    <a href="${ctxName}/j_spring_security_logout"><security:authentication property="name"/>로그아웃</a>
               
               <security:authentication property="authorities" var="authorities"/>
               <c:forEach items="${authorities}" var="auth">
                  ${auth.authority}
               </c:forEach> --% ><%-- 권한정보
            </li>
            <li>
            <a href="../joinus/join.jsp">회원가입</a>
            </li>
         </ul>
         <h3 class="hidden">회원메뉴</h3>
         <ul id="membermenu" class="clear">
            <li><a href=""><img
                  src="../resource/images/menu-myPage.png" alt="마이페이지" /></a></li>
            <li><a href="notice.jsp"><img
                  src="../resource/images/menu-customer.png" alt="고객센터" /></a></li>
         </ul>
      </div>
   </div> --%>