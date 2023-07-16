package com.example.InstagramAppBackend.Model;

import com.example.InstagramAppBackend.Model.enums.PostType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String postContent;
    private String postCaption;
    private String postLocation;
    @Enumerated(EnumType.STRING)
    private PostType postType;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime postCreatedTimeStamp;

    @ManyToOne
    @JoinColumn(name = "fk_post_user_id")
    private User postOwner;

}
