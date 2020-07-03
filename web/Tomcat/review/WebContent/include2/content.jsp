<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table>
<tr>
<td>이름</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>
<label>직업</label>
</td><td>
<select name="job">
<option value="시스템엔지니어">시스템엔지니어</option>
<option value="프로그래머">프로그래머</option>
<option value="디자이너">디자이너</option>
</select>
</td>
</tr>
<td>관심사항</td>
<td>
java<input type="checkbox" name="like" value="java">
HTML5<input type="checkbox" name="like" value="HTML5">
css3<input type="checkbox" name="like" value="css3">
javascript<input type="checkbox" name="like" value="javascript">
JSP<input type="checkbox" name="like" value="JSP">
</td>
</tr>
<tr>
<td><input type="submit" value="보내기"></td>
<td><input type="reset" value="초기화"></td>
</tr>
</table>