pipeline {
    agent any
    tools {
        maven '3.9.1'
    }

    stages {

        stage ('Checkout'){
            steps{
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/PriyankaV12/Jira-API.git',

                    ]]
                ])
            }
        }



        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"

                '''
            }
        }

        stage('Download ChromeDriver') {
            steps {
                sh "curl -o chromedriver_mac64.zip https://chromedriver.storage.googleapis.com/112.0.5615.49/chromedriver_mac64.zip"
                sh "unzip -o ./chromedriver_mac64.zip -d ./"
                sh "chmod +x ./chromedriver"
            }
        }

        stage('Create secrets.yaml') {

            environment{
                pass = credentials('PASSWORD')
                url = credentials('JIRA-URL')
                username = credentials('USERNAME')

            }

                steps {

                // Create secrets.yaml file
                sh 'touch src/main/java/myResources/secrets.yaml'
                // Add values to secrets.yaml
                sh 'echo "baseURI:  $url" > src/main/java/myResources/secrets.yaml'
                sh 'echo "username: $username" >> src/main/java/myResources/secrets.yaml'
                sh 'echo "password: $pass" >> src/main/java/myResources/secrets.yaml'

            }
        }

         stage ('Run Tests') {
            steps {
                sh 'ls -al'
                sh 'mvn test'

            }

        }
    }
}