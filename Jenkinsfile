

node(){
   stage("git checkout"){
      checkout scm
      sh "pwd"
      sh "ls -l"
   }
   stage("Build and UT"){
      sh "pwd"
      sh "cd /var/lib/jenkins/workspace/muralipipeline/devtest1"
      sh "pwd"
      sh "ls -l"
      sh "mvn package"
      
      
}

}
