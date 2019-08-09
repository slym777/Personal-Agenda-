package com.endava.peronalactivity.controllers;

import com.endava.peronalactivity.entities.Entry;
import com.endava.peronalactivity.respositories.DiaryRepository;
import com.endava.peronalactivity.respositories.EntryRepository;
import com.endava.peronalactivity.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private DiaryService diaryService;

    @PostMapping("/addEntry/{username}")
    public void addEntry(@PathVariable String username, @RequestBody Entry entry) {
        diaryService.addEntry(username, entry);
    }

    @PostMapping("/delete/{id}")
    public void deleteEntry(@PathVariable int id) {
        entryRepository.deleteById(id);
    }

    @GetMapping("/getEntry/{id}")
    public Optional<Entry> getEntry(@PathVariable int id) {
        return entryRepository.findById(id);
    }

    @PostMapping("/updateTitle/{id}/{title}")
    public void updateTitle(@PathVariable int id, @PathVariable String title) {
        entryRepository.updateTitle(id,title);
    }

    @PostMapping("/updateEntry")
    public void updateEntry(@RequestBody int id, @RequestBody String entryText){

    }



}
