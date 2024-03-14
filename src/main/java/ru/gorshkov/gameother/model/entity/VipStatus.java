package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name="vip_status")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VipStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vip_status_seq")
    @SequenceGenerator(name="vip_status_seq", allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime expirationDateVipStatus;
}
