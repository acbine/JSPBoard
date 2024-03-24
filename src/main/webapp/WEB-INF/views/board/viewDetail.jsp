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
                            <div style="text-align : right; margin-bottom: 5px; ">
                                <c:if test="${boardDetail.writer eq username}">
                                    <button type="button" class="btn btn-warning" id="${boardDetail.bno}modify"  onclick="update()">수정하기</button>
                                    <button type="button" class="btn btn-danger"  id="${boardDetail.bno}delete"  onclick="location.href='/board/delete/${boardDetail.bno}';">삭제하기</button>
                                </c:if>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->

                    <div id="2번">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-comments fa-fw"></i> 댓글창
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <ul id="replyUl" class="timeline">

                                </ul>

                                <sec:authorize access='isAuthenticated()'>
                                    <div class="panel-footer">
                                        <div class="input-group">
                                            <input id="btn-input" type="text" class="form-control input-sm" placeholder="댓글내용입력">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" readonly/>
                                            <span class="input-group-btn">
                                                <button class="btn btn-warning btn-sm" id="btn-chat" onclick="replysend()">
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

        var aaa = $('#${boardDetail.bno}title').val();
        var bbb = $("#${boardDetail.bno}content").val();
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
    //게시글용 스크립트 끝
</script>



<script>
    //댓글용 스크립트 시작
    var ddd = "${boardDetail.bno}";
    var eee = "${boardDetail.writer}"; //

    document.addEventListener("DOMContentLoaded", function() {
        refreshReplyList();
    });

    function replyList(){ //유저 데이터와 리플 데이터 불러오는 함수
        $.ajax({
            url: '/board/replyList?bno='+ddd,
            method: 'get',
            success: function(response) {
                $.ajax({
                        url: '/board/userData',
                        method: 'get',
                        success: function(userData) {
                            //console.log(userData);
                            //console.log(userData.userName);

                            for(var i=0; i<response.length; i++){
                                var li = $("<li>"); // li 요소
                                var timeLinePanel = $("<div>").addClass("timeline-panel").css("width", "100%"); //div판낼

                                if(userData.userName != response[i].replywriter ){
                                    var timeLineHeading = $("<div>").addClass("timeline-heading"); //divhead생성
                                }else{
                                    var timeLineHeading = $("<div>").addClass("timeline-heading").css("text-align", "right"); //divhead생성
                                }
                                //console.log(response[i]);

                                timeLineHeading.append(response[i].replywriter); //헤드div 에 작성자 추가

                                var small = $("<small>").addClass("text-muted"); //small? 생성
                                var clockIcon = $("<i>").addClass("fa fa-clock-o");
                                small.append(clockIcon);

                                var dateString = response[i].replyDate;
                                var date = new Date(dateString); //기록된시간

                                var koreanOffset = 9 * 60*60000; // 한국 UTC+9시간 60분 60000밀리세컽드
                                var koreanDate = new Date(date.getTime() + koreanOffset);// 기록된시간을 UTC 기준으로 미리세컨드

                                var formattedDate = koreanDate.toISOString().slice(0, 16).replace("T", " ");
                                small.append(formattedDate);//small요소에 작성일추가

                                timeLineHeading.append(small); //헤드div 안에 small요초추가

                                var timeLineBody = $("<div>").addClass("timeline-body"); // 바디div 생성
                                var replyContentDiv = $("<div>").attr("id", response[i].rno+"div");

                                timeLineBody.append(replyContentDiv)// 바디div안에 contentDiv추가
                                replyContentDiv.append(response[i].replycontent)// 리플div안에 댓글내용추가

                                if(userData.userName == response[i].replywriter ){
                                    var btnDiv = $("<div>").css("text-align", "right");
                                    var updateBtn = $("<button>").addClass("btn btn btn-warning").text("수정").attr("id", response[i].rno+"updateBtn");
                                    var deleteBtn = $("<button>").addClass("btn btn-danger").text("삭제").attr("id", response[i].rno+"deleteBtn");

                                    updateBtn.on("click", function() {
                                        var clickUpdate = event.target;

                                        console.log(clickUpdate.getAttribute('id')+"수정 버튼클릭");

                                        var clickUpdateID = clickUpdate.getAttribute('id');
                                        var splitUpdateID = clickUpdateID.split("updateBtn");


                                        console.log(splitUpdateID[0]+"아이디는?");

                                        changInputBox(splitUpdateID[0])
                                        //$("#"+splitUpdateID[0]+"div").replaceWith("<input type='text' id="+splitUpdateID[0]+"input>");






                                        console.log("완료");
                                    });

                                    deleteBtn.on("click", function() {
                                        var click = event.target;
                                        console.log(click.getAttribute('id')+"삭제버튼클릭");
                                        var clickDeleteID = click.getAttribute('id');
                                        var splitID = clickDeleteID.split("deleteBtn");
                                        console.log(clickDeleteID.split("deleteBtn"));//무한루프걸림

                                        replyDelete(splitID[0]);


                                    });

                                    btnDiv.append(updateBtn);
                                    btnDiv.append(deleteBtn);

                                    timeLineBody.append(btnDiv);
                                }

                                timeLinePanel.append(timeLineHeading);                                                            //판낼 div 안에 head랑 body 추가
                                timeLinePanel.append(timeLineBody);

                                li.append(timeLinePanel);

                                $("#replyUl").append(li);
                            }
                        }, //유저정보
                        error: function(error) {
                        }
                    });

            },   //댓글정보
            error: function(error) {
                console.log("오류발생");
            }
        });
    }

    function replysend(){ // 댓글 전송
        var inputReplycontent=$("#btn-input").val();
        var csrfToken=$("#csrfToken").val();
        $.ajax({
                url: '/board/userData',
                method: 'get',
                success: function(userData) {
                    //console.log(ddd);
                    $.ajax({
                        url: '/board/replyRegister',
                        method: 'post',
                        data:{
                            bno: ddd, // 전송할 데이터 (객체 형태로 전달)
                            replywriter: userData.userName,
                            replycontent: inputReplycontent,
                            _csrf:csrfToken
                        },
                        success: function(data) {
                            $("#btn-input").val("");
                            refreshReplyList();
                        },
                        error: function(error) {
                        }
                    });
                },
                error: function(error) {
                }
        });
    }

