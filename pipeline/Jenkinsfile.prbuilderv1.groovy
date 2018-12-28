#!groovy

def mergePullRequest() {
    step([$class         : 'GhprbPullRequestMerge', 
	allowMergeWithoutTriggerPhrase: false, 
	deleteOnMerge: true,
    disallowOwnCode: false, 
	failOnNonMerge: true, 
	mergeComment: 'Merged', 
	onlyAdminsMerge: false])
}

try {

    node() {


        def mavenHome
   		def currentDir = pwd()
		echo "$currentDir"
		//def GitUtils = load("${currentDir}/utils/GitUtils.groovy")
		//def MiscUtils = load("${currentDir}/utils/MiscUtils.groovy")
		def commitHash = GitUils.getCommitHash()
		def changeLogSets = currentBuild.changeSets
		def currentModules
		
        stage('Clone & Setup') {
            checkout scm
            mavenHome = tool(name: 'maven-3.5.0', type: 'maven');
			
			def changedModules = MiscUtils.getModifiedModules(changeLogSets)
			def category = MiscUtils.getCategory(ghprbCommentBody)
			currentModules = getCurrentModules(changedModules,category)
			
        }
        withEnv([
                'MAVEN_HOME=' + mavenHome,
                "PATH=${mavenHome}/bin:${env.PATH}"
        ]) {
            stage('Build & UT') {
                for (module in currentModules) {
                    dir(module) {
                        sh "'${mavenHome}/bin/mvn' clean test"
                    }
                }
            }
        }
        stage('Merge') {
            currentBuild.result = "SUCCESS"
            if (ghprbCommentBody.startsWith("TM_MERGE")) {
                node("ccone-slave") {
                    checkout scm
                    mergePullRequest()
                }
            }
        }

    }

}
catch (error) {
    currentBuild.result = "FAILURE"
    throw error
}