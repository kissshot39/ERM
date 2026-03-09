package project.erm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.erm.domain.Role;
import project.erm.entity.Member;
import project.erm.entity.Team;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String managerName);

    Optional<Member> findByTeamAndRole(Team team, Role role);
}
