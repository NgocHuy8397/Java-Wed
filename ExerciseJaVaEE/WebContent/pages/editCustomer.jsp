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
        </style>
    </head>
    <body>
       <h1>Edit Customer</h1>
        <form id="addCustomerForm" method="post" action="/customer/update">
        <div >
            <div id="edit"><input name = "id" value ="${customer.id}" type="hidden" ></div>
            <div id="edit">Name: <input name="name" value="${customer.name}"></input></div>
            <div id="edit">Gender: <input name="gender" value="${customer.gender}"></input></div>
            <div id="edit">Address: <input name="address" value="${customer.address}"></input></div>
            <div id="edit">Point: <input name="point" value="${customer.point}"></input></div>
            <div id="edit">Phone number: <input name="phone" value="${customer.phoneNumber}"></input></div>
            <div id="edit">Email: <input name="email" value="${customer.email}"></input></div>
            <div id="edit"><input name="membership_level" value="${customer.membershipLevel}" type="hidden" ></div>
            <div id="edit">Freeticket: <b>${customer.membershipLevel.freeTicket}</b></div>
        </div>
            <input id="save" type="submit" value="Save" />
            <input id="cancel" type="submit" value="Cancel" />
        </form>    
    </body>
</html>