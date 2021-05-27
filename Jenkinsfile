
node(){
   stage("git checkout"){
      checkout scm
     
   }
	
	stage("check mvn"){
	sh "mvn -v"
	}	
  stage("Build"){
    
    def directory = "devtest1"
		dir(directory){
      
            sh "mvn -v"
		}	
      }
  
}
