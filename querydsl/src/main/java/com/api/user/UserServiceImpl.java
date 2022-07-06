package com.api.user;

import com.api.user.domain.QUsers;
import com.api.user.repository.UserRepository;
import com.api.user.domain.Users;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Users> findAll() {
    QUsers qUsers = QUsers.users;
//    List<Tuple> usersTuple = jpaQueryFactory.select(qUsers.id, qUsers.createdAt, qUsers.updateAt, qUsers.email, qUsers.name, qUsers.role).from(qUsers).fetch();
    List<Users> usersList = userRepository.findAll();

    for (Users user : usersList) {
      System.out.println("user = " + user.toString());
    }
    return usersList;
  }

  @Override
  public Optional<Users> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Optional<Users> findByName(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public Users updateUser(Users user, String newInfo) {
    return null;
  }
}
