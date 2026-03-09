package project.erm.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import project.erm.dto.team.request.CreateTeamRequest;
import project.erm.dto.team.response.TeamDetailResponse;
import project.erm.entity.Team;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TeamMapper {

    public static Team toEntity(CreateTeamRequest request) {
        Team team = Team.builder()
                .name(request.name())
                .managerName(request.managerName())
                .build();
        return team;
    }

    public static TeamDetailResponse toTeamDetailResponse(Team team) {
        TeamDetailResponse response =
                new TeamDetailResponse(
                        team.getName(),
                        team.getManagerName(),
                        team.getMemberCount()
                );
        return response;
    }
}
