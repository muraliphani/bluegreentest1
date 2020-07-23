

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
	   withAWS(credentials: 'awscredentials', region: 'US East (N. Virginia)') {
    		
		   s3Upload acl: 'Private', bucket: 'devtest007', cacheControl: '', 
			   excludePathPattern: '', 
			   file: 'devtest1.war', 
			   includePathPattern: '',
			   metadatas: [''], 
			   path: '/var/lib/jenkins/workspace/muralipipeline/devtest1/target', 
			   redirectLocation: '',
			   sseAlgorithm: '', 
			   text: '', 
			   workingDir: '/var/lib/jenkins/workspace/muralipipeline'
             }
		
	   
	   }	   
      
}

}
