package com.endava.peronalactivity.respositories;

import com.endava.peronalactivity.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DiaryRepository extends JpaRepository<Diary, Integer> {

    Diary getDiaryByUsername(String username);
}
