package project.erm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.erm.dto.request.CreateTeamRequest;
import project.erm.service.TeamService;

@RestController
@RequiredArgsConstructor
public class TeamController {


    private final TeamService teamService;

    public void createTeam(@Valid @RequestBody CreateTeamRequest request) {
        teamService.createTeam(request);
    }
}
