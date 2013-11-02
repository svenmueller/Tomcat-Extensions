# Tomcat-Extensions

Collection of custom Tomcat valves.


## Session Fixation Prevention Valve
### About
This valve changes the session-id of an incoming secure request. The session id is only changed once for the first secure request. It does not destroy the previous session, rather it renames it so it is no longer found by that session-id.
### Configuration
- Create a JAR containing the class and add it to the Tomcat `lib/` folder.
- Add the valve configuration to `conf/server.xml`

```xml
...
<Valve className="valve.SessionFixationValve"/>
...
```
