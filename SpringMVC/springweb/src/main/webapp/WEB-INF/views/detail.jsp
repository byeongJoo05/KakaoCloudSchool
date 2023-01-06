<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
	<div align='center' class='body'>
		<h2>상세 보기</h2>
		<table>
			<tr>
				<td><img src="../img/${item.pictureurl }"/></td>
				<td align="center">
					<table>
						<tr height="50">
						<td width="80">상품명</td>
						<td width="160">${item.itemid}</td>
						</tr>
						<tr height="50">
						<td width="80">가격</td>
						<td width="160">${item.price}</td>
						</tr>
						<tr height="50">
						<td width="80">비고</td>
						<td width="160">${item.description}</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center" width="240">
							<a href="../">목록으로</a></td>
						</tr>
					</table>
					</td>
			</tr>
		</table>
	</div>
</body>
</html>