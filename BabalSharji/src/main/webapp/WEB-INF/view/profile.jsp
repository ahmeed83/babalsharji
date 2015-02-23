<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${user != null}">
        <div class="container">
            <div class="row">
                <h3 style="border-bottom: 1px solid black; padding-bottom: 10px;"><c:out value="${user.getFirstname()} ${user.getLastname()}"/></h3>
                <a href="#">
                    <div class="thumbnail col-md-3" style="width: 200px; display: inline-block; margin-right: 50px;">

                        <img src="http://www.localcrimenews.com/wp-content/uploads/2013/07/default-user-icon-profile.png" alt="" class="img-circle img-responsive">
                        <br>
                        <p class="text-center">Change Profile</p>
                    </div>
                </a>
                <div class="col-md-9 col-lg-9 "> 
                    <table class="table table-user-information">
                        <tbody>
                            <tr>
                                <td>Name</td>
                                <td><c:out value="${user.getFirstname()} ${user.getLastname()}"/></td>
                            </tr>

                            <tr>
                                <td>Date of Birth</td>
                                <td><c:out value="${userDoB}"/></td>
                            </tr>
                            <tr>
                            <tr>
                                <td>Gender</td>
                                <td><c:out value="${user.getGender()}"/></td>
                            </tr>
                            <tr>
                                <td><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Home Address</td>
                                <td><c:out value="${user.getAddress()}"/></td>
                            </tr>
                            <tr>
                                <td><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Email</td>
                                <td><a href="<c:out value="${user.getEmail()}"/>"> <c:out value="${user.getEmail()}"/> </a></td>
                            </tr>
                            <tr>
                                <td><span class="glyphicon glyphicon-phone" aria-hidden="true"></span> Phone Number</td>
                                <td><c:out value="${phoneNumber}"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <ul class="nav nav-tabs" role="tablist" style="margin-top: 20px;">
                <li style="width: 200px; text-align: center;" class="active"><a href="#thumbnails"  data-toggle="tab">My Advertisements</a></li>
                <li style="width: 200px; text-align: center;"><a href="#thumbnails"  data-toggle="tab">My Bookmarks</a></li>
            </ul>
            <div class="tab-content">
                <div style="width: 100%; border-bottom: 1px solid #DDDDDD; display: table; padding: 8px 0; margin: 8px 0;">
                    <div class="pull-left" style="width: 110px; margin: 8px 0;">
                        <img src="assets/test2.jpg" class="img-responsive" alt="product name">
                    </div>
                    <div class="col-md-7" style="margin:5px 0;">
                        <a href="#" style="font-size: 16px;">
                            Volkswagen polo - 1.4 nogwat maar 100.000 gereden
                        </a>
                        <div style="font-size: 12px;">
                            Aston martin db7 v12 5.9l vantage aut. 1e eigenaar bijzonderheden: 
                            deze db7 vantage verkeert zowel motorisch als qua uiterlijk in uitmuntende...
                        </div>
                        <div style="font-size: 12px; margin-top:5px;">
                            <b>2003</b> | <b>66.512 km</b>
                        </div>
                    </div>
                    <div class="col-md-3 pull-right">
                        <p class="text-right">Reactions: <b>0</b></p>
                        <p class="text-right">Price: <b>€1234.00</b></p>
                    </div>
                </div>
                <div style="width: 100%; border-bottom: 1px solid #DDDDDD; display: table; padding: 8px 0; margin: 8px 0;">
                    <div class="pull-left" style="width: 110px; margin: 8px 0;">
                        <img src="assets/test2.jpg" class="img-responsive" alt="product name">
                    </div>
                    <div class="col-md-7" style="margin:5px 0;">
                        <a href="#" style="font-size: 16px;">
                            Volkswagen polo - 1.4 nogwat maar 100.000 gereden
                        </a>
                        <div style="font-size: 12px;">
                            Aston martin db7 v12 5.9l vantage aut. 1e eigenaar bijzonderheden: 
                            deze db7 vantage verkeert zowel motorisch als qua uiterlijk in uitmuntende...
                        </div>
                        <div style="font-size: 12px; margin-top:5px;">
                            <b>2003</b> | <b>66.512 km</b>
                        </div>
                    </div>
                    <div class="col-md-3 pull-right">
                        <p class="text-right">Reactions: <b>0</b></p>
                        <p class="text-right">Price: <b>€1234.00</b></p>
                    </div>
                </div>
                <div style="width: 100%; border-bottom: 1px solid #DDDDDD; display: table; padding: 8px 0; margin: 8px 0;">
                    <div class="pull-left" style="width: 110px; margin: 8px 0;">
                        <img src="assets/test2.jpg" class="img-responsive" alt="product name">
                    </div>
                    <div class="col-md-7" style="margin:5px 0;">
                        <a href="#" style="font-size: 16px;">
                            Volkswagen polo - 1.4 nogwat maar 100.000 gereden
                        </a>
                        <div style="font-size: 12px;">
                            Aston martin db7 v12 5.9l vantage aut. 1e eigenaar bijzonderheden: 
                            deze db7 vantage verkeert zowel motorisch als qua uiterlijk in uitmuntende...
                        </div>
                        <div style="font-size: 12px; margin-top:5px;">
                            <b>2003</b> | <b>66.512 km</b>
                        </div>
                    </div>
                    <div class="col-md-3 pull-right">
                        <p class="text-right">Reactions: <b>0</b></p>
                        <p class="text-right">Price: <b>€1234.00</b></p>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        
    </c:otherwise>
</c:choose>