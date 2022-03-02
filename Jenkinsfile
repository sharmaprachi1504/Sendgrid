pipeline {

  agent any
  tools {
        maven "MAVEN_HOME"
        jdk "JAVA_HOME"
    }
  //{
        //docker {
          //  image 'maven:3.8.1-adoptopenjdk-11'
            //args '-v $HOME/.m2:/root/.m2'
        //}}

//change
    stages {

         stage('Building Project') {
            steps {
                  sh 'mvn clean package'
                  }   
                                  }
    
        
        stage('SonarQube Analysis') {
            steps{
                
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.38:8085'
                 }
                                    }//docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:5.5
                                    
        
      /* stage('Uploading Artifacts') {
           steps {
               script {
                   def server = Artifactory.server 'Artifactory'
                   def buildInfo = Artifactory.newBuildInfo()
                   buildInfo.env.capture = true
                   buildInfo.env.collect()

                   def uploadSpec = """{
                       "files": [{
                           "pattern": "?",
                           "target": "example-repo-local" },
                                 {
                          "pattern": "?",
                          "target": "example-repo-local"},
                                 {
                          //"pattern": "?",
                          "target": "example-repo-local"
                                }]
                                   }"""
                   //Note:?=**///target/*.jar
            /*       server.upload spec: uploadSpec, buildInfo: buildInfo
                   server.publishBuildInfo buildInfo      
                       }
                   }
                                   }
    
    
    stage('Building Docker Image') {
        steps {
            script {
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
                   }
              }
                                   }
    stage('Pushing Docker-Image to DockerHub') {
        steps {
            script {
                docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
             // docker run -d -p 8090 ${dockerImage}
                                                              }
                   }
              }
                                               }
          }  */
     }
}
