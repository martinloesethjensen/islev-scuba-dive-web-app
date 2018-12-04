
package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.api;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
public class MemberAPI {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("create")
    public ResponseEntity create(Member member) {
        if (member == null)
            return new ResponseEntity<>("Member not created", HttpStatus.NOT_IMPLEMENTED);

        memberRepository.save(member);

        return new ResponseEntity<>(String.format("Member %s Created", member), HttpStatus.OK);
    }
}
