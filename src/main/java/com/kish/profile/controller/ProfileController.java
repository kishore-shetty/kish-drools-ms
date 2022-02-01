package com.kish.profile.controller;

import com.kish.profile.domain.Profile;
import com.kish.profile.repository.ProfileRepository;
import com.kish.profile.request.ProfileRequest;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public/v1")
@Slf4j
public class ProfileController {

    private final KieContainer kieContainer;

    private final ProfileRepository profileRepository;

    public ProfileController(KieContainer kieContainer, ProfileRepository profileRepository) {
        this.kieContainer = kieContainer;
        this.profileRepository = profileRepository;
    }

    @GetMapping(value = "/profile")
    public List<Profile> getAllProfile(){
        log.info("IN: ProfileController - getAllProfile");
        return  profileRepository.findAll();
    }

    @PostMapping(value = "/profile")
    public ResponseEntity<Void> saveProfile(@RequestBody ProfileRequest profileRequest){
        log.info("IN: ProfileController - saveProfile");

        ProfileRequest profileRequestPostRule = applyRules(profileRequest);

        profileRepository.save(new Profile(profileRequestPostRule));

        log.info("OUT: ProfileController - saveProfile");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private ProfileRequest applyRules(ProfileRequest profileRequest) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(profileRequest);
        Map<String, String> defaultedMap = new HashMap<>();
        kieSession.insert(defaultedMap);
        kieSession.fireAllRules();
        kieSession.dispose();
        return profileRequest;
    }
}
