package project.erm.dto.member.response;


import project.erm.domain.Role;

import java.time.LocalDate;

public record MemberDetailResponse(
        String name,
        String teamName,
        Role role,
        LocalDate birthday,
        LocalDate workStartDate
        ) {
}
