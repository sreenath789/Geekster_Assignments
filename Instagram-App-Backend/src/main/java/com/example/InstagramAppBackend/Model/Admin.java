package com.example.InstagramAppBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String adminName;
    @Pattern(regexp = "^.+@instaAdmin\\.com$")
    private String adminEmail;
    private String adminPassword;
}
