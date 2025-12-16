pipeline {
    agent any

    environment {
        DB_LOGIN = credentials('db-login')
        DB_HOST = credentials('db-host')
    }
    stages {
       stage('Checkout') {
         steps {
                 git branch: 'master', url: 'https://github.com/venkytn/db-automation.git'
               }
         }
       stage('RUN SQL') {
         steps {
            sh '''
               /usr/local/bin/mysql -u "$DB_LOGIN_USR" -p"$DB_LOGIN_PSW" -h "$DB_HOST" < sql/check.sql
            '''
         }
       }
       stage('Debug') {
         steps {
           sh '''
              echo "DB User: $DB_LOGIN_USR"
              echo "DB Password: $DB_LOGIN_PSW"
              echo "DB Host: $DB_HOST"
           '''
        }
      }
    }
}
