package com.imageuploader.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "imagedetails")
public class ImageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(length = 5000)
    private String imageName;

    @Column(length = 5000)
    private String imageUrl;
}
