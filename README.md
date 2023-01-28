# Garage-Plug
Spring Boot assigments

### How To Run in Your Local System
#### Fist Connect Your Database:: Name IS e Ecom;
          Database  Password Must be change in application.properties (root is my password)
              spring.datasource.password=root
              
Method --
Run Local Machine

    SignUp-http://localhost:8088/customer/signup
    Login-http://localhost:8088/customer/login
    logout-http://localhost:8088/customer/logut/{Uuid}
    getdeatils-http://localhost:8088/customer/deatils/{uuid}
    
    create-Orders-http://localhost:8088/orders/create/{uuid}/{product_id}
    GetAllOrderDeatils-http://localhost:8088/orders/getAll/{uuid}
          
          
      
