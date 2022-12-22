package com.huy.exercise.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huy.exercise.training.core.ServiceFactory;
import com.huy.exercise.training.model.Customer;
import com.huy.exercise.training.model.Gender;
import com.huy.exercise.training.model.MembershipLevel;
import com.huy.exercise.training.service.ICustomerService;

@WebServlet(urlPatterns = "/customer/*")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET RequestURI: " + req.getRequestURI());
        String requestURI = req.getRequestURI();

        ICustomerService customerService = ServiceFactory.get(ICustomerService.class);
        if ("/customer/search".equalsIgnoreCase(requestURI)) {
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String phoneNumber = req.getParameter("phone");
            String membership_level = req.getParameter("membership_level");
            System.out.print("name: " + name);
            System.out.println("gender: " + gender);
            System.out.println("phoneNumber:" + phoneNumber);
            System.out.println("membership_level:" + membership_level);

            req.setAttribute("customers", ServiceFactory.get(ICustomerService.class).searchCustomers(name, gender,
                    phoneNumber, membership_level));
            getServletContext().getRequestDispatcher("/pages/customerList.jsp").forward(req, resp);
        }
        if ("/customer/list".equalsIgnoreCase(requestURI)) {
            resp.setContentType("Text/html");
        } else if (requestURI.contains("/customer/delete")) {
            String id = req.getParameter("id");
//            System.out.println("delete patient id: " + id);
            customerService.deleteCustomerById(Integer.parseInt(id));
            resp.sendRedirect(req.getContextPath() + "/customer");
        } else if (requestURI.contains("/customer/view")) {
            String id = req.getParameter("id");
            Customer customer = customerService.getCustomerById(Integer.parseInt(id));
            if (customer == null) {
                getServletContext().getRequestDispatcher("/pages/404.jsp").forward(req, resp);
            } else {
                req.setAttribute("customer", customer);
                getServletContext().getRequestDispatcher("/pages/customerDetails.jsp").forward(req, resp);
            }
        } else if (requestURI.contains("/customer/editCustomer")) {
            String id = req.getParameter("id");
            req.setAttribute("customer", customerService.getCustomerById(Integer.parseInt(id)));
            getServletContext().getRequestDispatcher("/pages/editCustomer.jsp").forward(req, resp);

        } else {
            req.setAttribute("customers", customerService.getCustomer());
            getServletContext().getRequestDispatcher("/pages/customerList.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST RequestURI: " + req.getRequestURI());
        String requestURI = req.getRequestURI();
//        if("/customer/search".equalsIgnoreCase(requestURI)) {
//            String name = req.getParameter("customerName");
//            String gender = req.getParameter("gender");
//            String phoneNumber = req.getParameter("phone");
//            String membership_level = req.getParameter("membership_level");
//            System.out.print("name: " + name);
//            System.out.println("gender: " + gender);
//            System.out.println("phoneNumber:" + phoneNumber);
//            System.out.println("membership_level:" + membership_level);
//            
//            
//            req.setAttribute("search",  ServiceFactory.get(ICustomerService.class).searchCustomers(name,gender,phoneNumber,membership_level));
//            getServletContext().getRequestDispatcher("/pages/customerList.jsp").forward(req, resp);
//            resp.sendRedirect(req.getContextPath() + "/customer");
//        }
        if ("/customer/update".equalsIgnoreCase(requestURI)) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String phoneNumber = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
//            String membership_level = req.getParameter("membership_level");
            int point = Integer.parseInt(req.getParameter("point"));
            if (point < 0) {
                resp.sendRedirect(req.getContextPath() + "/pages/Error.jsp");
            } else {
                Customer c = new Customer();
                c.setId(Integer.parseInt(id));
                c.setName(name);
                c.setGender(Gender.valueOf(gender));
                c.setPhoneNumber(phoneNumber);
                c.setAddress(address);
                c.setEmail(email);
//            c.setMembershipLevel(MembershipLevel.valueOf(membership_level));
                c.setPoint(point);
                
                ServiceFactory.get(ICustomerService.class).editCustomer(c);
                resp.sendRedirect(req.getContextPath() + "/customer");
                
            }
            
        }

        if ("/customer/add".equalsIgnoreCase(requestURI)) {
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String phoneNumber = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
//            String membership_level = req.getParameter("membership_level");
//            int point = Integer.parseInt(req.getParameter("point"));
            Customer c = new Customer();
            c.setName(name);
            c.setGender(Gender.valueOf(gender));
            c.setPhoneNumber(phoneNumber);
            c.setAddress(address);
            c.setEmail(email);
//            c.setMembershipLevel(MembershipLevel.valueOf(membership_level));
//            c.setPoint(point);

            ServiceFactory.get(ICustomerService.class).addCustomer(c);
            resp.sendRedirect(req.getContextPath() + "/customer");
        }

    }

}
