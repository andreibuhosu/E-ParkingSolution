package acb54.eparkingsolution;

import acb54.eparkingsolution.model.Card;
import acb54.eparkingsolution.model.User;
import acb54.eparkingsolution.repository.CardRepository;
import acb54.eparkingsolution.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EParkingSolutionApplication implements ApplicationRunner {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public EParkingSolutionApplication(CardRepository cardRepository,
                                       UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EParkingSolutionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        Card card1 = new Card();
        card1.setId(1L);
        card1.setCardNumber("4242 4242 4242 4242");
        card1.setExpirationDate("24 24");
        card1.setSecurityCode("123");
        card1.setAccepted(true);
        cardRepository.save(card1);

        Card card2 = new Card();
        card2.setId(2L);
        card2.setCardNumber("2424 2424 2424 2424");
        card2.setExpirationDate("24 24");
        card2.setSecurityCode("123");
        card2.setAccepted(false);
        cardRepository.save(card2);

        User driver = new User();
        driver.setId(1);
        driver.setUsername("driver");
        String password = "driver1";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        driver.setPassword(hashedPassword);
        driver.setAddress("LE3 0AD");
        driver.setRole("Driver");
        userRepository.save(driver);

        User parkingOwner = new User();
        parkingOwner.setId(2);
        parkingOwner.setUsername("po");
        String password2 = "po1";
        String hashedPassword2 = passwordEncoder.encode(password2);
        parkingOwner.setPassword(hashedPassword2);
        parkingOwner.setAddress("LE3 0AD");
        parkingOwner.setRole("Parking Owner");
        userRepository.save(parkingOwner);

        User siteAdministrator = new User();
        siteAdministrator.setId(3);
        siteAdministrator.setUsername("sa");
        String password3 = "sa1";
        String hashedPassword3 = passwordEncoder.encode(password3);
        siteAdministrator.setPassword(hashedPassword3);
        siteAdministrator.setAddress("LE3 0AD");
        siteAdministrator.setRole("Site Administrator");
        userRepository.save(siteAdministrator);

    }
}
