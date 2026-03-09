package project.erm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.domain.Role;
import project.erm.dto.member.request.CreateMemberRequest;
import project.erm.dto.member.response.MemberDetailResponse;
import project.erm.entity.Member;
import project.erm.entity.Team;
import project.erm.mapper.MemberMapper;
import project.erm.repository.MemberRepository;
import project.erm.repository.TeamRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void createMember(CreateMemberRequest request) {

        Team team = teamRepository.findByName(request.teamName())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Team %s is invalid", request.teamName())));

        Member member = MemberMapper.toEntity(request, team);
        handleManagerAssignment(team, member);
        memberRepository.save(member);
        team.increaseMemberCount();
    }

    public List<MemberDetailResponse> findAllTeams() {
        List<Member> members = memberRepository.findAll();

        List<MemberDetailResponse> responses =
                members.stream()
                        .map(MemberMapper::toMemberDetailResponse)
                        .toList();

        return responses;
    }

    private void handleManagerAssignment(Team team, Member member) {
        if (member.getRole() != Role.MANAGER) {
            return;
        }

        memberRepository.findByTeamAndRole(team, Role.MANAGER)
                .ifPresent(manager -> manager.changeRole(Role.MEMBER));

        team.changeManagerName(member.getName());

    }
}
