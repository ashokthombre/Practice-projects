package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    private String userId;


    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();




}
