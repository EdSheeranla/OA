<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Itcast OA</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
    <link href="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet>
    <script type="text/javascript">
        $(function () {
            document.forms[0].loginName.focus();
        });
    </script>
</head>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 class=PageBody>


<!-- 显示表单 -->

<div id="CenterAreaBg">
    <div id="CenterArea">
        <div id="LogoImg"><img border="0" src="/oa/style/blue/images/logo.png"/>
        </div>
        <div id="LoginInfo">
            <form action="${pageContext.request.contextPath}/user_login.action" method="post">
                <table BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <tr>
                        <td colspan="3"><!-- 显示错误 -->
                            <font color="red"></font>
                        </td>
                    </tr>
                    <tr>
                        <td width=45 class="Subject"><img border="0"
                                                          src="/oa/style/blue/images/login/userId.gif"/>
                        </td>
                        <td>
                    <tr>
                        <td class="tdLabel"></td>
                        <td
                        ><input type="text" name="loginname" size="20" value="" tabindex="1" id="loginNameInput" class="TextField required"/></td>
                    </tr>


                    </td>
                    <td rowspan="2" style="padding-left:10px;">
                        <input type="image" tabindex="3"
                               src="/oa/style/blue/images/login/userLogin_button.gif"/>
                    </td>
                    </tr>
                    <tr>
                        <td class="Subject"><img border="0"
                                                 src="/oa/style/blue/images/login/password.gif"/>
                        </td>
                        <td><tr>
                    <td class="tdLabel"></td>
                    <td
                    ><input type="password" name="password" size="20" tabindex="2" id="aa" class="TextField required"/></td>
                </tr>

                    </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="CopyRight"><a href="javascript:void(0)">&copy;2017 版权所有 itcast</a></div>
    </div>
</div>


</body>

</html>

