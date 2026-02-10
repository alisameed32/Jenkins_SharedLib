def call() {
    // Access the NVD API Key stored in Jenkins Credentials
    withCredentials([string(credentialsId: 'NVD_API_KEY', variable: 'NVD_KEY')]) {
        
        // Run the scan with the API Key to avoid the download errors
        dependencyCheck additionalArguments: "--scan ./ --nvdApiKey ${NVD_KEY}", odcInstallation: 'OWASP'
    }

    // Publish the XML report so it appears in the Jenkins UI sidebar
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}