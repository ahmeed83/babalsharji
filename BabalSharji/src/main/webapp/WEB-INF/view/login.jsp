<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="submitlogin" method="POST" onsubmit="">
            <label>email </label><input type="email" name="email"  class="form-control input-lg"/>
            <label>password </label><input type="password" name="password" class="form-control input-lg"/>
            <input type="submit" />
        </form>
    </div>
</div>