

node(){
   stage("git checkout"){
      checkout scm
      sh "pwd"
      sh "ls -l"
   }
   stage("Build and UT"){
      sh "cd devtest1"
      sh "mvn package"
      sh "ls -l"
      
}

}
