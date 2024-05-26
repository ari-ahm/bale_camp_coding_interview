package ir.shortnr.services;

import ir.shortnr.repositories.ShortListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetService {
    private final ShortListRepository shortListRepository;

    @Autowired
    public GetService(ShortListRepository shortListRepository) {
        this.shortListRepository = shortListRepository;
    }

    public String getUrl(String token) {
        var ret = shortListRepository.findByShortndUrl(token);
        if (ret.isPresent())
            return ret.get().getUrl();
        else {
            return null;
        }
    }
}
