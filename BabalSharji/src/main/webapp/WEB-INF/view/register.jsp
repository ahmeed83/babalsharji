<div class="container">
    <div class="row">
        <form action="registeruser" method="post">
            <div class="col-md-6" style="margin-top: 5%;">
                <div class="row">
                    <div class="col-md-6">
                        <input type="text" class="form-control input-lg" name="firstname" placeholder="First name">
                    </div>
                    <div class="col-md-6">
                        <input type="text" class="form-control input-lg" name="lastname" placeholder="Last name">
                    </div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <div class="col-md-12">
                        <input type="text" class="form-control input-lg" name="telephone" placeholder="Telephone number">
                    </div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <div class="col-md-12">
                        <input type="text" class="form-control input-lg" name="email" placeholder="Email address">
                    </div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <div class="col-md-6">
                        <input type="password" class="form-control input-lg" name="password" placeholder="Password">
                    </div>
                    <div class="col-md-6">
                        <input type="password" class="form-control input-lg" name="passwordcontrol" placeholder="Retype Password">
                    </div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <div class="col-md-12">
                        <button class="btn btn-info col-md-2" onclick="setAgreement(this)"><span
                                class="glyphicon glyphicon-unchecked"></span> Agree
                        </button>
                        <div style="display:block;" class="col-md-10">By clicking agree you are agreeing to our <a href="#">terms
                            of use</a> and our <a href="#">Cookie policy</a> on this site.
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <div class="col-md-12">
                        <button class="btn btn-lg btn-success col-md-12" type="submit">Sign up !</button>
                    </div>
                </div>
            </div>
        </form>
        <div class="col-md-6">
            <div class="jumbotron" style="margin-top: 10%; background-color: #FFF; border-left: 1px solid #DDD">
                <h2>Instantly share!</h2>

                <p>Sharing your advertisement with Iraq has never been this easy.</p>

                <p>And even better: it doesn't cost you a dime.</p>

                <p><a class="btn btn-warning btn-lg pull-right" href="#" role="button">Learn more</a></p>
            </div>
        </div>
    </div>
</div>

<script>
    var toggle = false;
    function setAgreement(obj) {
        if (!toggle) {
            obj.innerHTML = '<span class="glyphicon glyphicon-check"></span> I Agree';
            toggle = true;
        } else {
            obj.innerHTML = '<span class="glyphicon glyphicon-unchecked"></span> Agree';
            toggle = false;
        }
    }
</script>