**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary how to use mgwt snapshots

mgwt uses continous integration and deploys snapshots of the project regularly to the sonatype oss repository.

If bugfixes are marked as FIXED\_NOT\_RELEASED you can get the fixes by using a snapshot.

The repository url for maven:
```
<repositories>
   <repository>
      <id>sonatype snapshots</id>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
   </repository>
</repositories>
```

The current trunk version is:
```
<dependencies>
   <dependency>
      <groupId>com.googlecode.mgwt</groupId>
      <artifactId>mgwt</artifactId>
      <version>1.1.2-SNAPSHOT</version>
   </dependency>
</dependencies>
```