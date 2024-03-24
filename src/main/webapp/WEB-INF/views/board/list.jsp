<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--헤더 파일 :list.jsp를 읽기전에 템플릿?을 먼저 불러옴 --%>
<%@ include file="../includes/header.jsp" %>
    
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-list-ul"></i> 게시판</h1>
                </div>

                <div id="searchArea" style="text-align:right; padding : 5px"><!-- 검색바 시작 -->

                    <form action="/board/search" method="get">

                            <table style="margin-left: 79%;">
                                <tr>
                                    <td><input type="text" class="form-control input-sm" name="searchWord" id="searchWord"></td>
                                    <td>
                                        <select name="type" style="color:inherit; background-color:transparent; transition:all .5s;">
                                            <option value="all">전체</option>
                                            <option value="title">제목</option>
                                            <option value="content">내용</option>
                                            <option value="writer">작성자</option>
                                        </select>
                                    </td>
                                    <td><button type="submit" class="btn btn-default">검색</button></td>
                                </tr>
                            </table>
                    </form>

                </div><!-- 검색바 끝 -->
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 목록(<a href="openRegister">게시글 작성</a>)


                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>글번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${boardList}" var="boardList">
                                        <tr>
                                            <td>${boardList.bno}</td>
                                            <td style="width: 60%;"><a href="/board/viewDetail/${boardList.bno}">${boardList.title}</a></td>
                                            <td>${boardList.writer}</td>
                                            <td><fmt:formatDate value="${boardList.regdate}" pattern="yyyy년MM월dd일"/> </td>
                                            <td><fmt:formatDate value="${boardList.updatedate}" pattern="yyyy년MM월dd일"/> </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <div style="display: flex; justify-content: center;">

                                <ul class="pagination">
                                    <c:if test="${notSearch}">

                                        <c:if test="${pagebar.prev}">
                                            <li class="pagenate_button">
                                                <a href="/board/list?pageNum=${pagebar.startPage-1}" >&lt;</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="${pagebar.startPage}" end="${pagebar.endPage}" var="num">
                                            <li class="pagenate_button ${pagebar.pageDTO.pageNum == num ? 'active' : ''}">
                                                <a href="/board/list?pageNum=${num}" >${num}</a>
                                            </li>
                                        </c:forEach>

                                        <c:if test="${pagebar.next}">
                                            <li class="pagenate_button">
                                                <a href="/board/list?pageNum=${pagebar.endPage+1}" >&gt;</a>
                                            </li>
                                        </c:if>

                                    </c:if>

                                    <c:if test="${search}">

                                        <c:if test="${pagebar.prev}">
                                            <li class="pagenate_button">
                                                <a href="/board/search?pageNum=${pagebar.startPage-1}&searchWord=${searchWord}&type=${type}" >&lt;</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="${pagebar.startPage}" end="${pagebar.endPage}" var="num">
                                            <li class="pagenate_button ${pagebar.pageDTO.pageNum == num ? 'active' : ''}">
                                                <a href="/board/search?pageNum=${num}&searchWord=${searchWord}&type=${type}">${num}</a>
                                            </li>
                                        </c:forEach>

                                        <c:if test="${pagebar.next}">
                                            <li class="pagenate_button">
                                                <a href="/board/search?pageNum=${pagebar.endPage+1}&searchWord=${searchWord}&type=${type}" >&gt;</a>
                                            </li>
                                        </c:if>

                                    </c:if>
                                </ul>
                            </div>



                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel panel-default -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    


<%--footer /.modal까지 읽고나서 스크립트 파일을넣어줌 --%>
<%@ include file="../includes/footer.jsp" %>

</body>

</html>
