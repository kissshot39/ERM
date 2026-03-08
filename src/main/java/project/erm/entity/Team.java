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
    private String teamName;

    @Column(nullable = true)
    private String managerName;

    private Long memberCount;

    @Builder
    public Team(
            String teamName,
            String managerName,
            Long memberCount) {
        this.teamName = teamName;
        this.managerName = managerName;
        this.memberCount = memberCount;
    }

}
