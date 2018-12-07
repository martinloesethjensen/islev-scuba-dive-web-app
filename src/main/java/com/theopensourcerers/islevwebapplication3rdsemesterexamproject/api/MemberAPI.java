
package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.api;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller.AdminController;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
public class MemberAPI {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("create")
    public ResponseEntity create(Member member) {
        if (member == null)
            return new ResponseEntity<>("Member not created", HttpStatus.NOT_IMPLEMENTED);
        System.out.println(member);
        memberRepository.save(member);

        return new ResponseEntity<>(String.format("Member %s Created", member), HttpStatus.OK);
    }

    @PutMapping("edit")
    public ResponseEntity update(Member member) {
        if (member == null)
            return new ResponseEntity<>("Member not updated", HttpStatus.NOT_IMPLEMENTED);

        memberRepository.save(member);

        return new ResponseEntity<>(String.format("Member %s Updated", member), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity delete(Integer id) {
        if (id == 0)
            return new ResponseEntity<>("Member not deleted", HttpStatus.NOT_IMPLEMENTED);

        Member member = memberRepository.findByIdEquals(id);
        memberRepository.delete(member);

        AdminController.success = true;

        return new ResponseEntity<>(String.format("Member %s Deleted", member), HttpStatus.OK);
    }
}
