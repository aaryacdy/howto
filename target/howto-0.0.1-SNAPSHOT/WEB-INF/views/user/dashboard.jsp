<%--
  Created by Aarya
  User: aarya
  Date: 2/9/2022
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title> ${title} </title>
  <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/css/style.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/css/material.css">
  <link rel="icon" href="${baseUrl}/resources/other/user/images/icon1.png">
  <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/fonts/font.css">
  <script type="text/javascript" src="${baseUrl}/resources/other/user/js/jquery-3.2.1.min.js"></script>
  <style>
    textarea{
      display: none;
      width: 300px;
      height: 50px;
      background: #333;
      color: #ddd;
      padding: 10px;
      margin: 5px 0 -14px;
    }
    .ans_sub{
      display: none;
      padding: 0 10px;
      height: 30px;
      line-height: 30px;
    }
    .pop{
      display: none;
      text-align: center;
      margin: 151.5px auto;
      font-size: 12px;
    }
  </style>
</head>
<body id="_1">
<!-- navigation bar -->
<%--<a href="index">
  <div id="log">
    <div id="i">i</div><div id="cir">H</div><div id="ntro">ow To</div>
    <div>How To</div>
  </div>
</a>--%>
<ul id="nav-bar">
  <a href="${baseUrl}/contact">
    <li>Contact</li>
  </a>
  <a href="${baseUrl}/user/ask">
    <li>Ask Question</li>
  </a>
  <a href="${baseUrl}/signup"><li>Sign Up</li></a>
  <a href="${baseUrl}/logout">
    <li>Log Out</li></a>
</ul>

<!-- content -->
<div id="content">
  <div id="searchbox">
    <center>
      <div class="heading">
<%--        <h1 class="logo"><div id="i">i</div><div id="cir">H</div><div id="ntro">ow To</div></h1>--%>
<%--        <p id="tag-line">Where questions can be asked in the form of How To.</p>--%>
      </div>
      <form action="" method="post" enctype="multipart/form-data">
      <input name="text" id="search" type="text" title="Question your Answers" placeholder="Looking for Answers to Some Question, simply just search here... ">
      <i class="material-icons" id="sign">search</i>
      <input name="submit" type="submit" value="Search" class="up-in" id="qsearch">
      </form>
    </center>
  </div>

 <%-- <div class="pop" id="ta">
    <h1><b style="font-size: 1.5em; margin: -60px auto 10px; display: block;">:(</b>Sorry, Your search didn't match any documents.</h1>
  </div>
  <div class="pop" id="tb">
    <center><h1><b style="font-size: 1.5em; margin: -60px auto 10px; display: block;">:)</b>Thank You For Your Answer.</h1></center>
  </div>
  <style>.open{display: block;} </style>
  <center>
    <div class='open' style='height: auto; margin: 60px auto -135px;'>

      <div id='topic'>
        <h2 id='topic-head' style="font-weight: normal; border:none; font-size: 22px;">Your Search Results for are :</h2>
      </div>

      <div id="qa-block">
        <div class="question">
          <div id="Q">Q.</div>
        </div>
        <div class="answer">

          <form id="" style="margin-bottom: -25px;" action="" method="post" enctype="multipart/form-data">
          <!--                                    <input type="button" value="Click here to answer." id="ans_b" >-->
          <label style="margin-bottom: -25px;"><a id="ans_b" href="#area"><u>Submit your answer</u></a></label>
          <br>
          <script>
            $(function(){
              $('#ans_b').click(function(e){
                e.preventDefault();
                $('#area').css("display","block");
                $('#ar').css("display","block");
                $('#f').css("margin-bottom","0px");
              });
            });
          </script>
          <textarea id="area" name="answer" placeholder="Your Answer..."></textarea>
          <input style="display: none;" name="question" value="">
          <input style="display: none;" name="nul" value="">
          <input style="display: none;" name="preby" value="">
          <br>
          <input type="submit" name="ansubmit" value="Submit" class="up-in ans_sub" id="ar">

          </form>
        </div>
      </div>
    </div>
  </center>--%>

</div>
<!-- Footer -->
<div id="footer">
  &copy; 2022 &bull; Kathford International College
</div>

</body>

</html>
