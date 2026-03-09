package project.erm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("member")
    public MemberDetailResponse attendanceMember(@RequestParam Long id) {
        return memberService.findMember(id);
    }

    @GetMapping("members")
    public List<MemberDetailResponse> getAllMembers() {
        return memberService.findAllMember();
    }
}
