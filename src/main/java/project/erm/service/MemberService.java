package project.erm.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.domain.Role;
import project.erm.dto.request.CreateMemberRequest;
import project.erm.entity.Member;
import project.erm.entity.Team;
import project.erm.repository.MemberRepository;
import project.erm.repository.TeamRepository;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void  createMember(CreateMemberRequest request) {

        Role role = Role.from(request.role());

        Team team = teamRepository.findByTeamName(request.teamName())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Team %s is invalid", request.teamName())));

        Member member = Member.builder()
                .name(request.name())
                .team(team)
                .role(role)
                .birthday(request.birthday())
                .workStartDate(request.workStartDate())
                .build();

        memberRepository.save(member);
    }
}
