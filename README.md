Tomcat-Extensions
=================

Custom Tomcat valves etc..


Session Fixation Prevention Valve
---------------------------------

- Create a JAR containing the class and add it to the Tomcat lib folder.
- Add the valve configuration to server.xml

```xml
<Valve className="valve.SessionFixationValve"/>
```