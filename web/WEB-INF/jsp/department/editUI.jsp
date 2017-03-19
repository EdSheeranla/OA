<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>部门设置</title>
	<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	
	<!-- %{id==null? 'add' : 'edit'} -->
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>


<!--显示表单内容-->
<div id=MainArea>

    <s:form action="department_add">
    	<s:hidden name="did"></s:hidden>
        
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">上级部门</td>
                        <td><select name="parentid" class="SelectStyle">
                            <option value="">请选择部门</option>
                            <c:forEach items="${departmentList}" var="department">

                                    <c:if test="${empty department.parent.did}">

                                        <option value="${department.did}">┠${department.name}</option>

                                        <c:forEach items="${department.children}" var="child">
                                            <option value="${child.did}">　┠${child.name}</option>
                                        </c:forEach>

                                    </c:if>

                                </c:forEach>

                            </select>
                        </td>
                    </tr>
                    <tr><td>部门名称</td>
                        <td><textarea name="name" class="InputStyle"> ${editDepartment.name}</textarea></td>
                    </tr>
                    <tr><td>职能说明</td>
                        <td><textarea name="description" class="TextareaStyle">${editDepartment.description}</textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>

</body>
</html>