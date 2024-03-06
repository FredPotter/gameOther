package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Entity
@Table(name="vipStatus")
@Data
public class VipStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date expirationDateVipStatus;
}
