The application can be started with <b>gradle clean appStart -Penv=&lt&ltenv_name&gt&gt</b>
At present two environments are available:
<b>
1) Staging
2) Development
</b>

we set this in build.gradle during build time as:

<b>

ext{
    env="staging"
    }
</b>
 and use it in the <b>Gretty</b> plugin as:
 
 <b>
 
 gretty {
     // supported values:
     // 'jetty7', 'jetty8', 'jetty9', 'tomcat7', 'tomcat8'
 	 port = 8888
     servletContainer = 'jetty9'
     jvmArgs = ["-Dgrails.env=$env","-XX:MaxPermSize=128m"]
 
     /**
      * This jvmArg is used to set config location
      * where Spring boot will look for Config Files
      */
     // '-Dspring.config.location=classpath:/config/'
 }
 
 </b>