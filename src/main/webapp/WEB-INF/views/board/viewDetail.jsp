<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--헤더 파일 넣기 --%>    
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" id="${boardDetail.bno}title">${boardDetail.title}</h1>
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
                                    <div class="form-group" style="width: 100%" >
                                        <textarea class="form-control" id="${boardDetail.bno}content"  readonly>${boardDetail.content}</textarea>
                                    </div>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->


                    </div>
                    <!-- /.panel -->
                    <c:if test="${boardDetail.writer eq username}">
                        <button type="button" class="btn btn-danger"  id="${boardDetail.bno}delete" style="float: right;" onclick="location.href='/board/delete/${boardDetail.bno}';">삭제하기</button>
                        <button type="button" class="btn btn-warning" id="${boardDetail.bno}modify" style="float: right;" onclick="update()">수정하기</button>
                    </c:if>
                    ㅁㅇㄴㅁㅇ:${username}





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
    
<script>
    function cancel(){
        console.log("취소버튼클릭");
        $("#${boardDetail.bno}title").replaceWith("<h1 class='page-header' id='${boardDetail.bno}title'>${boardDetail.title}</h1>")
        $("#${boardDetail.bno}content").attr("readonly", "readonly");
        $("#${boardDetail.bno}cancel").replaceWith("<button type='button' class='btn btn-danger'  id='${boardDetail.bno}delete' style='float: right;' onclick=\"location.href='/board/delete/${boardDetail.bno}';\">삭제하기</button>");
        $("#${boardDetail.bno}send").replaceWith("<button type='button' class='btn btn-warning' id='${boardDetail.bno}modify' style='float: right;' onclick='update()'>수정하기</button>");
    }

    function send(){
        console.log("전송버튼클릭")

        var aaa=$('#${boardDetail.bno}title').val();
        var bbb=$("#${boardDetail.bno}content").val();
        var ccc = ${boardDetail.bno};

        $.ajax({
            url: '/board/update?bno='+ccc+'&title='+aaa+'&content='+bbb,
            method: 'get',
            success: function(response) {
                location.reload();
            },
            error: function(error) {
            }
        });

        console.log(aaa);
        console.log(bbb);
        console.log(ccc);
    }


    function update() {
            console.log("수정버튼클릭");
            $("#${boardDetail.bno}title").replaceWith("<textarea class='form-control' id='${boardDetail.bno}title'>${boardDetail.title}</textarea>");
            $("#${boardDetail.bno}content").removeAttr("readonly");
            $("#${boardDetail.bno}delete").replaceWith("<button type='button' class='btn btn-success'  id='${boardDetail.bno}cancel' onclick='cancel()' style='float: right;'>취소</button>");
            $("#${boardDetail.bno}modify").replaceWith("<button type='button' class='btn btn-info'  id='${boardDetail.bno}send' onclick='send()' style='float: right;'>수정완료</button>");
    }


</script>


</body>

</html>
