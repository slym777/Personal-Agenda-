package com.endava.project.proxies;

import com.endava.project.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.util.Optional;


@Service
public class DiaryProxy {

    private RestTemplate restTemplate;

    @Autowired
    public DiaryProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${diary.service.url}")
    private String diaryServiceUrl;

    public void addEntryToDiary(Entry entry) {
        String url = diaryServiceUrl + "/addEntry/" +
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        restTemplate.postForLocation(url, entry);
    }

    public void deleteEntry(int id) {
        String url = diaryServiceUrl + "/delete/" + id;
        restTemplate.delete(url);
    }

    public Optional<Entry> getEntry(int id) {
        String url = diaryServiceUrl + "/getEntry/" + id;
        return restTemplate.getForObject(url, Optional.class);
    }

    public void updateTitle(int id, String title) {
        String url = diaryServiceUrl + "/updateTitle/" + id;
        restTemplate.postForLocation(url, null);
    }

    public void updateEntryText(int id, String text) {
        String url = diaryServiceUrl + "/updateTitle/" + id;
        restTemplate.postForLocation(url, null);
    }


}
