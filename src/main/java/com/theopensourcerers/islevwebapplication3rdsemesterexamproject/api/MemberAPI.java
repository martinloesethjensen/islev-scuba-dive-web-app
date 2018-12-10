
package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.api;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Member;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller.AdminController;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller.MemberController;
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

    @GetMapping("list")
    public ResponseEntity list() { return new ResponseEntity<>(memberRepository.findAll(), HttpStatus.OK); }

    //    TODO: validate postal code and phone number.
	@PostMapping("create")
	public ResponseEntity create(Member member) {
		if (member == null)
			return new ResponseEntity<>("Member not created", HttpStatus.NOT_IMPLEMENTED);
		member.getSession().setRole("MEMBER");
		memberRepository.save(member);

		return new ResponseEntity<>(String.format("Member %s Created", member), HttpStatus.OK);
	}

    @PutMapping("edit")
    public ResponseEntity edit(Member member) {
        if (member == null)
            return new ResponseEntity<>("Member not updated", HttpStatus.NOT_IMPLEMENTED);

	    member.getSession().setRole(memberRepository.findBySessionId(WebSecurityConfig.getMyId()).getSession().getRole());
	    memberRepository.save(member);

	    MemberController.success = true;

        return new ResponseEntity<>(String.format("Member %s Updated", member), HttpStatus.OK);
    }

	@GetMapping("/get-current-member")
	public ResponseEntity<Member> getCurrentMember() {
		Member member = memberRepository.findBySessionId(WebSecurityConfig.getMyId());
		return new ResponseEntity<>(member, HttpStatus.OK);
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

    @PutMapping("update")
    public ResponseEntity update(Member member) {
        if (member == null)
            return new ResponseEntity<>("Member not found", HttpStatus.NOT_FOUND);

        Member memberSave = memberRepository.findBySessionId(WebSecurityConfig.getMyId());
        memberSave.setFirstname(member.getFirstname());
        memberSave.setLastname(member.getLastname());
        memberSave.setAddress(member.getAddress());
        memberSave.setPhone(member.getPhone());
        memberSave.setCity(member.getCity());
        memberSave.setCertificateNumber(member.getCertificateNumber());
        memberSave.setZipcode(member.getZipcode());
        memberSave.getSession().setUsername(member.getSession().getUsername());
        if(!member.getSession().getPassword().equals("")) memberSave.getSession().setPassword(member.getSession().getPassword());
        memberRepository.save(memberSave);

        MemberController.success = true;

        return new ResponseEntity<>(String.format("Member %s Updated", member), HttpStatus.OK);
    }
}
