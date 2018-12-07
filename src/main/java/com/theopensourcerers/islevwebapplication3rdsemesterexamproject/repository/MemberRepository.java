package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Integer> {
    Member findByIdEquals(Integer id);
    Member findBySessionId(Integer id);
    List<Member> findAll();
}
