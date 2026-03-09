package project.erm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.erm.entity.Member;
import project.erm.entity.WorkRecord;
import project.erm.repository.MemberRepository;
import project.erm.repository.WorkRecordRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        Clock clock = Clock.systemDefaultZone();

        WorkRecord workRecord =
                WorkRecord.builder()
                        .member(member)
                        .date(LocalDate.now(clock))
                        .checkIn(LocalDateTime.now(clock))
                        .build();

        workRecordRepository.save(workRecord);
    }

    public void checkOutMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("checkOutMember Invalid Member Id : %d", memberId)));

        WorkRecord workRecord = workRecordRepository.findByMemberAndCheckOutIsNull(member)
                .orElseThrow(() -> new IllegalArgumentException("checkoutMember Invalid Member"));

        Clock clock = Clock.systemDefaultZone();
        workRecord.checkOut(LocalDateTime.now(clock));
    }

}
