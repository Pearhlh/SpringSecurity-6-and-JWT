package HCodeUI.JWTDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }
//	@Bean
//	@Transactional
//	public CommandLineRunner runner(UserRepository userRepository){
//		return runner -> {
//			var admin = User.builder()
//					.firstname("Le")
//					.lastname("Gia Huy")
//					.email("LHuy1902003@gmail.com")
//					.username("huycode14")
//					.password("huy@123456")
//					.role(ADMIN)
//					.build();
//			var manager = User.builder()
//					.firstname("Le")
//					.lastname("Gia Hung")
//					.username("tiabomay")
//					.email("tiabomay@mail.com")
//					.password("huy@123456")
//					.role(MANAGER)
//					.build();
//			userRepository.save(admin);
//			userRepository.save(manager);
//		};
//	}
}
