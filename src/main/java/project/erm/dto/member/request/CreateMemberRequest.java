package project.erm.dto.member.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import project.erm.domain.Role;

import java.time.LocalDate;

public record CreateMemberRequest(

        @NotBlank String name,
        @NotBlank String teamName,
        @NotNull Role role,
        @NotNull LocalDate birthday,
        @NotNull LocalDate workStartDate
) {
}
