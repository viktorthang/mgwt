**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary Using provided themes and building your own


# Introduction #

mgwt uses GWT ClientBundles heavily to be most efficient when it comes to styling. This article will not explain how GWT ClientBundles work, instead it will focus on how mgwt uses them. The base information about ClientBundles can be found in the excellent GWT Docs: [ClientBundle](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideClientBundle.html).

There are several ways for you to customize the look of mgwt:

  1. Turn off selector obfuscation and add a custom css file
  1. Extend the mgwt css Interface and change the underlying css or just extend it
  1. Use the default custom color theme
  1. Use other GWT mechanisms to influence styles

This document is intended to clarify how to make small changes to mgwt looks as well as rolling your own custom theme.




If you know what your design should look like you should use client bundles with all their optimizations. Therefore you can easily extend the mgwt css Interfaces and Bundles and add some css.


## Turn off selector obfuscation ##
If you turn off selector obfuscation you can use plain css class names to style your app, but you are also sacrificing compile time checking and performance as well. This approach is a good idea if you just want to test something very fast.

Inside your gwt xml simply place this rule:
```
	<set-configuration-property name="mgwt.css" value="pretty" />
```

After setting this property class names will no longer be unreadable gibberish, they will have plain understandable names like "mgwt-Button". Now you can easily debug css and apply your changes.
When you are done and have figured out what your css should be you should start using ClientBundles as well.

## Styling with CSS ##
After turning off selector obfuscation you have to make sure that your css is included later than the mgwt clientbundle in the dom, so that you can override stylings.

This can be easily achieved:

```
//this will create a link element at the end of head
MGWTStyle.getTheme().getMGWTClientBundle().getMainCss().ensureInjected();

//append your own css as last thing in the head
MGWTStyle.injectStyleSheet("yourcssfile.css");
```

You should do this somewhere in your entrypoint, but using ClientBundle and overriding the embedded bundle is much more efficient at runtime.




## Extend mgwt css Interfaces ##

There is a complete styling example in the git repositories located [here](http://code.google.com/p/mgwt/source/checkout?repo=themebase).

This way you can easily override any widget and style them as your like:
  1. Extend the matching ClientBundle
  1. Override the appropriate getter (i.e. getButtonCss())
  1. anotate the base css first + your custom css.
  1. Write a custom implementation of MGWTTheme that returns your bundle
  1. Set your theme as default or pass it in the constructor of a custom widget


GWT uses interfaces to describe CSS files. The same approach is used in mgwt. For each (important) widget there is one CSS interface and (at least) one css file. Those CSS interfaces and CSS Files are brought together in a so called Bundle. You simply anotate which css file to use for an interface. MGWT has different Bundle (which also contain images) for different platforms. This means that no css that is specific to android will end up in an iOS app.

At the moment there are 7 different Bundles:
  1. iPhone (non retina display)
  1. iPhone (retina display)
  1. iPad
  1. Android Phone
  1. Android Tablet
  1. Blackberry
  1. Desktop


Lets take a look at an example from [MGWTColorBundleNonRetina](http://code.google.com/p/mgwt/source/browse/src/main/java/com/googlecode/mgwt/ui/client/theme/mgwt/MGWTColorBundleNonRetina.java):
```
public interface MGWTColorBundleNonRetina extends MGWTClientBundleBaseThemeNonRetina {

	@Source({ "color.css", "com/googlecode/mgwt/ui/client/theme/base/css/progressbar.css", "css/progressbar.css" })
	ProgressBarCss getProgressBarCss();
	
	...
}

```
The interface ProgressBarCss contains all CSS classes that are relevant for the ProgressBar. We anotate the css files that should be used for this interface.
Important: The order is important like in a normal css file. First we include the color definitions for our color theme, after that the css from the base mgwt theme and last (it will override classes) our custom css. Notice that we don`t need to copy everything from the default progressbar.css, we can just override what needs to be overridden.


Next thing you need to do is create your own instance of MGWTTheme.

```
	public interface MGWTTheme {

		public MGWTClientBundle getMGWTClientBundle();

	}
```


Let`s start by building a simple two color theme for all platforms. (This theme is actually part of mgwt and can be used very easily):

The first thing we need to do is build our own implementation of MGWTTheme (see: [MGWTColorTheme](http://code.google.com/p/mgwt/source/browse/src/main/java/com/googlecode/mgwt/ui/client/theme/mgwt/MGWTColorTheme.java)):
```
	public class MGWTColorTheme implements MGWTTheme {

		private MGWTClientBundle bundle;

		public MGWTColorTheme() {
			if (MGWT.getOsDetection().isIOs()) {
				if (MGWT.getOsDetection().isRetina()) {
					bundle = (MGWTColorBundleRetina) GWT.create(MGWTColorBundleRetina.class);
				} else {
					bundle = (MGWTColorBundleNonRetina) GWT.create(MGWTColorBundleNonRetina.class);
				}
			} else {
				bundle = (MGWTColorBundleNonRetina) GWT.create(MGWTColorBundleNonRetina.class);
			}

		}

		@Override
		public MGWTClientBundle getMGWTClientBundle() {
			return bundle;
		}

	}

```

Our implementation returns two different implementations for MGWTClientBundle. One for iPhone with retina displays and the other for all other devices.
We need another implementation for MGWTClientBundle because icons have to have a bigger resolution to look great on a retina display. Since we can not include images conditionally in css (images currently get always inlined....) we use to different bundles.


The last thing we need to do is set the theme as default or just pass it to a widget:

```
MGWTStyle.setTheme(new MGWTColorTheme());

```

Important: This needs to be one of the first things of your app. The theme can not be changed at runtime.

Passing a custom theme to only one widget:
```
	new Button(theme.getMGWTClientBundle().getButtonCss())

```




# mgwt themes #

mgwt provides themes for each platform it supports:
  * iPhone
  * iPad
  * Android
  * Blackberry

And it also supports a theme that is not dependent on the underlying os and can be easily extended:
  * mgwt base




# how to style widgets #
To see the DOM structure of each widget and the corresponding css classes take a look at the javadoc of the widget. We choose to document this directly in the code so that it is much easier to keep it up to date, rather than updating the wiki seperatly

  * [Button](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/Button.html)
  * ButtonBar
  * [CellList](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/CellList.html)
  * [HeaderButton](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/HeaderButton.html)
  * [HeaderPanel](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/HeaderPanel.html)
  * [LayoutPanel](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/LayoutPanel.html)
  * [MCheckBox](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/MCheckBox.html)
  * [MValueBoxBase](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/base/MValueBoxBase.html) for most input elements like MTextBox
  * MListBox
  * MRadioBox
  * [MSearchBox](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/MSearchBox.html)
  * [MSlider](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/MSlider.html)
  * [ProgressBar](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/ProgressBar.html)
  * [ProgressIndicator](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/ProgressIndicator.html)
  * PullToRefresh
  * [ScrollPanel](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/ScrollPanel.html)
  * [WidgetList](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/WidgetList.html)
  * TabPanel


