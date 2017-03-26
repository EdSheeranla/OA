<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>岗位列表</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript"
            src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/file.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css"/>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <!-- 表单内容显示 -->
    <s:form action="position_savePrivilege.action" method="post">
    <s:hidden name="pid"></s:hidden>
    <div class="ItemBlockBorder">
        <div class="ItemBlock">
            <table cellpadding="0" cellspacing="0" class="mainForm">
                <!--表头-->
                <thead>
                <tr align="LEFT" valign="MIDDLE" id="TableTitle">
                    <td width="300px" style="padding-left: 7px;">
                        <!-- 全选 -->
                        <input type="checkbox" id="cbSelectAll"
                               onClick="$('[name=privilegeIds]').attr('checked', this.checked)"/>
                        <label for="cbSelectAll">全选</label>
                    </td>
                </tr>
                </thead>

                <!--显示数据列表-->
                <tbody id="TableData">
                <tr class="TableDetail1">
                    <!-- 显示权限树 -->
                    <td>
                            <%--使用树状结构来显示权限分配--%>
                                <ul id="root">
                                        <%-- 第一级 --%>
                                    <s:iterator value="#topPrivilegeList">
                                        <li>

                                            <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                                            <label for="cb_${id}"><span class="folder">${name}</span></label>
                                            <ul>
                                                    <%-- 第二级 --%>
                                                <s:iterator value="children">
                                                    <li>
                                                        <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                                                        <label for="cb_${id}"><span class="folder">${name}</span></label>
                                                        <ul>
                                                                <%-- 第三级 --%>
                                                            <s:iterator value="children">
                                                                <li>
                                                                    <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                                                                    <label for="cb_${id}"><span class="folder">${name}</span></label>
                                                                </li>
                                                            </s:iterator>
                                                        </ul>
                                                    </li>
                                                </s:iterator>
                                            </ul>
                                        </li>
                                    </s:iterator>
                                </ul>

                    </td>
                </tr>
                </tbody>
            </table>
            <div id="InputDetailBar">
                <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
                <a href="javascript:history.go(-1);"><img
                        src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
            </div>
            </s:form>
            <s:debug/>
        </div>
    </div>
</div>


<div class="Description">
    说明：<br/>
    1，选中一个权限时：<br/>
    &nbsp;&nbsp;&nbsp;&nbsp; a，应该选中他的所有直系上级。<br/>
    &nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br/>
    2，取消选择一个权限时：<br/>
    &nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择他的所有直系下级。<br/>
    &nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并向上做这个操作。<br/>

    3，全选/取消全选。<br/>
    4，默认选中当前岗位已有的权限。<br/>
</div>

<%--当选中父级权限时候，级联选中子权限--%>
<script>
    <%--控制js代码当文档加载完成之后在开始进行加载--%>
    $(function () {
        $("#root").treeview()
    });
    $(function () {
        $("[name=privilegeIds]").click(function () {
            $(this).siblings("ul").find("input").attr("checked", this.checked);
            if (this.checked) {
                $(this).parents("li").children("input").attr("checked", true);
                //取消某一个元素的时候，需要进行判断，是否还有同级元素被选中，否则直接上级元素取消选中
            } else {
                if ($(this).parent().siblings("li").children("input:checked").size() == 0) {
                    $(this).parent().parent().siblings("input").attr("checked", false);
                    var start = $(this).parent().parent();

                    if (start.parent().siblings("li").children("input:checked").size() == 0) {
                        start.parent().parent().siblings("input").attr("checked", false);
                    }
                }
            }

        });
    });

</script>
</body>
</html>
