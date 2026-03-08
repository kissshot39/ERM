package project.erm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateMemberRequest(

        @NotBlank String name,
        @NotBlank String teamName,
        @NotBlank String role,
        @NotNull LocalDate birthday,
        @NotNull LocalDate workStartDate
) {
}
