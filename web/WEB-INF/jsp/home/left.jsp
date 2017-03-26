<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>导航菜单</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
    <link type="text/css" rel="stylesheet" href="style/blue/menu.css"/>

    <script type="text/javascript">
        function menuClick(menuDiv) {
            // $(".MenuLevel2").not( $(menuDiv).next() ).hide();
            $(menuDiv).next().toggle(); // show(), hide(), toggle()
        }
    </script>

</head>
<body style="margin: 0">
<div id="Menu">

    <ul id="MenuUl">
        <%-- 顶级菜单 --%>
        <c:forEach items="${allUserPrivilegeList}" var="userPrivilege">
            <c:if test="${empty userPrivilege.parent}" >
            <%--<s:if test="#session.user.hasPrivilegeByName(name)">--%>
            <li class="level1">
                <div onClick="menuClick(this);" class="level1Style">
                    <img src="style/images/MenuIcon/${userPrivilege.icon}" class="Icon"/>
                        ${userPrivilege.name}
                </div>
                    <%-- 二级菜单 display: none; --%>
                <ul style="" class="MenuLevel2">
                    <c:forEach items="${userPrivilege.children}" var="secondPrivilege">
                        <%--<s:if test="#session.user.hasPrivilegeByName(name)">--%>
                        <li class="level2">
                        <div class="level2Style" onClick="menuClick(this);">
                            <img src="style/images/MenuIcon/menu_arrow_single.gif"/>
                            <a target="right"
                               href="${pageContext.request.contextPath}/${secondPrivilege.url}.action"> ${secondPrivilege.name}</a>
                        </div>
                        <%--增加三级菜单--%>
                        <%--<c:forEach items="${secondPrivilege.children}" var="thirdPrivilege">--%>
                            <%--<li>--%>
                                <%--<div>--%>
                                    <%--<img src="style/images/MenuIcon/menu_arrow_single.gif"/>--%>
                                    <%--<a target="right"--%>
                                       <%--href="${pageContext.request.contextPath}${thirdPrivilege.url}.action"> ${thirdPrivilege.name}</a>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                        </li>
                        <%--</s:if>--%>
                    </c:forEach>
                </ul>
            </li>
            <%--</s:if>--%>
            </c:if>
        </c:forEach>
    </ul>

</div>
</body>
</html>