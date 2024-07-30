package com.example.liquibase.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Integer token_id;

    @Column(name = "token")
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type")
    public TokenType token_type = TokenType.BEARER;

    @Column(name = "revoked")
    public int revoked;

    @Column(name = "expired")
    public int expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_")
    public User user;
}
