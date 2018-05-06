# GitHub-Newest-Repo
REST service which returns last modified Repository of given organisation.

## What can you do?

It's a service that gets info about github repository & returns last modified repo of given organisation:

## How does it work?

It retrieves web page data with Spring's RestTemplate.

It gets info from github api

```
https://api.github.com
```
To get number of repositories:
```
GET /orgs/:org
```
To get each of repositories to retrieve info about last modification:
```
GET /orgs/:org/repos
```
