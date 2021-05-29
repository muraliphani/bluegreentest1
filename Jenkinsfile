
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
	stage("Download artifact from S3"){
		sh "mkdir ${workspace}/artifactory"
		def sourcepath = "${workspace}/artifactory"
		
		withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'madhuawsid', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
		s3Download(file:sourcepath, bucket:'bucket1-madhu', path:'project1/devtest1.war', force:true)	
			
  		 
}
		sh "cd /${workspace}/artifactory"
		sh "ls -l"
		
	
	
	}
  
}
