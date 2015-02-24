<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-offset-1 col-md-10">
        <form action="submitlogin" method="POST" onsubmit="">
            <label>email </label><input type="email" name="email"  class="form-control input-lg"/>
            <label>password </label><input type="password" name="password" class="form-control input-lg"/>
            <input type="submit" value="login" class="btn btn-success" />
        </form>
    </div>
</div>