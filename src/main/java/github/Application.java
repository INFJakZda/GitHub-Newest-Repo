package github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static final String noRepoUrl = "https://api.github.com/orgs/allegro";
    private static final String repoInfoUrl = "https://api.github.com/orgs/allegro/repos?per_page=";

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            //GET number of public repos
            PublicRepo publicRepo = restTemplate.getForObject(noRepoUrl, PublicRepo.class);

            log.info("No of Public Repos " + publicRepo.getNoPublicRepos().toString());

            //GET all repos from github api
            ResponseEntity<List<RepoInfo>> rateResponse =
                    restTemplate.exchange(repoInfoUrl + publicRepo.getNoPublicRepos(),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<RepoInfo>>() {
                            });
            List<RepoInfo> repos = rateResponse.getBody();

            //Find the last mod repo
            RepoList repoList = new RepoList(repos);

            RepoInfo repoInfo = repoList.getLastMod();

            log.info("Last pushed repo Name: " + repoInfo.getName() + ", Date: " + repoInfo.getPushedAt());
        };
    }

}