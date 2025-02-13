package com.github.melihemreguler.urlshortener.controller;

import com.github.melihemreguler.urlshortener.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Slf4j
public class RedirectController {

    private final UrlService urlService;

    // Constructor for dependency injection of UrlService
    @Autowired
    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    /**
     * Redirects the user from a short code to the original long URL.
     *
     * @param shortCode The short code to be resolved to the long URL.
     * @return A RedirectView to the original long URL.
     */
    @GetMapping("/{shortCode}")
    public RedirectView redirectToLongUrl(@PathVariable String shortCode) {
        log.info("Received request to redirect short code: {}", shortCode);

        // Fetches the corresponding long URL for the provided short URL
        String longUrl = urlService.getLongUrl(shortCode);
        log.info("Redirecting to long URL for short code: {}, long URL: {}", shortCode, longUrl);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(longUrl);
        return redirectView;
    }
}