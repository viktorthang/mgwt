**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary Some thoughts on Animatable Display


# General thoughts on Animations inside browsers #
A blogpost explaining how to do animations inside the browser: http://blog.daniel-kurka.de/2011/12/animating-in-browser.html


## RootPanel vs RootLayoutPanel ##
The GWT RootLayoutPanel does some things that are necessary to handle screen resizes on different browsers. Due the lag of the box model for IE it includes code that we don`t need to run while being in a browser that supports the box model. While RootLayoutPanel does a good job at providing reliable layouts to cross browser it still runs javascript to layout its children.

With mgwt we only let the webkit engine layout our widgets and don`t run any javascipt for layouts. This ensures a fast and smooth response on all widgets, because all code is running withing the native layout engine.

RootLayoutPanel would break this pattern and should not be used with mgwt. **Don't use RootLayoutPanel, use RootPanel** to add an AnimatableDisplay