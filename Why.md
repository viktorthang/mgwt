**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary Why mgwt?

# HTML 5 vs. native mobile Apps #
There is an ongoing discussion when to write a native app for mobile devices and when to write a wep app (which can be deployed locally). If a webapp uses e.g. phonegap to be packaged and deployed to a mobile device, it can almost do anything a native app can do.

We think that there is one basic decision to make: If you need the last bit of performance and newest APIs for your app native apps seem to be the way to go for you.
But if you want to reach as much users over several devices with the lowest costs html5 apps is the way to go. But there are some considerations when you start building HTML5 apps that need to be taken into account:


# Performance #
Performance really matters on mobile phones, so if you write your app in javascript you better have very efficient javascript, otherwise you run slowly and drain your users batteries. As you may know the gwt compiler is very good at producing very efficient apps.

Theoretically you could do all the magic the gwt compiler does to optimize your javascript app by hand, but it`s a very hard and error prone task. So why not use gwt for mobile development and benefit from all the great work google has put into it and also be able to leverage all the tools in the java environment.

To make sure your app runs efficiently mgwt does some very cool things:
  * Everything that can be done using css is done using css, e.g. it`s much faster to delegate an animation to the webkit engine than to write it yourself in javascript.
  * Deferred Binding is used heavily to make sure your app only contains the code it needs. This ensures a minimal code size and because of this faster download time and more evaluation speed.
  * Phones typically have a slow and high latency network connection. Making sure you don´t have to request many small files speeds up your app tremendously. This is why mgwt uses CssResources heavily so everything gets bundled into one file (of course you can control split points with gwt, if the javascript files get too big)
  * Using Caching that works. GWT does some great things to ensure that you only download the script if your local copy is out of date. So if a phone already has visited your page and has the current app in the cache it won`t download the file again and immediately start the app.

# MGWT uses GWT Best Practices you already know #
mgwt does not try to reinvent the wheel. Google has done a very great job with GWT and there is no way we can top that with mgwt. So mgwt uses the same concepts GWT provides and adds features to GWT where you need them to build great mobile apps.
mgwt integrates perfectly with the MVP framework provided in GWT, by providing a custom ActivityManager which handles animations. All Widgets of mgwt do work with the UiBinder Frameworks as well as the editor framework. So everything you know about great testable GWT apps still works with mgwt.

# mgwt event model #
mgwt adds touch event support and animation event to GWT by adding a custom DOM implementation. Mouse input is treated as one finger touching the device, so you don´t have to write code to handle both mouse and touch.