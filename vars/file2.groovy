
def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
    sh "echo ${config.projectName}" 
  }
  

}
