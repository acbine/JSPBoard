<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--헤더 파일 :list.jsp를 읽기전에 템플릿?을 먼저 불러옴 --%>
<%@ include file="../includes/header.jsp" %>
    
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-list-ul"></i> 게시판</h1>
                </div>
                <div id="searchArea">
                    <!-- 검색바 시작 -->
                    <form action="/board/search" method="get">
                        <input type="text" name="searchWord" id="searchWord">
                        <select name="type">
                            <option value="all" >전체</option>
                            <option value="title"  >제목</option>
                            <option value="content"  >내용</option>
                            <option value="writer">작성자</option>
                        </select>
                        <button type="submit" class="btn btn-default">검색</button>
                    </form>
                    <!-- 검색바 끝 -->
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 목록 보기(<a href="openRegister">게시글 쓰기</a>)
                            sda
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


                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
                        <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">알림창</h4>
                                        </div>
                                        <div class="modal-body">
                                            aaaa
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->

<%--footer /.modal까지 읽고나서 스크립트 파일을넣어줌 --%>
<%@ include file="../includes/footer.jsp" %>

</body>

</html>
