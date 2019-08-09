package com.endava.peronalactivity.respositories;

import com.endava.peronalactivity.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

    @Query("UPDATE Entry e SET e.title=:newTitle WHERE e.id=:id")
    @Modifying
    @Transactional
    void updateTitle(int id, String newTitle);


}
