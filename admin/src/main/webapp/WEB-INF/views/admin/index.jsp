<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Bootstrap Top navbar and Sidebar</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.2/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="navbar navbar-fixed-top navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <!-- /.nav-collapse -->
    </div>
    <!-- /.container -->
</div>
<!-- /.navbar -->

<div class="container-fluid">
    <div class="row row-offcanvas row-offcanvas-left">
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <div class="sidebar-nav">
                <ul class="nav">

                    <li class="active"><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->

        <div class="col-xs-12 col-sm-9">
            <br>
            <div class="jumbotron">
                <a href="#" class="visible-xs" data-toggle="offcanvas"><i class="fa fa-lg fa-reorder"></i></a>
                <h1>Hello, world!</h1>
                <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
            </div>
            <div class="row">
                <div class="col-6 col-sm-6 col-lg-4">
                    <h2>Heading</h2>
                    <p>Bootstrap is a front-end framework that uses CSS and JavaScript to facilitate responsive Web design. Bootply is a playground for Bootstrap that enables developers and designers to test, prototype and create mockups using Bootstrap
                        friendly HTML, CSS and Javascript.</p>
                    <p><a class="btn btn-default" href="#">View details »</a></p>
                </div>
                <!--/span-->
                <div class="col-6 col-sm-6 col-lg-4">
                    <h2>Heading</h2>
                    <p>Bootply is a playground for Bootstrap that enables developers and designers to test, prototype and create mockups using Bootstrap friendly HTML, CSS and Javascript. Bootstrap is a front-end framework that uses CSS and JavaScript to
                        facilitate responsive Web design. </p>
                    <p><a class="btn btn-default" href="#">View details »</a></p>
                </div>
                <!--/span-->

                <div class="col-6 col-sm-6 col-lg-4">
                    <h2>Heading</h2>
                    <p>Bootstrap is a front-end framework that uses CSS and JavaScript to facilitate responsive Web design. Bootply is a playground for Bootstrap that enables developers and designers to test, prototype and create mockups using Bootstrap
                        friendly HTML, CSS and Javascript.</p>
                    <p><a class="btn btn-default" href="#">View details »</a></p>
                </div>
                <!--/span-->
                <div class="col-6 col-sm-6 col-lg-4">
                    <h2>Heading</h2>
                    <p>Bootstrap is a front-end framework that uses CSS and JavaScript to facilitate responsive Web design. Bootply is a playground for Bootstrap that enables developers and designers to test, prototype and create mockups using Bootstrap
                        friendly HTML, CSS and Javascript.</p>
                    <p><a class="btn btn-default" href="#">View details »</a></p>
                </div>
                <!--/span-->
            </div>
            <!--/row-->
        </div>
        <!--/span-->


    </div>
    <!--/row-->

    <hr>

    <footer>
        <p>© Company 2013</p>
    </footer>

</div>
<!--/.container-->
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>