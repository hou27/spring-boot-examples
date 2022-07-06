# Querydsl

## Querydsl이란?
Querydsl은 HQL(Hibernate Query Language)를 타입에 안전하게 생성 및 관리할 수 있게 해주는 Framework이다.    
쉽게 말해 Java 코드를 통해 Query를 작성할 수 있게 되는 것이다.  

## Querydsl을 사용하는 이유
- JPA를 사용하는 경우  

간단한 Query라면,
```java
Optional<Users> findByEmail(String email);
```
위와 같이 JPA를 통해 간단하게 메서드를 정의하여 사용할 수 있다.  

그러나 복잡한 조건이 추가되어 query문을 작성하여 사용하는 경우,  
가독성이 떨어지며 추가로 문자열이기 때문에 실행 전까지는 오류 발생 여부를 확인하기 어렵다.

- Querydsl을 사용하는 경우  

문자가 아닌 코드로 Query를 작성하므로 컴파일 시점에 오류를 쉽게 확인할 수 있다.
