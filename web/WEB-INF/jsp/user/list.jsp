<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        
        <c:forEach items="${userList}" var="user">
            <tr class="TableDetail1 template">
                <td>${user.loginname}&nbsp;</td>
                <td>${user.name}&nbsp;</td>
                <td>${user.department.name}&nbsp;</td>
                <td>
                	<c:forEach items="${user.positionSet}" var="position">
                		${position.name}&nbsp;
                	</c:forEach>
                	&nbsp;
                </td>
                <td>${user.description}&nbsp;</td>
                <td>
                	<a href="${pageContext.request.contextPath}/user_del?uid=${user.uid}" onclick="return delConfirm()">删除</a>
                    <a href="${pageContext.request.contextPath}/user_editUI?uid=${user.uid}">修改</a>
					<a href="${pageContext.request.contextPath}/user_initPassword?uid=${user.uid}" onclick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a>
                </td>
            </tr>
        </c:forEach>
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="user_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>

</body>
</html>
