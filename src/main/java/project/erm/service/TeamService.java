package project.erm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.dto.request.CreateTeamRequest;
import project.erm.entity.Team;
import project.erm.repository.TeamRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void createTeam(CreateTeamRequest request) {
        Team team = Team.builder()
                .teamName(request.teamName())
                .managerName(request.managerName())
                .memberCount(request.memberCount())
                .build();

        teamRepository.save(team);
    }
}
