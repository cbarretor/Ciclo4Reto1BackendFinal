package usa.ElMercader;

import usa.ElMercader.modelo.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import usa.ElMercader.repositorios.ClienteRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"usa.ElMercader"})

public class ElMercaderApplication {

@Autowired
private ClienteRepository repoClient;

public static void main(String[] args) {
    SpringApplication.run(ElMercaderApplication.class, args);
}

@Bean
ApplicationRunner applicationRunner() {
    return args -> {
        System.out.println("APLICACION INICIADA!.");
        List<Client> cs = repoClient.getAll();
        System.out.println("Clientes: " + cs.size());
    };
}

@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("*");
        }
    };
}

}
