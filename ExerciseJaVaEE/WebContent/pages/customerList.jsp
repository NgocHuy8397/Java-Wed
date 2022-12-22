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
            margin: 10px 10px;       
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
       <%@include file="header.jsp" %>
       <h2>Customer List: ${customers.size()}</h2>
       <h1>Search customer</h1>
       <form id="searchcustomer" method="get" action="/customer/search">
            <div id="search">Name: <input name="name"></input> </div>
            <br>
            <div id="search">Phone: <input name="phone"></input> </div>
            <br>
            <div id="search">Gender: <select name="gender">
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="">All</option>
            </select></div>
            <div id="search">Membership level: <select name="membership_level">
              <option value="Gold">Gold</option>
              <option value="Silver">Silver</option>
              <option value="Platinum">Platinum</option>
              <option value="">All</option>
            </select> </div>
            <br>
            <br>
            <input id="searchBtn" type="submit" value="Search" />
       </form>
       
       <table width="1200" border="1">
            <thead>
                <tr>
                    <th width="100">ID</th>
                    <th width="700">Name</th>
                    <th width="200">Gender</th>
                    <th width="400">Phone</th>
                    <th width="900">Address</th>
                    <th width="400">Email</th>
                    <th width="300">Membership level</th>
                    <th width="200">Point</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.gender}" /></td>
                    <td><c:out value="${customer.phoneNumber}" /></td>
                    <td><c:out value="${customer.address}" /></td>
                    <td><c:out value="${customer.email}" /></td>
                    <td><c:out value="${customer.membershipLevel}" /></td>
                    <td><c:out value="${customer.point}" /></td>

                    <td>
                       <div id="editviewdelete">
                        <a id="view" href="./customer/view?id=${customer.id}">View</a>
                        <a id="delete" href="./customer/delete?id=${customer.id}">Delete</a>
                        <a id="edit" href="./customer/editCustomer?id=${customer.id}">Edit</a>
                       </div>
                    </td>
                </tr>
               </c:forEach>
            </tbody>
       </table>
       <form id="addCustomerForm" method="post" action="/customer/add">
           <label for="name">Customer name:</label>
           <input type="text" id="name" name="name" />
           <br/>
           <br/>
           <label for="name">Customer gender:</label>
            <select name="gender">
              <option value="Male">Male</option>
              <option value="Female">Female</option>
            </select>
           <br />
           <br/>
           <label for="name">Customer phone:</label>
           <input type="text" id="name" name="phone" />
           <br />
           <br/>
           <label for="name">Customer address:</label>
           <input type="text" id="name" name="address" />
           <br />
           <br/>
           <label for="name">Customer email:</label>
           <input type="text" id="name" name="email" />
           <br />
     
           <input id="submit" type="submit" value="Submit" />
       </form>
       <script>
          
       </script>
    </body>

</html>