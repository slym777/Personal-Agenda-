package com.endava.project.controllers;

import com.endava.project.models.Entry;
import com.endava.project.proxies.DiaryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryProxy diaryProxy;


    @PostMapping("/addEntryToDiary")
    public void addEntryToDiary(@RequestBody Entry entry) {
        diaryProxy.addEntryToDiary(entry);
    }

    @PostMapping("/deleteEntry/{id}")
    public void deleteEntry(@PathVariable int id) {
        diaryProxy.deleteEntry(id);
    }

    @PostMapping("/getEntry/{id}")
    public Optional<Entry> getEntry(@PathVariable int id) {
        return diaryProxy.getEntry(id);
    }

    @PostMapping("/updateTitle/{id}")
    public void updateTitle(@PathVariable int id, @RequestBody String title) {
        diaryProxy.updateTitle(id, title);
    }

    @PostMapping("/updateEntryText/{id}")
    public void updateEntryText(@PathVariable int id, @RequestBody String text) {
        diaryProxy.updateEntryText(id, text);
    }

}
