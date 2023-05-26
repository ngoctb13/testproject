<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vi">
    <head>
        <title>Sign up</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/style1.css">

    </head>
    <body class="img js-fullheight" style="background-image: url(images/bg_3.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <div class="site-logo">
                            <a href="home.jsp">
                                <img src="images/logo.png" alt="Logo">
                            </a>
                        </div>
                    </div>
                </div>
                <h3>${registerFailed}</h3>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Create your account</h3>
                            <form action="register" method="POST" class="signin-form">
                                <div style="text-align:center">
                                    <span id='message'></span>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="your_name" id="your_name" class="form-control" placeholder="Enter your name" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="user_email" id="user_email" class="form-control" placeholder="Enter your email" required>
                                </div>
                                <div class="form-group">
                                    <input id="password" name="password" type="password" class="form-control" placeholder="Enter your password" required onkeyup='check();'>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <input id="confirm-password" type="password" class="form-control" placeholder="Confirm password" required onkeyup='check();'>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>                                                               
                                <div class="form-group">
                                    <button type="submit" onclick="return check();" class="form-control btn btn-primary submit px-3">Sign Up</button>
                                </div>
                            </form>
                            <p class="w-100 text-center">&mdash; Have an account? &mdash;</p>
                            <div class="form-group">
                                <a href="login.jsp" class="form-control btn btn-primary submit px-3" role="button">Sign In</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script>
            var check = function () {
                if (document.getElementById('password').value ===
                        document.getElementById('confirm-password').value) {
                    document.getElementById('message').style.color = 'green';
                    document.getElementById('message').innerHTML = 'Matching';
                    return true;
                } else {
                    document.getElementById('message').style.color = 'red';
                    document.getElementById('message').innerHTML = 'Not Matching';
                    return false;
                }
            };
        </script>
        <script src="js/jquery1.min.js"></script>
        <script src="js/popper1.js"></script>
        <script src="js/bootstrap1.min.js"></script>
        <script src="js/main1.js"></script>

    </body>
</html>

