package project.erm.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalDateTime checkIn;

    @Column(nullable = true)
    private LocalDateTime checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public WorkRecord(
            Member member,
            LocalDate date,
            LocalDateTime checkIn) {
        this.date = date;
        this.checkIn = checkIn;
        this.member = member;
    }

    public void checkOut(LocalDateTime checkOut) {
        if (this.checkOut != null) {
            throw new IllegalArgumentException("Already checked out");
        }

        this.checkOut = checkOut;
    }


}
