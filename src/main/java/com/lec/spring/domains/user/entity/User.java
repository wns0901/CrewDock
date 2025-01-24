package com.lec.spring.domains.user.entity;

import com.lec.spring.domains.project.entity.ProjectMember;
import com.lec.spring.global.common.entity.BaseEntity;
import com.lec.spring.global.common.entity.Position;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = true)
    private String githubUrl;

    @Column(nullable = true)
    private String notionUrl;

    @Column(nullable = true)
    private String blogUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position hopePosition;

    private String provider;

    private String providerId;

    private String selfIntroduction;

    private String profileImgUrl;

    @OneToMany(mappedBy = "user")
    private List<UserAuth> userAuths = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ProjectMember> projectMembers = new ArrayList<>();
}
