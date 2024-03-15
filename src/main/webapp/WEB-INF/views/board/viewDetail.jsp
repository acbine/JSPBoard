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
                                <div class="col-lg-6" style="width: 100%">
                                    <div class="form-group" >
                                        <textarea  class="form-control" id="${boardDetail.bno}content"  readonly>${boardDetail.content}</textarea>
                                    </div>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->

                    <c:if test="${boardDetail.writer eq username}">
                        <button type="button" class="btn btn-danger"  id="${boardDetail.bno}delete" style="float: right;" onclick="location.href='/board/delete/${boardDetail.bno}';">삭제하기</button>
                        <button type="button" class="btn btn-warning" id="${boardDetail.bno}modify" style="float: right;" onclick="update()">수정하기</button>
                    </c:if>


                    </div>
                    <!-- /.panel -->
                    <sec:authorize access='isAnonymous()'>
                        안녕 로그인 안되면 보여야됨
                    </sec:authorize>

                    <sec:authorize access='isAuthenticated()'>
                        유저아이디:<sec:authentication property="principal.memberDTO.userName"/> 로그인 되면 보여야회
                    </sec:authorize>

                    <div id="2번">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-comments fa-fw"></i> 댓글창
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <ul class="timeline">
                                    <li>
                                        <div class="timeline-panel" style="width:100%">
                                            <div class="timeline-heading">
                                                작성자이름
                                                <small class="text-muted"><i class="fa fa-clock-o"></i> 날짜</small>
                                            </div>
                                            <div class="timeline-body">
                                                ㅁㅁㅁㅁ
                                            </div>
                                        </div>
                                    </li>
                                    <li class="timeline-inverted">
                                        <div class="timeline-panel" style="width:100%">
                                            <div class="timeline-heading" style="text-align: right;">
                                                <small class="text-muted"><i class="fa fa-clock-o"></i> 날짜</small>
                                                내가쓴글 작성자
                                            </div>
                                            <div class="timeline-body">
                                                ㅇㄹㄹㄹㄹㄹ
                                            </div>
                                        </div>
                                    </li>
                                </ul>

                                <sec:authorize access='isAuthenticated()'>
                                    <div class="panel-footer">
                                        <div class="input-group">
                                            <input id="btn-input" type="text" class="form-control input-sm" placeholder="댓글내용입력">
                                            <span class="input-group-btn">
                                                <button class="btn btn-warning btn-sm" id="btn-chat">
                                                    보내기
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </sec:authorize>




                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div> <!--2번-->





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
