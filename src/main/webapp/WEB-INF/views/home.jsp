<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수업 양식 생성기</title>
<style type="text/css">
	label{
		width: 50vw;
		display: inline-block;
		margin-bottom: 10px;
		padding:0;
	}
	input,select{
		width: 50vw;
		margin-bottom: 10px;
		padding:0;
	}
	body
	{
		    height: 98vh;
	    display: flex;
	    overflow: hidden;
	    min-height: 250px;
	    flex-direction: column;
	    align-items: center;
	}
	h1{
		display: block;
	}
	textarea {
		width: 50vw;
		padding:0;
		height:30px;
		margin-bottom: 10px;
	}
	button{
		width: 30vw;
		padding:0;
		margin-bottom: 10px;
		margin-left: 10vw;
	}

</style>
</head>
<body>
<h1>이벤트 양식</h1>
<form action="/event" method="post">
	<label>제목</label><br><input type="text" name="title"><br>
	<label>내용(하고싶은 말)</label><br><textarea name="content"></textarea><br>
	<label>이벤트 바나나 갯수</label><br><input type="text" value="100" name="banana"><br>
	<label>1번에 들어갈 리트, 인용 여부</label><br>
	<select name="rt">
		<option value="아래 링크 RT(인용X)">리트윗</option>
		<option value="아래 트윗 인용">인용</option>
	</select><br>
	<label>태그가 있다면</label><br><input type="text" name="tag"><br>
	<label>2번에 들어갈 댓글, 트윗으로 작성을 원하는 내용</label><br><input type="text" name="reply"><br>
	<label>트윗 주소</label><br><input type="text" name="addr"><br><br>
	<button type="submit">전송</button>
</form>

</body>
</html>