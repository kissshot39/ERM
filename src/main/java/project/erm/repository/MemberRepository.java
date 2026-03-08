package project.erm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.erm.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
