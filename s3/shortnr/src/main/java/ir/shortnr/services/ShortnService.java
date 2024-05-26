package ir.shortnr.services;

import ir.shortnr.models.ShortndURL;
import ir.shortnr.repositories.ShortListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

@Service
public class ShortnService {
    private final ShortListRepository shortListRepository;

    @Autowired
    public ShortnService(ShortListRepository shortListRepository) {
        this.shortListRepository = shortListRepository;
    }

    public String shortn(String url) {
        var existingUrl = shortListRepository.findByUrl(url);
        if (existingUrl != null && existingUrl.isPresent()) {
            return existingUrl.get().getShortndUrl();
        }


        UUID uuid;
        ByteBuffer bb;

        do {
            uuid = UUID.randomUUID();
            bb = ByteBuffer.allocate(8);
            bb.putLong(uuid.getMostSignificantBits());
        } while (shortListRepository.findByShortndUrl(Base64.getUrlEncoder().encodeToString(bb.array()).replace("=", "")).isPresent());

        return shortListRepository.save(new ShortndURL(Base64.getUrlEncoder().encodeToString(bb.array()).replace("=", ""), url)).getShortndUrl();
    }
}
