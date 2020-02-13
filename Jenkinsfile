node {
stage('Checkout') {
echo 'configure started'
git credentialsId:'gopi', url: 'https://gitlab.com/gopikrishnag/jenkins-demo.git'
echo 'configure done'
}
stage('Build') {
sh "${tool 'M3'}/bin/mvn clean install -Dtest=none -Dit.test=none -Dmaven.test.skip=true"
}
stage('Code Quality') {
sh "${tool 'M3'}/bin/mvn sonar:sonar -Dsonar.host.url=http://192.168.43.251:9000"
}
stage('Docker-Build') {
/*sh 'sudo -S true'*/
sh "${tool 'docker'}/bin/docker build -t test ."
}
stage('Deployment'){

sh "${tool 'docker'}/bin/docker run -p 8080:8080 test -d"
}
}
