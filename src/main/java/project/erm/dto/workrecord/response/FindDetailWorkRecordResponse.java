package project.erm.dto.workrecord.response;

import java.time.LocalDate;

public record FindDetailWorkRecordResponse(
        LocalDate date,
        Long workingMinutes
) {

}
