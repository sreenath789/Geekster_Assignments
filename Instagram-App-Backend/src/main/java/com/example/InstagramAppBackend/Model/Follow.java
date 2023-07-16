package com.example.InstagramAppBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;

    @OneToOne
    @JoinColumn(name = "fk_actual_user")
    User currentUser;

    @OneToOne
    @JoinColumn(name = "fk_follower_of_actual_user")
    User currentUserFollower;

}
