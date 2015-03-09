<style>
    .logininner .loginbox {
        margin-top: 10%;
    }
    .logininner .signupbox {
        margin-top: 10%; background-color: #FFF; border-left: 1px solid #DDD;
    }
    .logininner .submitlogin {
        margin-top: 10px;
    }
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row logininner">
        <div class="col-md-6 loginbox">
            <form action="submitlogin" method="POST" class="col-md-offset-2 col-md-8">
                <label>email </label><input type="email" name="email"  class="form-control input-lg"/>
                <label>password </label><input type="password" name="password" class="form-control input-lg"/>
                <input type="submit" value="login" class="submitlogin btn btn-success pull-right"/>
            </form>
        </div>
        <div class="col-md-6">
            <div class="jumbotron signupbox">
                <h2>Sign up today!</h2>
                <p>and quickly share your advertisements.</p>
                <p><a class="btn btn-warning btn-lg pull-right" href="register" role="button">sign up</a></p>
            </div>
        </div>
    </div>
</div>