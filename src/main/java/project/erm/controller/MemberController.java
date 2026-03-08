package project.erm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import project.erm.dto.request.CreateMemberRequest;
import project.erm.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public void createMember(@Valid CreateMemberRequest request) {
        memberService.createMember(request);
    }

}
