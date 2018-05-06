package github;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicRepo {

    @JsonAlias("public_repos")
    private Integer noPublicRepos;

    public PublicRepo() {

    }

    public Integer getNoPublicRepos() {
        return noPublicRepos;
    }

    public void setNoPublicRepos(Integer noPublicRepos) {
        this.noPublicRepos = noPublicRepos;
    }
}
