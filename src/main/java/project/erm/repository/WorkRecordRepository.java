package project.erm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.erm.entity.Member;
import project.erm.entity.WorkRecord;

import java.util.Optional;

@Repository
public interface WorkRecordRepository extends JpaRepository<WorkRecord, Long> {

    Optional<WorkRecord> findByMemberAndCheckOutIsNull(Member member);
}
