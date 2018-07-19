
def call(){
      checkout scm[
      $class:'GitSCM',
      branches:[[name:'*/master']],
      userRemoteConfigs:[[credetialsId:'fbd8b275-22c9-4cb1-8645-7f9d51e92fee',
      Url:'https://github.com/manoj0552/simple-maven-project-with-tests.git']]
      ]

}
