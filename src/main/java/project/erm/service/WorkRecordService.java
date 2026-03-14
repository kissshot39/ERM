package project.erm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.dto.workrecord.response.FindDetailWorkRecordResponse;
import project.erm.dto.workrecord.response.FindWorkRecordResponse;
import project.erm.entity.Member;
import project.erm.entity.WorkRecord;
import project.erm.mapper.WorkRecordMapper;
import project.erm.repository.MemberRepository;
import project.erm.repository.WorkRecordRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkRecordService {
    private final WorkRecordRepository workRecordRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void checkInMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("invalid Member Id : %d", memberId)));

        boolean alreadyCheckedIn = workRecordRepository.existsByMemberAndCheckOutIsNull(member);
        if (alreadyCheckedIn) {
            throw new IllegalArgumentException("이미 출근한 상태입니다.");
        }

        Clock clock = Clock.systemDefaultZone();

        WorkRecord workRecord =
                WorkRecord.builder()
                        .member(member)
                        .date(LocalDate.now(clock))
                        .checkIn(LocalDateTime.now(clock))
                        .build();

        workRecordRepository.save(workRecord);
    }

    @Transactional
    public void checkOutMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("checkOutMember Invalid Member Id : %d", memberId)));

        boolean alreadyCheckedOut = workRecordRepository.existsByMemberAndCheckOutIsNull(member);
        if (alreadyCheckedOut) {
            throw new IllegalArgumentException("checkIn이 되어있지 않습니다");
        }

        WorkRecord workRecord = workRecordRepository.findByMemberAndCheckInIsNull(member)
                .orElseThrow(() -> new IllegalArgumentException("checkoutMember Invalid Member"));

        Clock clock = Clock.systemDefaultZone();
        workRecord.checkOut(LocalDateTime.now(clock));
    }


    public FindWorkRecordResponse findWorkRecord(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("findWorkRecord Invalid Member id : %d", memberId)));

        List<WorkRecord> workRecords = workRecordRepository.findAllByMemberAndCheckInIsNotNullAndCheckOutIsNotNull(member);
        if (workRecords.isEmpty()) {
            throw new IllegalArgumentException("findWorkRecord Records error");
        }

        FindWorkRecordResponse response =
                WorkRecordMapper.toFindWorkRecordResponse(workRecords);

        return response;
    }


}
