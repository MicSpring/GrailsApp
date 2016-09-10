The application can be started with <b>gradle clean appStart -Penv=<<env_name>></b> <br/>
At present two environments are available: <br/> <br/>
<b>
1) Staging  <br/>
2) Development <br/>
</b>

we set this in build.gradle during build time as:<br/>

<b>

ext{<br/>
    env="staging"<br/>
    }<br/>
</b>
 and use it in the <b>Gretty</b> plugin as:<br/> <br/>
 
 <b>
 
 gretty {<br/>
     // supported values:<br/>
     // 'jetty7', 'jetty8', 'jetty9', 'tomcat7', 'tomcat8'<br/>
 	 port = 8888<br/>
     servletContainer = 'jetty9'<br/>
     jvmArgs = ["-Dgrails.env=$env","-XX:MaxPermSize=128m"]<br/>
 
     /**
      * This jvmArg is used to set config location
      * where Spring boot will look for Config Files
      */
     // '-Dspring.config.location=classpath:/config/'
 }<br/>
 
 </b>