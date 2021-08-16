package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Socialmedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaRepository extends JpaRepository<Socialmedia,String> {
    //List<Socialmedia> findByPlatform(String platform);
}
