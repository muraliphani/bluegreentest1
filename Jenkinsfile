
node(){
   stage("git checkout"){
      checkout scm
     
   }
		
  stage("Build"){
    def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
    def directory = "devtest1"
		dir(directory){
      
            sh "${mvnHome}/bin/mvn package"
		}	
      }
  
}
