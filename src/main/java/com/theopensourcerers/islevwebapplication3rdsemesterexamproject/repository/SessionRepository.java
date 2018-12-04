package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    Session findByUsernameEquals(String username);
    Session findByIdEquals(Integer id);
    List<Session> findAll();
}
