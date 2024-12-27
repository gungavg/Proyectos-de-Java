package com.example.auth_service_artifact.comons.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name= "users")
public class UserModel {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long userId;
    private String email;
    private String password;
    private String name;
}
