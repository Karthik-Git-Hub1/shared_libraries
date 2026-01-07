def gitDownload(repo)
{
  git "https://github.com/IntelliqDevops/${repo}.git"
  
}
def buildArtifact()
{
  sh 'mvn package'
}
def deployTomcat(jobname,ip,context)
{
   sh '''
scp webapp/target/webapp.war \
ubuntu@${}:home/ubuntu/testapp.war
ssh ubuntu@${} "sudo mv /home/ubuntu/testapp.war /var/lib/tomcat10/webapps/testapp.war"
  '''

}
def executeSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
