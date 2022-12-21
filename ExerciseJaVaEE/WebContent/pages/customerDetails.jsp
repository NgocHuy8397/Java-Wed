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
        #infomation{
            
        }

        </style>
    </head>
    <body>
       <%@include file="header.jsp" %>
        <div id="infomation">
            <div>Id: <b>${customer.id}</b></div>
            <div>Name: <b>${customer.name}</b></div>
            <div>Gender: <b>${customer.gender}</b></div>
            <div>Address: <b>${customer.address}</b></div>
            <div>Point: <b>${customer.point}</b></div>
            <div>Phone number: <b>${customer.phoneNumber}</b></div>
            <div>Email: <b>${customer.email}</b></div>
            <div>Membership Level: <b>${customer.membershipLevel}</b></div>
            <div>Freeticket: <b>${customer.membershipLevel.freeTicket}</b></div>
        </div>
       
       <a href="/customer">View Customer List</a>
    </body>
</html>