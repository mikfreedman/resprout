Resprout
 

![Circle CI Badge](https://circleci.com/gh/pivotal-sydney/resprout.svg?style=shield&circle-token=75c0d9a89bd59fd0950d53f2148220cddc76b191)



Provisioning workstations can be a pain, this HTTP API will expose metadata for the various recipes and packages that can be used to provision a machine so that a `soloistrc` file can be generated through user selection.

It will hopefully support all the sources listed below.

This is a [Spring Boot](http://projects.spring.io/spring-boot/) project.

## Usage

### Build the JAR using gradle

```bash
./gradlew build
```

### Deployment - Server
Be sure to activate the `production` profile for application instances that run in production. If you would like to schedule a task to update metdata periodically, then activate the profile `production-worker` as well. These profiles will allow you to deploy a single application for both tasks and the API, or API applications and worker applications separately.

You may configure the cron expression controlling the task using the environment variable `RESPROUT_REPOSITORIES_CRON` or its equiavalent application properties key (bean).

#### One Application

```bash
SPRING_PROFILES_ACTIVE=production,production-worker ./gradlew bootRun
```

#### API Application, Worker Application

```bash
SPRING_PROFILES_ACTIVE=production ./gradlew bootRun                     # API Only - route to this instance
SPRING_PROFILES_ACTIVE=production,production-worker ./gradlew bootRun   # Worker   - do not route to this instance.
```

### Deployment - Web Client
From the `client` folder
- Run `npm install`
- Install gulp `npm install -g gulp`
- Use gulp to build the client `gulp build`
- To push to CF just use `cf push` from the `client` folder (it already contains manifest.yml)

### Clients

Build your own client - and interact with it.
  
## Sources

### General

| Status | Source | Description |
|---|---|---|
| Done        | [Homebrew](http://brew.sh/) | The missing package manager for OS X |
| Done        | [Homebrew Cask](http://caskroom.io/) | Binary install plugin for homebrew |
| In Progress | [Chef Supermarket](https://supermarket.chef.io/) | Chef cookbooks for all of your ops needs |

### Sprout

| Status | Source | Description |
|---|---|---|
| Not Done | [sprout-jetbrains-editors](https://github.com/pivotal-sprout/sprout-jetbrains-editors) | Recipes for installing Pivotal&#39;s IDE prefs |
| Not Done | [sprout-ruby](https://github.com/pivotal-sprout/sprout-ruby) | Cookbook for managing ruby related workstation config |
| Not Done | [sprout-wrap](https://github.com/pivotal-sprout/sprout-wrap) | Pivotal Labs uses this project with sprout, soloist and librarian-chef to build developer workstations |
| Not Done | [sprout-base](https://github.com/pivotal-sprout/sprout-base) | A handful of things every Sprout recipe needs. |
| Not Done | [sprout-osx-apps](https://github.com/pivotal-sprout/sprout-osx-apps) | Recipes to install applications on OS X, when homebrew isn&#39;t enough |
| Not Done | [sprout-android](https://github.com/pivotal-sprout/sprout-android) | Manage tools for Android development on OS X |
| Not Done | [sprout-osx-settings](https://github.com/pivotal-sprout/sprout-osx-settings) | Manage various settings &amp; preferences on OS X |
| Not Done | [sprout-mysql](https://github.com/pivotal-sprout/sprout-mysql) | Cookbook for managing mysql on an OSX workstation |
| Not Done | [sprout-rubymine](https://github.com/pivotal-sprout/sprout-rubymine) | Recipes to manage Rubymine on OSX |
| Not Done | [sprout-keycastr](https://github.com/pivotal-sprout/sprout-keycastr) | Installs and configures KeyCastr |
| Not Done | [sprout-git](https://github.com/pivotal-sprout/sprout-git) | Recipes to manage git on OS X |
| Not Done | [sprout-chruby](https://github.com/pivotal-sprout/sprout-chruby) | Manage chruby on OS X |
| Not Done | [sprout-homebrew](https://github.com/pivotal-sprout/sprout-homebrew) | contains meta recipe to install homebrew casks and formulae using attributes defined in soloistrc only |
| Not Done | [sprout-rbenv](https://github.com/pivotal-sprout/sprout-rbenv) | Recipes to manage rbenv on OS X |
| Not Done | [sprout-redis](https://github.com/pivotal-sprout/sprout-redis) | Cookbok for managing redis on an OS X workstation |
| Not Done | [sprout-terminal](https://github.com/pivotal-sprout/sprout-terminal) | A Chef Cookbook of Recipes to Configure the Terminal Application |
| Not Done | [sprout-postgresql](https://github.com/pivotal-sprout/sprout-postgresql) | pivotal-sprout/sprout-postgresql |
| Not Done | [sprout-ssh](https://github.com/pivotal-sprout/sprout-ssh) | Cookbook to configure ssh on an OS X developer workstation |
| Not Done | [osx](https://github.com/pivotal-sprout/osx) | Useful LWRPs for managing OSX settings |
| Not Done | [sprout-vim](https://github.com/pivotal-sprout/sprout-vim) | Cookbok for managing vim on an OS X workstation |
| Not Done | [sprout-exemplar](https://github.com/pivotal-sprout/sprout-exemplar) | Template repo for creating standalone cookbooks |
| Not Done | [sprout-orchard](https://github.com/pivotal-sprout/sprout-orchard) | Sprout Orchard (where you grow trees) is a set of programs which support the taking of snapshots of disks of successfully-run chef scripts |

## Related

| Project | |
|---|---|
| [Workstation Setup](https://github.com/pivotal/workstation-setup) |  This project automates the process of setting up a new Pivotal Labs machine using a simple Bash script. |
| [Pivotal Sprout](https://github.com/pivotal-sprout) | Chef recipes to configure an OS X developer workstation. |
| [Soloist](https://github.com/mkocher/soloist) | Quickly and easily converge Chef recipes using chef-solo. |
