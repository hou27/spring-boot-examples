# Spring Boot && JWT Demo

Spring Boot를 이용한 간단한 JWT 예시 레포지토리 

---
<img src="https://img.shields.io/badge/postgresql-gray?style=for-the-badge&logo=postgresql&logoColor=white"> <img src="https://img.shields.io/badge/Spring Boot-green?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/redis-red?style=for-the-badge&logo=redis&logoColor=black"> <img src="https://img.shields.io/badge/Swagger-gree?style=for-the-badge&logo=Swagger&logoColor=black">


# How to use authenticationManager Bean in 5.7.1

> 참고 : https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

### Question
Is there any example how can I expose the AuthenticationManager bean? Previously I could do this by extending WebSecurityConfigurerAdapter and then creating the following method in my security config:
```
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
```

### Answer
The following solution solved the issue for me.
```
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
}
```

# Profile
Set ```application.yml``` to use ```.dev.env``` file
```yaml
spring:
  config:
    import: optional:file:.dev.env[.properties]
```

# API Doc
You can see API Document on  
http://localhost:3000

## Preview
### Group 1
> authentication is required

![swagger screenshot](https://user-images.githubusercontent.com/65845941/177004280-9652b978-5e3c-4152-8c36-fcc42681bdec.PNG)

### Group 2
> authentication is not required

![swagger screenshot2](https://user-images.githubusercontent.com/65845941/177004330-844a6055-2d77-49f8-bff5-1d8562b413fc.PNG)


# TODO

- [ ] Apply QueryDSL