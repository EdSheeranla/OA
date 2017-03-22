<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/3/21
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <base href="http://hfutspk.hfut.edu.cn:80/">
    <title></title>
    <meta http-equiv="keywords" content=""/>
    <meta http-equiv="description" content=""/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/skin/css/student.css" type="text/css">
    <script src="/js/common.js" type="text/javascript"></script>
    <script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
    <script src="/js/jquery.form.js" type="text/javascript"></script>
    <script src="/js/jquery.validate.pack.js" type="text/javascript"></script>
    <script src="/js/jquery.validate.custom.js" type="text/javascript"></script>
    <script type="text/javascript" src="/js/jquery.bgiframe.js"></script>
    <script type="text/javascript" src="/js/jquery.myAlert.js"></script>
    <script type="text/javascript" src="/js/jquery.pngFix.pack.js"></script>

    <script type="text/javascript">
        if (top.location != self.location) {
            top.location = self.location;
        }
        if ('' != '') {
            alert('');
        }
        String.prototype.trim = function () {
            return this.replace(/(^[\s]*)|([\s]*$)/g, "");
        }

        $(document).ready(function () {
            if ('false' == 'false') {
                $("#bdshareside").hide();
                $("#bdshareClose").hide();
                $("#bdshareOpen").show();
            }
        });

        function closeResource() {
            setResourceWebsite(false);
            $("#bdshareside").hide();
            $("#bdshareClose").hide();
            $("#bdshareOpen").show();
        }

        function openResource() {
            setResourceWebsite(true);
            $("#bdshareside").show();
            $("#bdshareClose").show();
            $("#bdshareOpen").hide();
        }

        function setResourceWebsite(isShow) {
            $.ajax({
                url: '/student/resourceWebsite.do?1490104334217&isShow=' + isShow, //后台处理程序
                type: 'post',         //数据发送方式
                dataType: 'json',     //接受数据格式
                success: function (result) {
                }
            });
        }
    </script>

    <style type="text/css">
        #bdshareside {
            position: fixed;
            right: 2px;
            top: 240px;
            width: 171px;
            height: 243px;
            z-index: 1024;
            background: url("/skin/images/student/bdshare.png") no-repeat;
        }

        #bdshare {
            float: left;
            font: 13px '黑体';
            text-align: center;
            z-index: 999999;
        }

        #bdshareClose {
            position: fixed;
            right: 171px;
            top: 266px;
            width: 16px;
            height: 16px;
            z-index: 1024;
            background: url("/skin/images/student/bdshare_r.png") no-repeat;
            cursor: pointer;
        }

        #bdshareOpen {
            position: fixed;
            right: 2px;
            top: 266px;
            width: 16px;
            height: 16px;
            z-index: 1024;
            background: url("/skin/images/student/bdshare_l.png") no-repeat;
            cursor: pointer;
            display: none;
        }

        #bdshare ul {
            margin: 42px 0 0 25px;
            overflow: hidden;
            width: 130px;
            list-style-type: none;
        }

        #bdshare ul li {
            cursor: pointer;
            height: 18px;
            line-height: 18px;
            margin-bottom: 6px;
        }

        #bdshare ul li:hover {
            color: #FFFFFF;
            background-color: #0d819a;
        }
    </style>
</head>

