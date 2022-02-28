pipeline {
    environment {
        registry = "narendrakumar02/aqt_practice_data"
        registryCredential = 'Docker_Token'
        dockerImage = ''
        //scannerHome = tool 'SonarScanner 4.0'
               }
    
    agent any
    
    stages {
        stage('Building Project') {
            steps {
                bat 'mvn clean install'
                bat 'mvn jacoco:prepare-agent test jacoco:report'
                  }   
                           }
    
        
      stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('Sonar_server') {
                   bat 'mvn sonar:sonar'
                }
            }
        }
        stage("Quality gate") {
            steps {
               //timeout(time: 1, unit: 'MINUTES'){ 
               waitForQualityGate abortPipeline: true
            ///}
        }
        }
       stage('Uploading Artifacts') {
           steps {
               script {
                   def server = Artifactory.server 'Artifactory'
                   def buildInfo = Artifactory.newBuildInfo()
                   buildInfo.env.capture = true
                   buildInfo.env.collect()

                   def uploadSpec = """{
                       "files": [{
                           "pattern": "**/target/*.jar",
                           "target": "example-repo-local" },
                                 {
                          "pattern": "**/target/*.pom",
                          "target": "example-repo-local"},
                                 {
                          "pattern": "**/target/*.war",
                          "target": "example-repo-local"
                                }]
                                   }"""
                   
                   server.upload spec: uploadSpec, buildInfo: buildInfo
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
          }
     
post {
       failure {
      bat 'curl --request POST --url "https://narendrakumar02.atlassian.net/jira" --user "narendrakumar02@nagarro.com:cEerNJ7f2dtsmjHz1UjBE1EC" --header "Accept:application/json" --header "Content-Type:application/json" --data {"fields":{"project":{"key":"JWA"},"summary":"created for j","description":"Created for j","issuetype":{"name":"Task"}}}'
           
       }
   }           
}