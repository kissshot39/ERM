package project.erm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTeamRequest(
        @NotBlank String teamName,
        String managerName,
        @NotNull Long memberCount
) {
}
