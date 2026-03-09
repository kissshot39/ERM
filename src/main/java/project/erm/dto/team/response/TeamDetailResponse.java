package project.erm.dto.team.response;

public record TeamDetailResponse(
        String name,
        String managerName,
        Long memberCount
) {
}
