package com.endava.peronalactivity.respositories;

import com.endava.peronalactivity.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {

    Diary getDiaryByUsername(String username);
}
