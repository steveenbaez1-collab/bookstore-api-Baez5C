package com.taller.bookstore.config;

import com.taller.bookstore.entity.Author;
import com.taller.bookstore.entity.Book;
import com.taller.bookstore.entity.Category;
import com.taller.bookstore.entity.Role;
import com.taller.bookstore.entity.User;
import com.taller.bookstore.repository.AuthorRepository;
import com.taller.bookstore.repository.BookRepository;
import com.taller.bookstore.repository.CategoryRepository;
import com.taller.bookstore.repository.UserRepository;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(UserRepository userRepository,
                               AuthorRepository authorRepository,
                               CategoryRepository categoryRepository,
                               BookRepository bookRepository,
                               PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByEmail("admin@lecturaypunto.com")) {
                userRepository.save(User.builder()
                        .fullName("Coordinador Catalogo")
                        .email("admin@lecturaypunto.com")
                        .password(passwordEncoder.encode("Catalogo123*"))
                        .role(Role.ROLE_ADMIN)
                        .build());
            }

            if (!userRepository.existsByEmail("cliente@lecturaypunto.com")) {
                userRepository.save(User.builder()
                        .fullName("Cliente Frecuente")
                        .email("cliente@lecturaypunto.com")
                        .password(passwordEncoder.encode("Cliente123*"))
                        .role(Role.ROLE_USER)
                        .build());
            }

            if (authorRepository.count() == 0 && categoryRepository.count() == 0 && bookRepository.count() == 0) {
                Author author1 = authorRepository.save(Author.builder()
                        .name("Isabel Allende")
                        .biography("Autora chilena reconocida por combinar memoria, historia y ficcion.")
                        .email("isabel.allende@lecturaypunto.com")
                        .phone("3001002001")
                        .build());

                Author author2 = authorRepository.save(Author.builder()
                        .name("Haruki Murakami")
                        .biography("Novelista japones conocido por su estilo contemporaneo y atmosferas introspectivas.")
                        .email("haruki.murakami@lecturaypunto.com")
                        .phone("3001002002")
                        .build());

                Category narrative = categoryRepository.save(Category.builder()
                        .name("Narrativa")
                        .description("Novelas y relatos contemporaneos")
                        .build());
                Category globalLiterature = categoryRepository.save(Category.builder()
                        .name("Literatura internacional")
                        .description("Titulos de referencia fuera del ambito local")
                        .build());
                Category magicalRealism = categoryRepository.save(Category.builder()
                        .name("Realismo fantastico")
                        .description("Obras con elementos simbolicos y atmosfericos")
                        .build());

                bookRepository.save(Book.builder()
                        .title("La casa de los espiritus")
                        .isbn("9788401352836")
                        .price(new BigDecimal("54.90"))
                        .stock(18)
                        .description("Saga familiar con memoria historica y elementos fantasticos.")
                        .author(author1)
                        .categories(new HashSet<>(Set.of(narrative, globalLiterature)))
                        .build());

                bookRepository.save(Book.builder()
                        .title("Kafka en la orilla")
                        .isbn("9788490664322")
                        .price(new BigDecimal("62.50"))
                        .stock(22)
                        .description("Novela de viajes interiores con simbolismo, musica y misterio.")
                        .author(author2)
                        .categories(new HashSet<>(Set.of(globalLiterature, magicalRealism)))
                        .build());
            }
        };
    }
}
