package ir.shortnr.controllers;

import ir.shortnr.models.request.URLShortenRequest;
import ir.shortnr.models.response.ShortenedURLResponse;
import ir.shortnr.services.ShortnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/short")
@RestController
public class ShortnController {
    private final ShortnService shortnService;

    @Autowired
    public ShortnController(ShortnService shortnService) {
        this.shortnService = shortnService;
    }

    @PostMapping
    public ShortenedURLResponse post(@RequestBody URLShortenRequest body) {
        return new ShortenedURLResponse(shortnService.shortn(body.getUrl()), body.getUrl());
    }
}