<body>
<div id="wrap">
    <!--新公告显示-->


    <!--顶部开始-->


    <script type="text/javascript">
        $(document).ready(function () {
            $(".mainNavLi").mouseover(function () {
                $(this).children(".subNav").show();
                $(".mainNavLi").mouseout(function () {
                    $(this).children(".subNav").hide();
                });
            });
        });

        function exit() {
            return confirm("确定要退出？");
        }
    </script>

    <script>document.title = "合肥工业大学课程学习中心"</script>
    <div id="header">
        <div class="top"></div>
        <div class="content">
            <span class="logoTitle"><img src="/skin/images/student.png" style="float: left;"/></span>
            <div class="right" style="width: 500px;">
                <ul>


                    <li><a href="javascript:void(0)" class="head_btn"
                           onclick="window.open('http://wpa.qq.com/msgrd?v=3&uin=2368145705&site=qq&menu=yes');return false;">技术支持</a>
                    </li>


                    <li><a href="/index.do?1490104334217&" class="head_btn">更多课程</a></li>
                </ul>
                <br/>
                <div class="bottom">
                    当前用户：2014214114 &nbsp;&nbsp; 姓名： 黄健勇 &nbsp;&nbsp;
                    【<a href="/student/personalInfoEdit.do?1490104334217&method=edit">个人设置</a>】
                    【<a href="/exit.do?1490104334217&" onclick="return exit();">退出</a>】
                </div>
            </div>
        </div>
    </div>


    <div id="nav">
        <div class="content">
            <ul class="mainNav">
                <li class="mainNavLi" onclick="javascript:window.location.href='/student/index.do?1490104334217&'">
                    个人主页
                </li>


                <li class="mainNavLi" style="cursor: default;">
                    本期课程<img style="margin-left: 2px;" alt="" src="/skin/images/navigate/nav_icon_white.png"/>
                    <ul class="subNav">

                        <li onclick="javascript:window.location.href='/student/teachingTask/coursehomepage.do?1490104334217&courseId=7'">

                            <span title="六大名著导读">六大名著导读</span>
                        </li>

                        <li onclick="javascript:window.location.href='/student/teachingTask/coursehomepage.do?1490104334217&courseId=8'">

                            <span title="诗意人生五典型">诗意人生五典型</span>
                        </li>


                    </ul>
                </li>


                <li class="mainNavLi" style="cursor: default;">
                    学习档案<img style="margin-left: 2px;" alt="" src="/skin/images/navigate/nav_icon_white.png"/>
                    <ul class="subNav">

                        <li onclick="javascript:window.location.href='/student/history/index.do?1490104334217&termId=117'">

                            <span title="">2016-2017-1</span>
                        </li>

                        <li onclick="javascript:window.location.href='/student/history/index.do?1490104334217&termId=118'">

                            <span title="">2016-2017-2</span>
                        </li>

                    </ul>
                </li>


            </ul>
        </div>
    </div>
    <!--顶部结束-->

    <!--主内容开始-->
    <div id="container" class="container">
        <div class="content_bg">


            <script type="text/javascript">
                <!--
                var hasFlash = 0;         //是否安装了flash
                var version = new Array();//flash当前客户端版本
                var standVersion = new Array("10");//需要安装的flashplayer最低版本

                if (document.all) {
                    try {
                        var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
                        if (swf) {
                            hasFlash = 1;
                            VSwf = swf.GetVariable("$version");
                            version = VSwf.split(" ")[1].split(",");
                        }
                    } catch (t) {
                    }
                } else {
                    if (navigator.plugins && navigator.plugins.length > 0) {
                        var swf = navigator.plugins["Shockwave Flash"];
                        if (swf) {
                            hasFlash = 1;
                            var words = swf.description.split(" ");

                            var splitword = new Array();
                            splitword = words[2].split(".");
                            version[0] = splitword[0];
                        }
                    }
                }

                if (hasFlash) {
                    var flag = false;
                    if (!isNaN(parseInt(version[0])) && !isNaN(parseInt(standVersion[0]))) {
                        if (parseInt(version[0]) >= parseInt(standVersion[0])) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        alert("系统检测到您的计算机安装的flashPayer版本过低,请按照说明下载并安装flash插件,安装时请先关闭浏览器！");
                        redirectHelpPage();
                    }
                } else {
                    alert("您还没有安装flashPlayer，请按照说明下载并安装flash插件，安装时请先关闭浏览器！");
                    redirectHelpPage();
                }

                function redirectHelpPage() {
                    document.location.replace("/html/adobeflashplay.jsp");
                }
                //-->
            </script>


            <link rel="stylesheet" href="/skin/css/video.css" type="text/css">

            <script type="text/javascript">
                var showAlertSeconds = 30;
                var currentSeconds = 0;
                var infoHtml;
                var timer;
                var timerRecord;
                var result;
                var popupTimeArray = new Array();
                var playTimeInterval;

                $(document).ready(function () {
                    if (false) {
                        popupAlertDivToAssignment(760, 505);
                    }
                    if (false) {
                        return;
                    }
                    for (var i = 0; i < 2; i++) {
                        var alertTime = Math.round(Math.random() * (3254 - 1 - 1.0) + 1.0);
                        popupTimeArray[i] = alertTime;
                    }
                    popupTimeArray.sort(function (a, b) {
                        return a - b;
                    });
                    timerRecord = setInterval("recordTime()", 1000);
                    playTimeInterval = setInterval("savePlayTime()", 120 * 1000);
                });

                function toAssignment() {
                    if (false) {
                        window.location.href = "/student/assignment/manageAssignment.do?1490104334217&method=reDoAssignment&assignmentId=0";
                    } else {
                        window.location.href = "/student/assignment/manageAssignment.do?1490104334217&method=doAssignment&assignmentId=0";
                    }
                }

                var currentTime = 1.0;
                var currentAlertIndex = 0;
                function recordTime() {
                    var currentPlayTime = getCurrentPlayTime();

                    if (currentPlayTime >= 3254 - 1) {
                        savePlayTime();

                        clearInterval(timerRecord);
                    }
                    if (!isPlay()) {
                        return;
                    }
                    var currentPlayTime = getCurrentPlayTime();

                    if (currentPlayTime <= currentTime) {
                        return;
                    }

                    if (currentPlayTime - currentTime > 5) {
                        playerSeek(currentTime);
                        return;
                    }
                    currentTime = currentPlayTime;
                    if (currentTime < 3254) {
                        if (currentAlertIndex < popupTimeArray.length) {
                            if (popupTimeArray[currentAlertIndex] <= currentTime) {
                                rirkoi(760, 505);
                                currentAlertIndex++;
                            }
                        }
                    } else if (currentTime >= 3254) {
                        clearInterval(timerRecord);
                        clearInterval(playTimeInterval);
                    }
                }

                function popupAlertDivToAssignment(width, height) {
                    document.getElementById("assignmentInfo").innerHTML = "";
                    var alertWidth = 300;
                    var alertHeight = 150;

                    var maskDiv = document.getElementById("maskDiv");
                    maskDiv.style.width = width + "px";
                    maskDiv.style.height = height + "px";
                    maskDiv.style.display = "block";
                    var alertDiv = document.getElementById("alertDiv");
                    alertDiv.innerHTML = document.getElementById("toAssignmentDiv").innerHTML;
                    alertDiv.style.width = alertWidth + "px";
                    alertDiv.style.height = alertHeight + "px";
                    var marginTop = (height - alertHeight) / 2;
                    var marginLeft = (width - alertWidth) / 2;
                    alertDiv.style.margin = marginTop + "px 0 0 " + marginLeft + "px";
                    alertDiv.style.display = "block";
                }

                function cancel() {
                    document.getElementById("alertDiv").style.display = "none";
                    document.getElementById("maskDiv").style.display = "none";
                }

                function rirkoi(width, height) {
                    var currentPlayTime = getCurrentPlayTime();
                    if (!isPlay() || popupTimeArray[currentAlertIndex] > currentPlayTime) {
                        return;
                    }
                    setToNormalScreen();
                    playerPause();
                    var alertWidth = 300;
                    var alertHeight = 150;
                    result = "";

                    var maskDiv = document.getElementById("maskDiv");
                    maskDiv.style.width = width + "px";
                    maskDiv.style.height = height + "px";
                    maskDiv.style.display = "block";

                    var alertDiv = document.getElementById("alertDiv");
                    infoHtml = document.getElementById("infoDiv").innerHTML;
                    setInfoHtml(showAlertSeconds, "", "保存");
                    alertDiv.style.width = alertWidth + "px";
                    alertDiv.style.height = alertHeight + "px";
                    var marginTop = (height - alertHeight) / 2;
                    var marginLeft = (width - alertWidth) / 2;
                    alertDiv.style.margin = marginTop + "px 0 0 " + marginLeft + "px";
                    alertDiv.style.display = "block";

                    currentSeconds = showAlertSeconds;
                    timer = setInterval("second()", 1000);
                }
                setInterval("uqyxq()", 1000);

                function second() {
                    if (currentSeconds > 0) {
                        setInfoHtml(--currentSeconds, "", "保存");
                    } else {
                        clearInterval(timer);
                        result = "timeout";
                        //ajax保存过期题目
                        $.ajax({
                            async: false,
                            type: "POST",
                            url: "/student/assignment/manageAssignment.do?1490104334217&method=saveExercise",
                            data: "examId=1436&saveExpire=true",
                            dataType: "json",
                            success: function (result) {
                                if (result.status == 'ok' || result.status == "invalid") {
                                } else {
                                    $("#unSaveExerciseListUL").append("<li><font color=\"#CDCBCC\">&gt;</font>第" + result.index + "题</li>");
                                    $('#reWatchHelp').show();
                                    $('#reWatchBtn').show();
                                }
                            },
                            error: function () {
                            }
                        });
                        document.getElementById("alertDiv").style.display = "none";
                        document.getElementById("maskDiv").style.display = "none";

                        playerPlay();
                    }
                }

                function save() {
                    clearInterval(timer);
                    setInfoHtml(currentSeconds, "disabled=true", "保存中....");
                    //ajax保存题目
                    var flag = false;
                    $.ajax({
                        async: false,
                        type: "POST",
                        url: "/student/assignment/manageAssignment.do?1490104334217&method=saveExercise",
                        data: "examId=1436",
                        dataType: "json",
                        success: function (result) {
                            flag = true;
                            if (result.status == 'ok' || result.status == "invalid") {
                            } else {
                                $("#exerciseListUL").append("<li><font color=\"#CDCBCC\">&gt;</font>第" + result.index + "题" +
                                    "<font color=\"red\" id=\"examStudentExercise" + result.id + "></font></li>");
                            }
                        },
                        error: function () {
                            flag = false;
                        }
                    });
                    if (flag) {
                        result = "success";
                        document.getElementById("alertDiv").style.display = "none";
                        document.getElementById("maskDiv").style.display = "none";
                        playerPlay();
                    } else {
                        window.location.reload();
                    }
                }

                function setInfoHtml(seconds, disabledText, saveText) {
                    document.getElementById("alertDiv").innerHTML = infoHtml.replace("{currentSeconds}", seconds)
                        .replace("{disabled}", disabledText).replace("{saveText}", saveText);
                }

                function getAlertResult() {
                    return result;
                }

                var lastSaveTime = 1.0;
                function savePlayTime() {
                    var playTime = getCurrentPlayTime();

                    if (lastSaveTime == playTime) {
                        return;
                    }
                    $.ajax({
                        async: true,
                        type: "POST",
                        url: "/student/savePlayTime.do?1490104334217&method=savePlayTime",
                        data: "teachingTaskId=161&videoVisitId=575027&videoLength=3254&playTime=" + playTime,
                        success: function (result) {
                            if (result == "complete" || (result == "invalid" && true)) {
                                if (false) {
                                    popupAlertDivToAssignment(760, 505);
                                } else {
                                    window.location.reload();
                                }
                            } else if (result == "ok") {
                                lastSaveTime = playTime;
                            }
                        },
                        error: function () {
                            window.location.reload();
                        }
                    });
                }

                function toCourseVideo(courseId, videoId) {
                    var url = "/student/video/manageVideo.do?1490104334217&method=video&courseId=" + courseId;
                    if (videoId > 0) {
                        url += "&videoId=" + videoId;
                    }
                    window.location.href = url;
                }

                function uqyxq() {
                    if (!document.hasFocus() && !isFullScreen()) {
                        if (false) {
                            document.getElementById("mobile-video-player").pause();
                        } else {
                            jwplayer("player-container").pause(true);
                        }
                    }
                }

                function reWatch() {
                    if (confirm('重看将重新开始本视频的学习，放弃的题目将重新弹出，您确定要重看？')) {
                        $.ajax({
                            async: false,
                            type: "POST",
                            url: "/student/video/manageVideo.do?1490104334217&method=reWatch",
                            data: "videoVisitId=575027&examId=1436",
                            success: function (result) {
                                if (result == "ok") {
                                    window.location.reload();
                                }
                            },
                            error: function () {
                            }
                        });
                    }
                }
            </script>
            <style>
                .infiniteCarousel ul li {
                    display: block;
                    float: left;
                    padding: 2px;
                    height: 88px;
                    width: 132px;
                }
            </style>
            <div id="right">


                <table id="insideNav">
                    <tr>
                        <td>
                            <ul>
                                <li class="item " style="width: 200px;"
                                    onclick="javascript:window.location.href='/student/teachingTask/coursehomepage.do?1490104334217&courseId=7'">

                                    <div class="icon homeIcon" style="text-align: left; padding-left: 40px;">
                                        <span title="六大名著导读">六大名著导读</span>
                                    </div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/announce/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon announceIcon">公告</div>
                                </li>

                                <li class="item current" style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/video/manageVideo.do?1490104334217&method=index&teachingTaskId=161'">
                                    <div class="icon currentVideoIcon">视频</div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/assignment/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon assignmentIcon">作业</div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/exam/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon examIcon">考试</div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/faq/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon faqIcon">提问</div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/bbs/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon bbsIcon">讨论</div>
                                </li>


                                <li class="item " style="width: 90px;"
                                    onclick="javascript:window.location.href='/student/resource/index.do?1490104334217&teachingTaskId=161'">
                                    <div class="icon resourceIcon">资源</div>
                                </li>


                            </ul>
                        </td>
                    </tr>
                </table>
                <div class="lineShadow"></div>

                <div id="infoDiv">
                    <div class="popupTitleBar">
                        <div class="popupTitle">
                            随堂提问
                        </div>
                    </div>
                    <div id="popupInfo">
                        您有一道随堂问题需要保存至作业，请在
                        <span id="currentSeconds">{currentSeconds}</span> 秒内点击“保存”按钮，否则视为放弃。
                    </div>
                    <center>
                        <button onclick="save()" class="btn" {disabled}>
                            {saveText}
                        </button>
                    </center>
                </div>
                <div id="toAssignmentDiv" style="display: none;">
                    <div class="popupTitleBar">
                        <div class="popupTitle">
                            学习提醒
                        </div>
                    </div>
                    <div id="assignmentInfo" style="padding: 20px 10px 25px 10px;">
                    </div>
                    <center>
                        <button onclick="toAssignment()" class="btn" {disabled} style="margin-right: 30px;">
                            现在做作业
                        </button>
                        <button onclick="cancel()" class="btn" {disabled}>
                            稍后再做
                        </button>
                    </center>
                </div>
                <div id='maskDiv' class="maskDiv"></div>
                <div id='alertDiv' class="alertDiv"></div>
                <script type="text/javascript" src="/player/jwplayer.js"></script>
                <table width="100%">
                    <tr>
                        <td>
                            <div style="margin-bottom: 5px; " class="tip">
                                请认真观看视频，观看过程中会不定时弹出题目保存提示，请在规定的时间内保存，否则视为放弃该题。
                            </div>


                            <!-- 视频播放 -->


                            <!-- 以下主要用于类型转换和默认值设置 -->


                            <script type="text/javascript">
                                var videoPath = "http://hfutspk.hfut.edu.cn:8080/video/";

                                function playerPlay() {
                                    if (false) {
                                        document.getElementById("mobile-video-player").play();
                                    } else {
                                        jwplayer("player-container").play(true);
                                    }
                                }

                                function playerPause() {
                                    if (false) {
                                        document.getElementById("mobile-video-player").pause();
                                    } else {
                                        jwplayer("player-container").pause(true);
                                    }
                                }

                                function playerSeek(newTime) {
                                    if (false) {
                                        document.getElementById("mobile-video-player").currentTime = newTime;
                                    } else {
                                        jwplayer('player-container').seek(newTime);
                                    }
                                }

                                function isPlay() {
                                    if (false) {
                                        return !document.getElementById("mobile-video-player").paused;
                                    } else {
                                        return jwplayer("player-container").getState() == "PLAYING";
                                    }
                                }
                                videoPath += "C647705.mp3";

                                function isFullScreen() {
                                    return jwplayer("player-container").getFullscreen();
                                }

                                function setToNormalScreen() {
                                    if (false) {
                                        var myVideo = document.getElementById("mobile-video-player");
                                        if (myVideo.exitFullScreen) {
                                            myVideo.exitFullScreen();
                                        } else if (myVideo.webkitExitFullScreen) {
                                            myVideo.webkitExitFullScreen();
                                        } else if (myVideo.mozExitFullScreen) {
                                            myVideo.mozExitFullScreen();
                                        } else if (myVideo.oExitFullScreen) {
                                            myVideo.oExitFullScreen();
                                        } else if (myVideo.msExitFullScreen) {
                                            myVideo.msExitFullScreen();
                                        }
                                    } else {
                                        return jwplayer("player-container").setFullscreen(false);
                                    }
                                }

                                videoPath = videoPath.substring(0, videoPath.length - 4);

                                function getCurrentPlayTime() {
                                    if (false) {
                                        return document.getElementById("mobile-video-player").currentTime;
                                    } else {
                                        return parseInt(jwplayer("player-container").getPosition());
                                    }
                                }

                                <!-- 参数labels格式为：时间(秒)`: 标签内容`,...，如： 120`:第一章重点`,...，:和,前加`以免与标签中的:,冲突-->
                                function setLabel(labels) {
                                    jwplayer("player-container").callInternal("setLabel", labels);
                                }

                                videoPath += "/" + "11352864809956@97279".substring(1, "1352864809956@97279".length + 1) + ".mp3";

                                videoPath = videoPath.substring(0, videoPath.length - 4) + "/";

                                <!-- 播放器插件的访问地址 -->
                                function getPluginUrl() {
                                    return "/player";
                                }
                            </script>

                            <div id="player-container" style="width:750px; height:500px;">
                                正在加载，请稍后 ...
                            </div>
                            <div id="pause-player-container" style="width:750px; height:500px; display: none;">
                                视频处于暂停中 ...
                            </div>
                            <script type="text/javascript" src="/player/jwplayer.js"></script>
                            <script type="text/javascript">
                                var videoName = "1352864809956@97279.flv";
                                var subtitlesName = "";
                                var updateTime = new Date("Fri Jan 18 14:23:53 CST 2013").getTime();
                                if (true) {
                                    if (false) {
                                        videoName = "1352864809956@97279/1352864809956@97279.mp4";
                                        var video = "<video id=\"mobile-video-player\" height=\"500\" width=\"750\" controls autoplay loop>" +
                                            "<source src=\"" + videoPath + videoName + "?" + updateTime + "\" type=\"video/mp4\">"
                                        "<track kind=\"subtitles\" src=\"" + videoPath + subtitlesName + "\" srclang=\"zh\" label=\"Chinese\"></video>"
                                        $("#player-container").html(video);
                                    } else {
                                        jwplayer("player-container").setup({
                                            flashplayer: "/player/jwplayer.swf",
                                            file: videoPath + videoName + "?" + updateTime,
                                            plugins: {
                                                "captions-1": {
                                                    file: videoPath + subtitlesName
                                                }
                                            },
                                            width: 750,
                                            height: 500,
                                            screencolor: "#000",
                                            controlbar: "over",
                                            provider: "http",
                                            start: 0,
                                            starttime: 1.0,
                                            canseek: false,
                                            backcolor: "#000",
                                            lightcolor: "#999",
                                            frontcolor: "#999",
                                            autostart: true
                                        });
                                    }
                                } else {
                                    $("#player-container").html("该视频正在转换中，暂时不能观看该视频");
                                }
                            </script>

                        </td>
                        <td width="250" valign="top"
                            style="">
                            <div style="width: 178px;" id="exerciseList">
                                已保存题目
                                <ul id="exerciseListUL">

                                </ul>
                                &nbsp;&nbsp;
                                <br/>
                                放弃的题目
                                <ul id="unSaveExerciseListUL">

                                </ul>
                                <br/>
                                <div id="reWatchHelp" style="display:none;" class="tip">
                                    如果想让放弃的题目重新弹出，请点击【重新观看】按钮，重新进行本视频的学习。
                                </div>
                                <a id="reWatchBtn" href="javascript:reWatch();" style="display:none;">
                                    <span style="cursor: pointer;" class="rewatch lf">重新观看</span>
                                </a>
                            </div>
                        </td>
                    </tr>
                </table>

                <div class="nav_box">
                    <div class="nav_info">
                        共12集
                    </div>
                    <div class="infiniteCarousel">
                        <div class="wrapper">
                            <ul>

                                <li>
                                    <a title="《三国演义》从文化传统看“三国”"
                                       href='



							  				javascript:toCourseVideo("7","0");




								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《三国演义》从文化传统看“...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        <font color="red">第1集</font>


                                    </div>
                                </li>

                                <li>
                                    <a title="《三国演义》独特魅力之所在"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《三国演义》独特魅力之所在
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第2集


                                    </div>
                                </li>

                                <li>
                                    <a title="《水浒传》从文化传统看“水浒”"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《水浒传》从文化传统看“水...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第3集


                                    </div>
                                </li>

                                <li>
                                    <a title="《水浒传》正义与野蛮的交响乐"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《水浒传》正义与野蛮的交响乐
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第4集


                                    </div>
                                </li>

                                <li>
                                    <a title="《西游记》：把宗教游戏化的奇书"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《西游记》：把宗教游戏化的...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第5集


                                    </div>
                                </li>

                                <li>
                                    <a title="孙悟空与猪八戒：不朽的艺术形象"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                孙悟空与猪八戒：不朽的艺术...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第6集


                                    </div>
                                </li>

                                <li>
                                    <a title="《金瓶梅》社会画卷与市井“英雄”"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《金瓶梅》社会画卷与市井“...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第7集


                                    </div>
                                </li>

                                <li>
                                    <a title="《金瓶梅》： 女性形象与情欲描写"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《金瓶梅》： 女性形象与情...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第8集


                                    </div>
                                </li>

                                <li>
                                    <a title="《儒林外史》：读书人命运的悲歌"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《儒林外史》：读书人命运的...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第9集


                                    </div>
                                </li>

                                <li>
                                    <a title="《儒林外史》：科举制度下的读书人"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《儒林外史》：科举制度下的...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第10集


                                    </div>
                                </li>

                                <li>
                                    <a title="《红楼梦》中国古典小说的巅峰之作"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《红楼梦》中国古典小说的巅...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第11集


                                    </div>
                                </li>

                                <li>
                                    <a title="《红楼梦》的女性形象及红学略说"
                                       href='





									  		javascript:jwplayer("player-container").pause();alert("请按顺序学习");


								  '>
                                        <div class="item_div">

                                            <div style="padding: 15px 5px 0px 5px; text-align: center;">
                                                《红楼梦》的女性形象及红学...
                                            </div>
                                        </div>
                                    </a>
                                    <div class="index_info">


                                        第12集


                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>


                <!-- 视频导航 -->

                <script type="text/javascript">
                    $.fn.infiniteCarousel = function () {
                        function repeat(str, num) {
                            return new Array(num + 1).join(str);
                        }

                        return this.each(function () {
                            var $wrapper = $('> div', this).css('overflow', 'hidden'),
                                $slider = $wrapper.find('> ul'),
                                $items = $slider.find('> li'),
                                $single = $items.filter(':first'),

                                singleWidth = $single.outerWidth(),
                                visible = Math.ceil($wrapper.innerWidth() / singleWidth), // note: doesn't include padding or border
                                currentPage = 1,
                                pages = Math.ceil($items.length / visible);
                            // 1. Pad so that 'visible' number will always be seen, otherwise create empty items
                            if (($items.length % visible) != 0) {
                                $slider.append(repeat('<li class="empty" />', visible - ($items.length % visible)));
                                $items = $slider.find('> li');
                            }
                            // 2. Top and tail the list with 'visible' number of items, top has the last section, and tail has the first
                            $items.filter(':first').before($items.slice(-visible).clone().addClass('cloned'));
                            $items.filter(':last').after($items.slice(0, visible).clone().addClass('cloned'));
                            $items = $slider.find('> li'); // reselect
                            // 3. Set the left position to the first 'real' item
                            $wrapper.scrollLeft(singleWidth * visible);
                            // 4. paging function
                            function gotoPage(page) {
                                if (page == 0) {
                                    alert("已经是第一页");
                                    return;
                                } else if (page > pages) {
                                    alert("已经是最后一页");
                                    return;
                                }
                                var dir = page < currentPage ? -1 : 1,
                                    n = Math.abs(currentPage - page),
                                    left = singleWidth * dir * visible * n;
                                $wrapper.filter(':not(:animated)').animate({
                                    scrollLeft: '+=' + left
                                }, 500, function () {
                                    if (page == 0) {
                                        $wrapper.scrollLeft(singleWidth * visible * pages);
                                        page = pages;
                                    } else if (page > pages) {
                                        $wrapper.scrollLeft(singleWidth * visible);
                                        // reset back to start position
                                        page = 1;
                                    }
                                    currentPage = page;
                                });
                                return false;
                            }

                            $wrapper.after('<a class="arrow_left back"></a><a class="arrow_right forward"></a>');
                            // 5. Bind to the forward and back buttons
                            $('a.back', this).click(function () {
                                return gotoPage(currentPage - 1);
                            });
                            $('a.forward', this).click(function () {
                                return gotoPage(currentPage + 1);
                            });
                            // create a public interface to move to a specific page
                            $(this).bind('goto', function (event, page) {
                                gotoPage(page);
                            });
                            if (1 / visible > 1) {
                                gotoPage(Math.ceil(1 / visible));
                            }
                        });
                    };

                    $(document).ready(function () {
                        $('.infiniteCarousel').infiniteCarousel();
                        $(".item_div").hover(
                            function () {
                                $(this).addClass('item_div_hover')
                            },
                            function () {
                                $(this).removeClass('item_div_hover');
                            }
                        );
                    });
                </script>


                <div align="right" style="margin-top: 5px">
                    【<a href="/student/video/manageVideo.do?1490104334217&method=index&teachingTaskId=161&currentLinkPlay=true">切换到外网播放</a>】
                </div>

            </div>

        </div>
        <div class="content_bottom"></div>
    </div>
    <!--主内容结束-->
</div>
<!--底部开始-->

<div id="footer">
    <div align="center">
        合肥工业大学课程学习中心
        <script src="http://s95.cnzz.com/stat.php?id=4755149&web_id=4755149&show=pic" language="JavaScript"></script>
    </div>
</div>

<!--底部结束-->
<div id="loadingMask" style="display: none;"></div>
<iframe id="refresh" frameborder="0" scrolling="no" width="0" height="0" src="refresh.jsp"></iframe>
<div id="bdshareClose" onclick="javascript:closeResource();" title="隐藏"></div>
<div id="bdshareOpen" onclick="javascript:openResource();" title="显示资源网站"></div>
<div id="bdshareside">
    <div id="bdshare">
        <ul>

            <li onclick="javascript:window.open('http://baike.baidu.com')">
                百度百科
            </li>

            <li onclick="javascript:window.open('http://wenku.baidu.com')">
                百度文库
            </li>

            <li onclick="javascript:window.open('http://zhidao.baidu.com')">
                百科知道
            </li>

            <li onclick="javascript:window.open('http://www.icourses.cn')">
                爱课程网
            </li>

            <li onclick="javascript:window.open('http://open.163.com')">
                网易公开课
            </li>

            <li onclick="javascript:window.open('http://opencla.cntv.cn')">
                中国公开课
            </li>

        </ul>
    </div>
</div>
</body>
</html>

</body>
</html>
