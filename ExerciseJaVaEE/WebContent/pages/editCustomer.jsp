 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Exercise Customer</title>
        <style type="text/css">
        #addPatientForm {
            padding-top: 20px;
        }
        #edit{
            margin: 10px 5px;
        }
        #name{
            margin: 10px 5px;
        }
        #gender{
            margin: 10px 5px;
        }
        #address{
            margin: 10px 5px;
        }
        #point{
            margin: 10px 5px;
        }
        #phone{
            margin: 10px 5px;
        }
        #email{
            margin: 10px 5px;
        }
        #membershipLevel{
            margin: 10px 5px;
        }
        </style>
    </head>
    <body>
       <h1>Edit Customer</h1>
        <form id="addCustomerForm" method="post" action="/customer/update">
        <div id="edit">
            <div id="id"><input name = "id" value ="${customer.id}" type="hidden" ></div>
            <div id="name">Name: <input name="name" value="${customer.name}"></input></div>
            <div id="gender">Gender: <input name="gender" value="${customer.gender}"></input></div>
            <div id="address">Address: <input  name="address" value="${customer.address}"></input></div>
            <div id="point">Point: <input name="point" value="${customer.point}"></input></div>
            <div id="phone">Phone number: <input name="phone" value="${customer.phoneNumber}"></input></div>
            <div id="email">Email: <input name="email" value="${customer.email}"></input></div>
            <div id="membershipLevel"><input name="membership_level" value="${customer.membershipLevel}" type="hidden" ></div>
            
        </div>
            <input id="save" type="submit" value="Save" />
            <input id="cancel" type="submit" value="Cancel" />
        </form>    
        <script>
           
        </script>
    </body>
</html>