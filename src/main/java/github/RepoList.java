package github;

import java.util.List;

public class RepoList {

    private List<RepoInfo> reposList;

    RepoList (List<RepoInfo> reposList) {
        this.reposList = reposList;
    }

    public RepoInfo getLastMod() {
        RepoInfo repoInfoReturn = null;
        String dateLastModRepo = "2000-01-01T01:00:00Z";

        for(RepoInfo repoInfo: reposList) {
            if(repoInfo.getPushedAt().compareTo(dateLastModRepo) > 0) {
                repoInfoReturn = repoInfo;
                dateLastModRepo = repoInfo.getPushedAt();
            }
        }

        return repoInfoReturn;
    }

    public List<RepoInfo> getReposList() {
        return reposList;
    }

    public void setReposList(List<RepoInfo> reposList) {
        this.reposList = reposList;
    }
}
