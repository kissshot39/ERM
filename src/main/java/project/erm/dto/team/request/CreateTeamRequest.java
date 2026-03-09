package project.erm.dto.team.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTeamRequest(
        @NotBlank String name,
        String managerName
) {
}
