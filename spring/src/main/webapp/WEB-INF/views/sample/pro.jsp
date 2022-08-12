<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Pro page</h2>

	<h3>model.addAttribute-view</h3>
	<h3>id :${id}</h3>
	<h3>pw :${pw}</h3>
	
	<h3>request.addAttribute-view</h3>
	<h3>id :${reqId}</h3>
	<h3>pw :${reqPw}</h3>
	
	<h3>dto.id : ${dto.id}</h3>
	<h3>dto.pw : ${dto.pw}</h3>
	
	<h3>sampleDTO: ${sampleDTO}</h3>
	<h3>sampleDTO.ID: ${sampleDTO.id}</h3>
</body>
</html>