package project.erm.dto.workrecord.response;

import java.util.List;

public record FindWorkRecordResponse(
        List<FindDetailWorkRecordResponse> detail,
        Long sum
) {}
