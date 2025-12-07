pipeline {
    agent any

    environment {
        DB_LOGIN = credentials('db-login')
        DB_HOST = credentials('db-host')
    }
    
    stages {
       stage('RUN SQL') {
         steps {
            sh '''
               /usr/local/bin/mysql/mysql -u "$DB_LOGIN_USR" \
                     -p"$DB_LOGIN_PSW" \ 
                     -h "$DB_HOST" \
                     -e "select 1;"
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
