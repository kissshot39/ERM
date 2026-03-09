package project.erm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.erm.dto.team.request.CreateTeamRequest;
import project.erm.dto.team.response.TeamDetailResponse;
import project.erm.service.TeamService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {


    private final TeamService teamService;

    @PostMapping("team")
    public void createTeam(@Valid @RequestBody CreateTeamRequest request) {
        teamService.createTeam(request);
    }

    @GetMapping("teams")
    public List<TeamDetailResponse> getAllTeams() {
        return teamService.findAllTeams();
    }


}
