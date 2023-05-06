<div align="center">
  <a href="ConfigAPI/actions/workflows/maven-publish.yml">
    <img src="https://github.com/RickySHD/SimpleConfigAPI/actions/workflows/maven-publish.yml/badge.svg" />
  </a>
  <a href="https://jitpack.io/#RickySHD/SimpleConfigAPI">
    <img src="https://jitpack.io/v/RickySHD/SimpleConfigAPI.svg" />
  </a>
</div>   

# SimpleConfigAPI   
A simple API for Bukkit-like plugins to better use yaml configs

### Install with Jitpack.io
Add these lines to the `<repositories>` section in your `pom.xml`
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```
Then add these lines in your `<dependencies>` section
```xml
<dependency>
  <groupId>com.github.RickySHD</groupId>
  <artifactId>SimpleConfigAPI</artifactId>
  <version>1.0.1</version>
</dependency>
```
### Install with Github Packages Apache Maven
Add these lines to your `pom.xml` and follow this [guide](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry) to get a PAT.
```xml
<dependency>
  <groupId>dev.rickyshd</groupId>
  <artifactId>simpleconfigapi</artifactId>
  <version>1.0.1</version>
</dependency>
```

### How to
```java
public final class MyPlugin extends JavaPlugin {
  @Override
  public void onEnable() {
        // initialize a new Config object
        Config myConfig = Config.of(this, "config.yml");
        
        // save the default configuration included in the jar [OPTIONAL]
        myConfig.saveDefault();
        
        // reload the config anytime you want
        myConfig.reload();
        
        // save the config to disk
        myConfig.save();
        
        // access its settings using the methods provided by the default Bukkit Configuration class
        myConfig.set("my_setting", "hello_world");
        myConfig.get("my_setting");
  }
}
```
