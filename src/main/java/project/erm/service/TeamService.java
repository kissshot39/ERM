package project.erm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.dto.team.request.CreateTeamRequest;
import project.erm.dto.team.response.TeamDetailResponse;
import project.erm.entity.Team;
import project.erm.mapper.TeamMapper;
import project.erm.repository.TeamRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void createTeam(CreateTeamRequest request) {
        Team team = TeamMapper.toEntity(request);
        teamRepository.save(team);
    }

    public List<TeamDetailResponse> findAllTeams() {
        List<Team> teams = teamRepository.findAll();

        List<TeamDetailResponse> responses =
                teams.stream()
                        .map(TeamMapper::toTeamDetailResponse)
                        .toList();
        return responses;
    }
}
