package ir.shortnr.repositories;

import ir.shortnr.models.ShortndURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortListRepository extends JpaRepository<ShortndURL, String> {
    Optional<ShortndURL> findByShortndUrl(String shortndUrl);
    Optional<ShortndURL> findByUrl(String url);
}
