def call(String nvdKey){
    // Added '--purge' to delete the corrupted database
    dependencyCheck additionalArguments: "--scan ./ --nvdApiKey ${nvdKey} --purge", odcInstallation: 'OWASP'
    
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}