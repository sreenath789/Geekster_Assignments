package com.example.InstagramAppBackend.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "post_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likeId;
    @ManyToOne
    @JoinColumn(name = "fk_post_like_id")
    private Post instaPost;

    @ManyToOne
    @JoinColumn(name = "fk_liker_id")
    private User liker;
}
