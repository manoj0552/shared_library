def call(body) {

        def config = [:]
        body.resloveStrategy = closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
          stage('checkout'){
                gitCheckout()

          }
          stage('package'){
                gradlePackage()

          }



      }
      }
