<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    <%--헤더파일 넣기 --%>
    <%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 쓰기
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6" style="width: 100%">
                                    <form role="form" action="/board/register" method="post"  accept-charset="UTF-8">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" placeholder="제목 입력" name="title" required>
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="작성자 입력"  name="writer" value="<sec:authentication property='principal.memberDTO.userName' />" readonly>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>내용 입력</label>
                                            <textarea class="form-control" rows="5" placeholder="내용 입력" name="content" required></textarea>
                                        </div>
                                        <input type="text" name="${_csrf.parameterName}" value="${_csrf.token}" readonly/> <!--스프링 세큐리티 포스트 요청시 필요-->
                                        <div >
                                            <button type="submit" class="btn btn-default">등록</button>
                                            <button type="reset" class="btn btn-default">초기화</button>
                                        <div>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
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

<%--footer /.modal까지 읽고나서 스크립트 파일을넣어줌 --%>
<%@ include file="../includes/footer.jsp" %>

</body>

</html>
