

[![SinninSC Logo](FigureShop\document\logo.png)]("")

## [Live Demo](https://booking.vinhnhan.com/PRJ301_SE08D_BookingHotel) - [Live Document](https://heaty566.github.io/cv/PRJ301_SE08D_BookingHotel_REPORT.pdf)

# Booking Hotel - Servlet + JSP + Tailwind

## Case Study

A large hotel chain in the US, the SanninSC Hotels Group. The group consists of ten hotels, organized in one place. Each hotel has between 40 and 100 bedrooms (can extend), which are categorized as double (D), twin(T), single(S), queen(Q), King(K), or luxury(L). Double and twin rooms may be let as singles. There are no online systems. A new group managing director has recently been appointed. One of the director's primary objectives is to increase profit. Therefore, the director plans to develop a web application to manage online systems. This web application needs to include manage system for staff and booking system for customer.

It needs to follow some business rule below:

Only authenticated user has the ability to make a booking or review. Manager ability and customer ability must be separate. In detail, an authenticated user know as a customer can view detail of room information, make a booking (include one or many rooms on a different date). They can view their booking information and cancel it in special situations. Manager ability includes adding new room, update room information. View all bookings of customers and cancel or checkout booking.

## Feature by role

- ### Both Role Action
     - Login, register new account and logout
     - Change password
     - Update user information
- ### Customer Role Action
     - Add new booking to cart
     - Booking or cancel in cart
     - Cancel Booking
     - Review booking
     - Checking booking information
- ### Admin Role Action
     - Create new room
     - Update information for a room
     - Checkout (2 options ) or cancel booking
     - Manage all room
     - Manage all booking

## Technology

- Frontend
     - JSP - Server Side Rendering
     - Tailwind - Styling
     - Javascript
- Backend
     - Servlet - Server Core
     - SQL Server 2019 - Database
- Deployment
     - Docker - Container Management
     - Github Action - CI/CD

## Team Member

- Nguyễn Hoàng Lộc | Backend - Leader
     - Gmail: heaty566@gmail.com
     - Linkedin: https://www.linkedin.com/in/heaty566
     - Github: https://github.com/Heaty566
- Đậu Lê Đức | Frontend
     - Gmail: haicao2805@gmail.com
     - Linkedin: https://www.linkedin.com/in/cao-chi-hai
     - Github: https://github.com/haicao2805
- Thạch Chí Khang | Backend
     - Gmail: tantruong2303@gmail.com
     - Linkedin: https://linkedin.com/in/truongbinhtan
     - Github: https://github.com/tantruong2303

## Project Picture

### Database Diagram

#### Entity Diagram

![Database Page](FigureShop\document\figureShop_Diagram.png)

#### Relational Diagram

![Database Page](FigureShop\document\database.PNG)

### Home Page

![Home Page](FigureShop\document\homePage.png)

### Management Page

![Management Page](data/images/manager.png)

### Sign In Page

![Sign in Page](FigureShop\document\signInPage.PNG)

## Bug Report

Feel free to create an issue request anytime we will check it out and fix it as soon as possible. Thank You So Much.

### Tetcha © 2021