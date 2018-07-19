def call(body){

      def config = [:]
      body.resolveStrategy = Closure.DELEGATE_FIRST
      body.delegate = config
      body()

      node{
          stage('checkout'){
          gitCheckout()
          }

          stage('build'){
          gradlePackage()
          }

          stage('UnitTest'){
          //    sonarQubaTest()

          }
          stage('s3_upload'){
          sh "echo $pwd"

           withAWS(credentials:'amazon'){
           s3Upload(file:'helloworld.war',bucket:'warfiles-sample',path:'C:\Users\manoj\.jenkins\workspace\pipeline-code\shared_library\share_Pipeline\target\helloworld.war')

           }
          }

      }


}
