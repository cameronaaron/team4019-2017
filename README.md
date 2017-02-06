# FIRST Robotics Team 4019 GitHub Repository
[![CircleCI](https://circleci.com/gh/Team4019/team4019-2017.svg?style=svg)](https://circleci.com/gh/Team4019/team4019-2017)
## Instructions on getting the repository set up locally
### For Examination and deploying
Make sure you have a version of JDK or JRE installed, you can find those [here](). Download the latest version of the repository onto your local drive. Have your robot turned on and connect to its network from your computer. Navigate to the newly downloaded directory with your terminal application of choice. Open the `build.gradle` file with your text editor of choice and find the variable named `gradlerio.team` and change its value to your team number. We are using [GradleRIO]() to build and deploy to the robot. To build and deploy, use the following commands accordingly:
```bash
./gradlew build
```
```bash
./gradlew deploy
```
Some things to keep track of, when you run `deploy`, it automatically builds if it hasn't already, so you do not have to run `build` every time you want to deploy. Another thing is, if you are getting an error when trying to build or deploy, try running `build` when you are connected to the internet. I'm not sure why this happens, but it seems to be something with the local gradle setup getting the latest files or something.
### For Development
Firstly, you need to set up an IDE to use. For developing our code, we use JetBrain's IntelliJ. You can find the installation instructions for IntelliJ [here](https://www.jetbrains.com/idea/). Once installed, download a copy of the repository and open it up in IntelliJ. You are now ready to examine the code. Using IntelliJ's built in gradle support, you can build and deploy directly from inside IntelliJ.
### For Contributing
In order to contribute to the source code, you need to have the git command-line tools installed. You can find installation instructions for git [here](). Instead of downloading the repository, you now need to clone it. Technically, you can start contributing right from there if you understand how to use git. However, if you are not very proficient in using git from the command line, we recommend using [GitKraken](). GitKraken provides a very simple to use graphical interface for version control systems.
## Rules for Contributing
We enforce several guidelines for commiting and pushing code to the repository. We do this because it allows us to more easily monitor if the code breaks and easily fix it if it does. These rule include:
* No pushing or commiting to `master`
* Do directly commiting or pushing to `develop`, merge into it with a pull request
* When writing any code, it should be done in a new branch that's name explains what is being developed.
* Each individual branch should only be used for developing a specific feature, no making multiple features in one branch unless it makes sense to do so.
* Any new branches should be created directly off of `develop`, or any other feature branch
* When finishing a feature, a pull request should be made into the `develop` branch from your feature branch, this pull request will then be examined by a programming captain and correctly merged into `develop`. The captains will decide when to merge `develop` into `master`.
