package project.erm.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String managerName;

    private Long memberCount;

    @Builder
    public Team(
            String name,
            String managerName) {
        this.name = name;
        this.managerName = managerName;
        this.memberCount = 0L;
    }

    public void increaseMemberCount() {
        this.memberCount++;
    }

    public void decreaseMemberCount() {
        if (this.memberCount <= 0) {
            throw new IllegalArgumentException(String.format("memberCount : %d", memberCount));
        }
        memberCount--;
    }

    public void changeManagerName(String managerName) {
        this.managerName = managerName;
    }

}
