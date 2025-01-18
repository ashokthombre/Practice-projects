package com.imageuploader.repositories;

import com.imageuploader.models.ImageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageDetails,Long> {

}