function refreshReplyList() { //댓글을 새로고침하는 함수
    $("#replyUl").empty(); //삭제하고
    replyList();   //다시만듬
}

function replyDelete(rno,csrfToken){ //댓글을 삭제하는 함수
    var csrfToken=$("#csrfToken").val();
    console.log("ajax있는 삭제 발생"+rno);
    $.ajax({
        url: '/board/replyDelete?rno='+rno,
        method: 'post',
        data:{
            _csrf:csrfToken
        },
        success: function(detetdata) {
            refreshReplyList();
            console.log("삭제 신호 잘보낸 ");
        },
        error: function(error) {
        }
    });
}

function changInputBox(upDateRno){ //클릭된것
    console.log(upDateRno+"div을 input으로 바꾸는 함수 실행됨");
    $("#"+upDateRno+"div").replaceWith("<input type='text' id="+upDateRno+"input requierd>");
    $("#"+upDateRno+"updateBtn").replaceWith("<button type='button' class='btn btn-info'  id='"+upDateRno+"replySend' onclick='replyUpdateSend("+upDateRno+")' '>수정완료</button>");
    $("#"+upDateRno+"deleteBtn").replaceWith("<button type='button' class='btn btn-success'  id='"+upDateRno+"replyCancel' onclick='replyCancel("+upDateRno+")' '>취소</button>");
}

function replyUpdateSend(upDateRno){
    var csrfToken=$("#csrfToken").val(); // 토큰 값이 비워졌더니 무한루프 발생
    var updatedReply = $("#"+upDateRno+"input").val();
    console.log("댓글수정한내용"+updatedReply); //잘됨
    $.ajax({
        url: '/board/replyUpdate',
        method: 'post',
        data:{
            rno: upDateRno, // 전송할 데이터 (객체 형태로 전달)
            replycontent: updatedReply,
            _csrf:csrfToken
        },
        success: function(data) {
            refreshReplyList();
        },
        error: function(error) {
        }
    });
}


function replyCancel(upDateRno){
    console.log("댓글취소");
    refreshReplyList();
}





</script>
</body>

</html>
