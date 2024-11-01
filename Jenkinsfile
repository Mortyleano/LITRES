pipeline {
    agent any
    environment {
        LOGIN = credentials('LOGIN')
        PASSWORD = credentials('PASSWORD')
    }
    stages {
        stage('Prepare Configuration') {
            steps {
                script {
                    sh """
                        cp src/test/resources/properties/auth.properties.template src/test/resources/properties/auth.properties
                        sed -i 's/\\${LOGIN}/$LOGIN/g' src/test/resources/properties/auth.properties
                        sed -i 's/\\${PASSWORD}/$PASSWORD/g' src/test/resources/properties/auth.properties
                    """
                }
            }
        }
    }
}