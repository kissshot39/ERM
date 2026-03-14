package project.erm.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import project.erm.dto.workrecord.response.FindDetailWorkRecordResponse;
import project.erm.dto.workrecord.response.FindWorkRecordResponse;
import project.erm.entity.WorkRecord;

import java.time.Duration;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WorkRecordMapper {

    public static FindWorkRecordResponse toFindWorkRecordResponse(List<WorkRecord> workRecord) {

        List<FindDetailWorkRecordResponse> details =
                workRecord.stream()
                        .map(WorkRecordMapper::toFindDetailWorkRecordResponse)
                        .toList();

        Long sum = details.stream()
                .mapToLong(FindDetailWorkRecordResponse::workingMinutes)
                .sum();

        FindWorkRecordResponse response = new FindWorkRecordResponse(details, sum);

        return response;
    }

    public static FindDetailWorkRecordResponse toFindDetailWorkRecordResponse(WorkRecord workRecord) {

        Long workingMinutes = Duration.between(
                workRecord.getCheckIn(),
                workRecord.getCheckOut()
        ).toMinutes();

        FindDetailWorkRecordResponse response =
                new FindDetailWorkRecordResponse(
                        workRecord.getDate(),
                        workingMinutes);

        return response;
    }

}
