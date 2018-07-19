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
          sh "cat '/Users/manoj/.jenkins/workspace/pipeline-code/shared_library/share_Pipeline/target/helloworld.war'"

           withAWS(credentials:'amazon'){
           s3Upload(file:'helloworld.war',bucket:'warfiles-sample',path:'/Users/manoj/.jenkins/workspace/pipeline-code/shared_library/share_Pipeline/target/helloworld.war')

           }
          }

      }


}
