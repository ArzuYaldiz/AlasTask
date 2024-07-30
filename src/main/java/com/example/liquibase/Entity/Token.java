package com.example.liquibase.Entity;

import jakarta.persistence.*;
import lombok.*;

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

    public int getRevoked() {
        return revoked;
    }

    public void setRevoked(int revoked) {
        this.revoked = revoked;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }
}
