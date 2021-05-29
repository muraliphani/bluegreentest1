
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
	
	stage("Upload artifact to S3"){		
	  
	withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'madhuawsid', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
  		 s3Upload bucket: 'bucket1-madhu', file: '/var/lib/jenkins/workspace/testpipeline/devtest1/target/devtest1.war', path: 'project1/'
}
		
		
		
	
	}	
  
}
