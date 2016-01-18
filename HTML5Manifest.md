**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary mgwt and html 5 offline capabilities

In the HTML5 Spec there is a specific part about offline applications (see: [offline spec](http://www.w3.org/TR/html5/offline.html))

MGWT also supports this also supports offline modes very easily (since 1.0.2).

If you want to see it in action check out the showcase: [Showcase](http://mobilegwt.appspot.com/showcase/#).

With GWT Apps this is much more difficult because we only want to cache files that are relevant to the current client. There is no point in sending the ios compilation to an android device for caching.
This is why mgwt provides a custom linker that observes the compile process and produces all artifacts that are needed to dynamically select the right manifest per client.


To use this linker you need to include it in your gwt.xml file:
```
<inherits name="com.googlecode.mgwt.linker.Linker" />
<add-linker name="permutationmaplinker" />
```

You can also specify files that are not part of the compilation process but should also be cached:
```
<extend-configuration-property name="html5manifestlinker_files" value="./" />
<extend-configuration-property name="html5manifestlinker_files" value="index.html" />
<extend-configuration-property name="html5manifestlinker_files" value="logo.png" />
```

After you configured this you will have all artifacts that are necessary to pwer a servlet that dynamically selects the right artifact.

In you web xml you need to add:
```
<servlet>
    <servlet-name>ManifestServlet</servlet-name>
    <servlet-class>com.googlecode.mgwt.linker.server.MGWTHtml5ManifestServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>ManifestServlet</servlet-name>
    <url-pattern>/<your modulename>.manifest</url-pattern>
  </servlet-mapping>
```

Make sure to use your module name properly. This is critical for the servlet.


In your html host file you need to put the manifest url on the html tag like:
```
<!doctype html>
<html manifest="/<yourmodulename>.manifest">
....
</html>
```