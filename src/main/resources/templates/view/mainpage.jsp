<%-- 
    Document   : newsfeed
    Created on : Mar 15, 2020, 6:37:49 PM
    Author     : Eng Eslam khder
--%>

<%@page import="java.util.Collections"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Model.User"%>
<%@page import="Controller.Control_DB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="This is social network html5 template available in themeforest......" />
        <meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
        <meta name="robots" content="index, follow" />
        <title>News Feed | Check what your friends are doing</title>

        <!-- Stylesheets
        ================================================= -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/mystyle.css" />
        <link rel="stylesheet" href="css/ionicons.min.css" />
        <link rel="stylesheet" href="css/font-awesome.min.css" />
        <link href="css/emoji.css" rel="stylesheet">
        <!--Google Webfont-->
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,300italic,400italic,500,500italic,600,600italic,700' rel='stylesheet' type='text/css'>
        <!--Favicon-->
        <link rel="shortcut icon" type="image/png" href="images/fav.png"/>
        <script src="js/myscript.js"></script>
    </head>
    <style>
        .ion-images
        {
            width: 17px;
            height: 22px;
            position: absolute;
            top: 14px;
            left: 28px;
        }
    </style>
    <body>

        <!-- Header
        ================================================= -->
        <header id="header">
            <nav class="navbar navbar-default navbar-fixed-top menu">
                <div class="container">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo" /></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right main-menu">
                            <li class="dropdown"><a href="index.html">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Newsfeed <span><img src="images/down-arrow.png" alt="" /></span></a>
                                <ul class="dropdown-menu newsfeed-home">
                                    <li><a href="newsfeed.html">Newsfeed</a></li>
                                    <li><a href="newsfeed-people-nearby.html">Poeple Nearly</a></li>
                                    <li><a href="newsfeed-friends.html">My friends</a></li>
                                    <li><a href="newsfeed-messages.html">Chatroom</a></li>
                                    <li><a href="newsfeed-images.html">Images</a></li>
                                    <li><a href="newsfeed-videos.html">Videos</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Timeline <span><img src="images/down-arrow.png" alt="" /></span></a>
                                <ul class="dropdown-menu login">
                                    <li><a href="timeline.html">Timeline</a></li>
                                    <li><a href="timeline-about.html">Timeline About</a></li>
                                    <li><a href="timeline-album.html">Timeline Album</a></li>
                                    <li><a href="timeline-friends.html">Timeline Friends</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle pages" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">All Pages <span><img src="images/down-arrow.png" alt="" /></span></a>
                                <ul class="dropdown-menu page-list">
                                    <li><a href="index.html">Landing Page</a></li>
                                    <li><a href="newsfeed.html">Newsfeed</a></li>
                                    <li><a href="newsfeed-people-nearby.html">Poeple Nearly</a></li>
                                    <li><a href="newsfeed-friends.html">My friends</a></li>
                                    <li><a href="newsfeed-messages.html">Chatroom</a></li>
                                    <li><a href="newsfeed-images.html">Images</a></li>
                                    <li><a href="newsfeed-videos.html">Videos</a></li>
                                    <li><a href="timeline.html">Timeline</a></li>
                                    <li><a href="timeline-about.html">Timeline About</a></li>
                                    <li><a href="timeline-album.html">Timeline Album</a></li>
                                    <li><a href="timeline-friends.html">Timeline Friends</a></li>
                                    <li><a href="contact.html">Contact Us</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="contact.html">Contact</a></li>
                        </ul>
                        <form class="navbar-form navbar-right hidden-sm">
                            <div class="form-group">
                                <i class="icon ion-android-search"></i>
                                <input type="text" class="form-control" placeholder="Search friends, photos, videos">
                            </div>
                        </form>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </header>
        <!--Header End-->

        <div id="page-contents">
            <div class="container">
                <div class="row">

                    <!-- Newsfeed Common Side Bar Left
                    ================================================= -->
                    <div class="col-md-3 static">
                        <div class="profile-card">
                            <img src="images/users/user-1.jpg" alt="user" class="profile-photo" />
                            <h5><a href="timeline.html" class="text-white">${user.getName()}</a></h5>
                            <a href="#" class="text-white"><i class="ion ion-android-person-add"></i> 1,299 followers</a>
                        </div><!--profile card ends-->
                        <ul class="nav-news-feed">
                            <li><i class="icon ion-ios-paper"></i><div><a href="newsfeed.html">My Newsfeed</a></div></li>
                            <li><i class="icon ion-ios-people"></i><div><a href="newsfeed-people-nearby.html">People Nearby</a></div></li>
                            <li><i class="icon ion-ios-people-outline"></i><div><a href="newsfeed-friends.html">Friends</a></div></li>
                            <li><i class="icon ion-chatboxes"></i><div><a href="newsfeed-messages.html">Messages</a></div></li>
                            <li><i class="icon ion-images"></i><div><a href="newsfeed-images.html">Images</a></div></li>
                            <li><i class="icon ion-ios-videocam"></i><div><a href="newsfeed-videos.html">Videos</a></div></li>
                        </ul><!--news-feed links ends-->
                        <div id="chat-block">
                            <div class="title">Chat online</div>
                            <ul class="online-users list-inline">
                                <li><a href="newsfeed-messages.html" title="Linda Lohan"><img src="images/users/user-2.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Sophia Lee"><img src="images/users/user-3.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="John Doe"><img src="images/users/user-4.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Alexis Clark"><img src="images/users/user-5.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="James Carter"><img src="images/users/user-6.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Robert Cook"><img src="images/users/user-7.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Richard Bell"><img src="images/users/user-8.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Anna Young"><img src="images/users/user-9.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                                <li><a href="newsfeed-messages.html" title="Julia Cox"><img src="images/users/user-10.jpg" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                            </ul>
                        </div><!--chat block ends-->
                    </div>
                    <div class="col-md-7">

                        <!-- Post Create Box
                                     ================================================= -->
                        <form action="../../SharePost" method="POST">
                            <div class="create-post">
                                <div class="row">
                                    <div class="col-md-7 col-sm-7">
                                        <div class="form-group">
                                            <img src="images/users/user-1.jpg" alt="" class="profile-photo-md" />
                                            <textarea name="texts" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Write what you wish"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-5 col-sm-5">
                                        <div class="tools">
                                            <ul class="publishing-tools list-inline">
                                                <li><i class="ion-compose"></i></li>
                                                <li><a href="#"><input type="file" id="file" name="image" class="ion-images" /></a></li>
                                                <li><a href="#"><i class="ion-ios-videocam"></i></a></li>
                                                <li><a href="#"><i class="ion-map"></i></a></li>
                                            </ul>
                                            <button id="button" class="btn btn-primary pull-right" >Publish</button>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- Post Create Box End-->
                        </form>
                        <!-- Post Content
                        ================================================= -->
                        <%
                            ArrayList<Post> posts = new ArrayList();
                        %>
                        <jsp:useBean id="user" class="Model.User" scope="session" />
                        <jsp:scriptlet>
                            Connection connect = (Connection) application.getAttribute("Connect");
                            Control_DB control_db = new Control_DB();
                            control_db.setConnecion(connect);
                            posts = control_db.getPosts();
                            pageContext.setAttribute("POSTS", posts);
                        </jsp:scriptlet>
                        <!-- Foreach to Display All Post (JSTL TAGLB) -->
                        <c:forEach items="${POSTS}" var="post" begin="0" end="<%= posts.size() - 1%>">
                            <!-- Set Variable (JSTL TAGLB) -->
                            <c:set var="image" value="${post.getImage()}"/>  
                            <div class="post-content">
                                <!-- If Condition (if no-image not display) (JSTL TAGLB) -->
                                <c:if test="${image != \"\"}">  
                                    <img src="images/${post.getImage()}" alt="post-image" class="img-responsive post-image" />
                                </c:if>
                                <div class="post-container">
                                    <img src="images/users/user-5.jpg" alt="user" class="profile-photo-md pull-left" />
                                    <div class="post-detail">
                                        <div class="user-info">
                                            <!-- Create Object of class User in Package (Standred Action) -->
                                            <jsp:useBean id="Userid" class="Model.User" >
                                                <jsp:setProperty name="Userid" property="id" value="${post.getIduser()}"/>
                                            </jsp:useBean>
                                            <%
                                                Userid = control_db.getUserName(Userid);
                                            %>
                                            <h5><a href="timeline.html" class="profile-link">
                                                    <%= Userid.getName()%>
                                                </a> <span class="following">following</span></h5>
                                            <p class="text-muted">Published a photo about 3 mins ago</p>
                                        </div>
                                        <div class="reaction">
                                            <a href="../../addLike" class="btn text-green"><i class="icon ion-thumbsup"></i> 13</a>
                                            <a class="btn text-red"><i class="fa fa-thumbs-down"></i> 0</a>
                                        </div>
                                        <div class="line-divider"></div>
                                        <div class="post-text">
                                            <!-- Set Variable (JSTL TAGLB) -->
                                            <c:set var="text" value="${post.getText()}"/> 
                                            <!-- If Condition (if no-text not display) (JSTL TAGLB) -->
                                            <c:if test="${text != \"\"}">  
                                                <p>
                                                    ${post.getText()}
                                                </p>
                                            </c:if>  

                                        </div>
                                        <div class="line-divider"></div>
                                        <div class="post-comment">
                                            <img src="images/users/user-11.jpg" alt="" class="profile-photo-sm" />
                                            <p><a href="timeline.html" class="profile-link">Diana </a><i class="em em-laughing"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                                        </div>
                                        <div class="post-comment">
                                            <img src="images/users/user-4.jpg" alt="" class="profile-photo-sm" />
                                            <p><a href="timeline.html" class="profile-link">John</a> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                                        </div>
                                        <div class="post-comment">
                                            <img src="images/users/user-1.jpg" alt="" class="profile-photo-sm" />
                                            <input type="text" class="form-control" placeholder="Post a comment">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Remove Variable (JSTL TAGLB) -->
                            <c:remove var="Userid" />
                        </c:forEach>
                        <!-- Newsfeed Common Side Bar Right
                        ================================================= -->
                        <div class="col-md-2 static">
                            <div class="suggestions" id="sticky-sidebar">
                                <h4 class="grey">Who to Follow</h4>
                                <div class="follow-user">
                                    <img src="images/users/user-11.jpg" alt="" class="profile-photo-sm pull-left" />
                                    <div>
                                        <h5><a href="timeline.html">Diana Amber</a></h5>
                                        <a href="#" class="text-green">Add friend</a>
                                    </div>
                                </div>
                                <div class="follow-user">
                                    <img src="images/users/user-12.jpg" alt="" class="profile-photo-sm pull-left" />
                                    <div>
                                        <h5><a href="timeline.html">Cris Haris</a></h5>
                                        <a href="#" class="text-green">Add friend</a>
                                    </div>
                                </div>
                                <div class="follow-user">
                                    <img src="images/users/user-13.jpg" alt="" class="profile-photo-sm pull-left" />
                                    <div>
                                        <h5><a href="timeline.html">Brian Walton</a></h5>
                                        <a href="#" class="text-green">Add friend</a>
                                    </div>
                                </div>
                                <div class="follow-user">
                                    <img src="images/users/user-14.jpg" alt="" class="profile-photo-sm pull-left" />
                                    <div>
                                        <h5><a href="timeline.html">Olivia Steward</a></h5>
                                        <a href="#" class="text-green">Add friend</a>
                                    </div>
                                </div>
                                <div class="follow-user">
                                    <img src="images/users/user-15.jpg" alt="" class="profile-photo-sm pull-left" />
                                    <div>
                                        <h5><a href="timeline.html">Sophia Page</a></h5>
                                        <a href="#" class="text-green">Add friend</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer
            ================================================= -->
            <footer id="footer">
                <div class="container">
                    <div class="row">
                        <div class="footer-wrapper">
                            <div class="col-md-3 col-sm-3">
                                <a href=""><img src="images/logo-black.png" alt="" class="footer-logo" /></a>
                                <ul class="list-inline social-icons">
                                    <li><a href="#"><i class="icon ion-social-facebook"></i></a></li>
                                    <li><a href="#"><i class="icon ion-social-twitter"></i></a></li>
                                    <li><a href="#"><i class="icon ion-social-googleplus"></i></a></li>
                                    <li><a href="#"><i class="icon ion-social-pinterest"></i></a></li>
                                    <li><a href="#"><i class="icon ion-social-linkedin"></i></a></li>
                                </ul>
                            </div>
                            <div class="col-md-2 col-sm-2">
                                <h6>For individuals</h6>
                                <ul class="footer-links">
                                    <li><a href="">Signup</a></li>
                                    <li><a href="">login</a></li>
                                    <li><a href="">Explore</a></li>
                                    <li><a href="">Finder app</a></li>
                                    <li><a href="">Features</a></li>
                                    <li><a href="">Language settings</a></li>
                                </ul>
                            </div>
                            <div class="col-md-2 col-sm-2">
                                <h6>For businesses</h6>
                                <ul class="footer-links">
                                    <li><a href="">Business signup</a></li>
                                    <li><a href="">Business login</a></li>
                                    <li><a href="">Benefits</a></li>
                                    <li><a href="">Resources</a></li>
                                    <li><a href="">Advertise</a></li>
                                    <li><a href="">Setup</a></li>
                                </ul>
                            </div>
                            <div class="col-md-2 col-sm-2">
                                <h6>About</h6>
                                <ul class="footer-links">
                                    <li><a href="">About us</a></li>
                                    <li><a href="">Contact us</a></li>
                                    <li><a href="">Privacy Policy</a></li>
                                    <li><a href="">Terms</a></li>
                                    <li><a href="">Help</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 col-sm-3">
                                <h6>Contact Us</h6>
                                <ul class="contact">
                                    <li><i class="icon ion-ios-telephone-outline"></i>+1 (234) 222 0754</li>
                                    <li><i class="icon ion-ios-email-outline"></i>info@thunder-team.com</li>
                                    <li><i class="icon ion-ios-location-outline"></i>228 Park Ave S NY, USA</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="copyright">
                    <p>Thunder Team © 2016. All rights reserved</p>
                </div>
            </footer>

            <!--preloader-->
            <div id="spinner-wrapper">
                <div class="spinner"></div>
            </div>

            <!-- Scripts
            ================================================= -->
            <script src="js/jquery-3.1.1.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.sticky-kit.min.js"></script>
            <script src="js/jquery.scrollbar.min.js"></script>
            <script src="js/script.js"></script>
            
            <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script>
            
    </body>
</html>