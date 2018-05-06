package github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        PublicRepo publicRepo = restTemplate.getForObject("https://api.github.com/orgs/allegro", PublicRepo.class);
        log.info(publicRepo.getNoPublicRepos().toString());
    }

}