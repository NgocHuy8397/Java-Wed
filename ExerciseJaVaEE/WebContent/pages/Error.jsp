<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Exercise Customer</title>
        <style type="text/css">
        #addCustomerForm {
            padding-top: 20px;
        }
        
        #submit{
            color:red;        
        }
        #editviewdelete{
            display: flex;
            padding: 0px 3px;
        }
        #searchcustomer{
            display: flex;
            padding: 0px 3px;
        }
        #search{
            padding: 0px 8px;
        }
        #searchBtn{
            height: 20px;
        }
        #view{
            text-decoration: none;
            margin: 0px 5px;
            color: black;
            background: aliceblue;
        }
        #delete{
             text-decoration: none;
             margin: 0px 5px;
             color: black;
             background: antiquewhite;
        }
        #edit{
             text-decoration: none;
             margin: 0px 5px;
             color: black;
        }
        </style>
    </head>
    <body>
       <h3>please ! enter a number greater than 0, back to homepage</h3>
       <a href="/customer/customer/edit">Home</a>
    </body>
</html>