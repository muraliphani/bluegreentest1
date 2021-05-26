
node(){
   stage("git checkout"){
      checkout scm
     
   }
  stage("Build"){
    
    def directory = "devtest1"
		dir(directory){
      
            sh "mvn package"
      }
  
}
