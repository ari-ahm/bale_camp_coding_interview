package ir.shortnr.controllers;

import ir.shortnr.services.GetService;
import ir.shortnr.services.ShortnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class RootController {
    private final GetService getService;

    @Autowired
    public RootController(GetService getService) {
        this.getService = getService;
    }

    @GetMapping("/{path}")
    public RedirectView index(@PathVariable("path") String path) {
        String ret = getService.getUrl(path);
        if (ret == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        return new RedirectView(ret);
    }
}
