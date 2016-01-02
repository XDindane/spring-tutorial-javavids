<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"/></title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    </head>
    <body>
        <tilesx:useAttribute name="current" />


        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<spring:url value="/" />">Java blog aggregator</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="${current == 'index' ? 'active' : ''}"><a href="<spring:url value="/" />">Home</a></li>
                                
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <li class="${current == 'users' ? 'active' : ''}" ><a href="<spring:url value="/users.html" />">Users</a></li> <!--   must be a html-->
                                </security:authorize>
                                
                                <li class="${current == 'register' ? 'active' : ''}" ><a href="<spring:url value="/register.html" />">Register</a></li> <!--   must be a html-->
                                
                                <security:authorize access="!isAuthenticated()">
                                    <li class="${current == 'login' ? 'active' : ''}" ><a href="<spring:url value="/login.html" />">Login</a></li> <!--   must be a html-->
                                </security:authorize>
                                
                                <security:authorize access="isAuthenticated()">
                                    <li class="${current == 'account' ? 'active' : ''}" ><a href="<spring:url value="/account.html" />">My account</a></li> <!--   must be a html-->
                                    <li><a href="<spring:url value="/logout" />">Logout</a></li> <!--   must be a html-->
                                </security:authorize>
                        </ul>

                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <tiles:insertAttribute name="body" />

            <br><br>
            <center>
                <tiles:insertAttribute name="footer" />
            </center>
        </div>
    </body>
</html>
