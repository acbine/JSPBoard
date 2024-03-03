<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--헤더 파일 넣기 --%>    
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${boardDetail.title}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <table>
                                <td style="width: 77%;">작성자:${boardDetail.writer}</td>
                                <td>  수정일: <fmt:formatDate value="${boardDetail.updatedate}" pattern="yyyy년MM월dd일"/>  </td>
                            </table>
                        </div>


                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <textarea class="form-control" style="width: 200%" readonly>${boardDetail.content}</textarea>
                                    </div>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->


                    </div>
                    <!-- /.panel -->
                    <button type="button" class="btn btn-danger" style="float: right;" onclick="window.location.href='/board/delete/${boardDetail.bno}';">삭제하기2</button>
                    <button type="button" class="btn btn-warning" style="float: right;">수정하기2</button>
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
