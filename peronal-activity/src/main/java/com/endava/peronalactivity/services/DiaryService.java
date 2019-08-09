package com.endava.peronalactivity.services;

import com.endava.peronalactivity.entities.Diary;
import com.endava.peronalactivity.entities.Entry;
import com.endava.peronalactivity.respositories.DiaryRepository;
import com.endava.peronalactivity.respositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private EntryRepository entryRepository;

    public void addEntry(String username, Entry entry) {
        Diary diary = diaryRepository.getDiaryByUsername(username);
        if(diary == null) {
            diary = new Diary();
            diary.setUsername(username);
            diaryRepository.save(diary);
        }
        LocalDate date = LocalDate.now();
        entry.setDate(Date.valueOf(date));
        entry.setDiaryId(diary.getId());
        entryRepository.save(entry);
    }


}
