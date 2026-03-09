package project.erm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.erm.dto.member.request.CreateMemberRequest;
import project.erm.dto.member.response.MemberDetailResponse;
import project.erm.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("member")
    public void createMember(@Valid @RequestBody CreateMemberRequest request) {
        memberService.createMember(request);
    }

    @GetMapping("members")
    public List<MemberDetailResponse> getAllMembers() {
        return memberService.findAllTeams();
    }
}
