
node(){
   stage("git checkout"){
      checkout scm
     
   }
	
	stage("check mvn"){
	def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
	sh "${mvnHome}/bin/mvn -v"
	
	}	
  stage("Build"){
    
    def directory = "devtest1"
		dir(directory){
      
            sh "mvn -v"
		}	
      }
  
}
