<style>
    .loginouter {
        height: 240px; width: 100%;
    }
    .loginouter .logininner {
        position: absolute; top: 180px;
    }
    .loginouter .logininner .submitlogin {
        margin-top: 10px;
    }
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row loginouter">
    <div class="col-md-offset-4 col-md-4 logininner">
        <form action="submitlogin" method="POST" onsubmit="">
            <label>email </label><input type="email" name="email"  class="form-control input-lg"/>
            <label>password </label><input type="password" name="password" class="form-control input-lg"/>
            <input type="submit" value="login" class="submitlogin btn btn-success"/>
        </form>
    </div>
</div>