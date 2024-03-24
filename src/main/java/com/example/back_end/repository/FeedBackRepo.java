package com.example.back_end.repository;

import com.example.back_end.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepo extends JpaRepository<Feedback,Long> {

    @Query("SELECT f, u.userFirstName, u.userLastName FROM Feedback f JOIN User u ON f.userId = u.userId")
    List<Object[]> findAllFeedbackWithUserName();

}
