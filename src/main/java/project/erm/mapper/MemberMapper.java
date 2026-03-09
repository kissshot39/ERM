package project.erm.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import project.erm.dto.member.request.CreateMemberRequest;
import project.erm.dto.member.response.MemberDetailResponse;
import project.erm.entity.Member;
import project.erm.entity.Team;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemberMapper {

    public static Member toEntity(
            CreateMemberRequest request,
            Team team) {
        Member member = Member.builder()
                .name(request.name())
                .team(team)
                .role(request.role())
                .birthday(request.birthday())
                .workStartDate(request.workStartDate())
                .build();
        return member;
    }

    public static MemberDetailResponse toMemberDetailResponse(Member member) {
        MemberDetailResponse response =
                new MemberDetailResponse(
                        member.getName(),
                        member.getTeam().getName(),
                        member.getRole(),
                        member.getBirthday(),
                        member.getWorkStartDate()
                );
                return response;
    }
}
