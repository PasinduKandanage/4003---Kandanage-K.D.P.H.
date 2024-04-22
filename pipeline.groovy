pipeline {
  agent any
  triggers{
    githubPush()
  }
  stages {
    stage('build'){
      steps {
        sh 'docker build -t 4003-docker-image .'
      }
    }
    stage('run'){
      steps{
        sh 'docker run -d -p 3000:3000 4003-docker-image'
      }
    }
    stage('status'){
      steps{
        sh 'docker ps'
      }
    }
  }
}
