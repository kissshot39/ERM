package project.erm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.erm.entity.Member;
import project.erm.entity.WorkRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkRecordRepository extends JpaRepository<WorkRecord, Long> {

    Optional<WorkRecord> findByMemberAndCheckInIsNull(Member member);
    List<WorkRecord> findAllByMemberAndCheckInIsNotNullAndCheckOutIsNotNull(Member member);
    boolean existsByMemberAndCheckOutIsNull(Member member);

}
