package richard.lipa.Api_ForoHub;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@SpringBootApplication
public class ApiForoHubApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiForoHubApplication.class, args);
	}



	/*@Bean
	@Profile("!prod") // Esto significa que se ejecutará en cualquier perfil EXCEPTO 'prod'
	public CommandLineRunner flywayRepairRunner(Flyway flyway) {
		return args -> {
			System.out.println("------------------------------------");
			System.out.println("  Ejecutando Flyway Repair...      ");
			System.out.println("  ¡IMPORTANTE! Eliminar este código");
			System.out.println("  después de que el repair se complete.");
			System.out.println("------------------------------------");

			flyway.repair(); // Ejecuta el comando repair

			System.out.println("Flyway Repair completado.");
			System.out.println("------------------------------------");
			// Opcional: System.exit(0); si quieres que la app se detenga después del repair
		};
	}*/



}
