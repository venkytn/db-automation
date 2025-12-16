pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        git branch: 'master', url: 'https://github.com/venkytn/db-automation.git'
      }
    }
    stage('Dev') {
      steps {
         echo "Executing Dev"
      }
    }
    stage('Stage') {
      steps {
         echo "Executing Stage"
      }
    }
    stage('Prod') {
      steps {
         echo "Executing Prod"
      }
    }
  }
}
