

node(){
   stage("git checkout"){
      checkout scm
      sh "pwd"
      sh "ls -l"
   }
   stage("Build and UT"){
      def directory = "devtest1"
		dir(directory){
            sh "mvn package"
      }
	   
	stage("Upload to s3"){
	   withAWS(credentials: 'awscredentials', region: 'us-east-1') {
    		
		   s3Upload acl: 'Private', bucket: 'devtest007', cacheControl: '',			    
			   file: 'devtest1.war',		  
			   path: '/devops/devtest1',			    
			   workingDir: '/var/lib/jenkins/workspace/muralipipeline/devtest1/target'
             }
		
	   
	   }	   
      
}

}
