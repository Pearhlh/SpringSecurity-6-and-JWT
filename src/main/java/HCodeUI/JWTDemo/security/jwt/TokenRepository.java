package HCodeUI.JWTDemo.security.jwt;

import HCodeUI.JWTDemo.security.jwt.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
    @Query("SELECT t" +
            " from Token t " +
            "inner join fetch t.user u " +
            "where u.id = :id"
    )
    List<Token> findAllValidTokenByUser(long id);
}
