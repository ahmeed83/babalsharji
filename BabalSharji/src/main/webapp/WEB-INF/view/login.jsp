<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row" style="height: 240px; width: 100%;">
    <div class="col-md-offset-4 col-md-4" style="position: absolute; top: 180px;">
        <form action="submitlogin" method="POST" onsubmit="">
            <label>email </label><input type="email" name="email"  class="form-control input-lg"/>
            <label>password </label><input type="password" name="password" class="form-control input-lg"/>
            <input type="submit" value="login" class="btn btn-success" style="margin-top:10px;"/>
        </form>
    </div>
</div>