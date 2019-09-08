1.) Spring-boot example
_________________________________
	Start the first-boot-app
	URI:http://localhost:8081/bootapp/products
	
2.) Eureka
____________________
eureka-product-cost-provider-app , eureka-product-name-provider-app and eureka-product-app are 3 services. eureka-product-app service calls other 2 services by their serviceid
 and show combined result.
 eureka-server-app needs to start with other 3 services.
 
 To see registry of services on Eureka serevr: http://localhost:8761/
 
URI: http://localhost:8088/prod/300 or 100 or 200

3.) Config Server and Client:
_________________________________

Config server reading config file from GIT:
clone below repository 
https://github.com/repo1010/springcloud-cofigserver-test
https://github.com/repo1010/springcloud-configserver-perf-test
Add provide user's own GIT repository similar as above, username and password in application.yml file of config-server-git-app project.
 Start config-server-app  first and then config-client-level1-app.
 
 URI:http://localhost:8087/prodinfo
 
 4.) Hysrtix
 _________________________________
 Start netflix-hystrix-app, hystrix-service-provider, hystrix-backup-service-provider 
 access with below URI.
 
 URI: http://localhost:8896/hystrix/getdetails
 
 for testing backup service , make down hystrix-service-provider and then access same URI.
 
 5.)Sleuth
 _________________________________
 
 product-cost-provider-app , product-name-provider-app and product-app are 3 services. product-app service calls other 2 services by their serviceid
 and show combined result.
 URI: http://localhost:8090/prod/100 or 200 or 300
 
 see trace id and span id in logs
 
 6.)Ribbon
 _________________________________
 Start eureka-server-app, ribbon-product-cost-provider-app, ribbon-product-name-provider-app, ribbon-product-app . create multiple instance of providers app.
 
 URI: http://localhost:8088/prod/200
 
 see in console of each instance, request are routed or load balanced between instances.

7.) ZUUL
_________________________________ 
 Start eureka-server-app, eureka-product-cost-provider-app , eureka-product-name-provider-app ,  eureka-product-app and zuul-api-proxy. 
 using zuul-api-proxy service calls are proxied.
 see that all services are registered to eureka at http://localhost:8761 
 URI: http://localhost:8899/api/productproxy/prod/300 or 100 are allowed to see response. 200 are nor allowed.
 
 8.) a.) Sping Cloud Oauth2 and Security
 ______________________________________
 first make sure security.oauth2.resource.user-info-uri=https://api.github.com/user is enable in application.properties file of secureservice-app
 Start secureservice-app and secureui-app .
 URI: http://localhost:8800/ is allowed to access .
 URI: http://localhost:8800/books would route to GIT for authrorization.
 Before checking above URI, user needs to provide their client-id and client-secret in application.yml file of secureui-app project
 
	b.) Custom resource server and authorization server
	-------------------------------------
	first make sure below property is enable in application.properties file of secureservice-app for pointing to custim authserver for user credential.
	security.oauth2.resource.user-info-uri=http://localhost:8802/authserver/user

	Start secureservice-app, secure-authserver-app, securecli-app .
	
	see in console of securecli-app.
	
	
	
 
  
 
 