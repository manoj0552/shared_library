def call (body) {
      def config = [:]
      body.resloveStrategy = Closure.DELEGATE_FIRST
      body.delegate = config
      body()


      node(any){
          stage('checkout'){
                gitCheckout()

          }
          stage('package'){
                gradlePackage()

          }



      }
      }
