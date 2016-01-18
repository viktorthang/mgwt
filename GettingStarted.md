**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki/Getting-started-with-mgwt)**

#summary Getting Started with mgwt


# Useful links #
  * SetupProject
  * HelloWorldExample


# Basics #

MGWT heavily relies on [GWT MVP](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideMvpActivitiesAndPlaces.html), [ClientBundles](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideClientBundle.html), [GWT Logging](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideLogging.html). If you don`t know these GWT Basics read them up in the gwt docs. mgwt does not try to replicate GWT functionality, it only adds functionality thats currently missing in the gwt core for mobile development. mgwt always tries to do this in a gwt fashion.

To use mgwt you need to download the latest release and put it in your classpath. After that you have to include it in your gwt.xml file. You can also set the user agent property for gwt to safari, because almost any mobile device runs on webkit and mgwt relies on webkit.

```

<inherits name="com.googlecode.mgwt.MGWT"/>
<set-property name="user.agent" value="safari" />

```




# MGWT MVP #
On mobile devices transistions between two states of the UI are mostly done with some kind of animations.
Therefore mgwt provides its own implementation of ActivityManager called AnimatingActivityManager.
AnimatingActivityManager can handle page transitions with animations.
For every region of your screen you need an AnimatingActivityManager. (Similar to the GWT ActivityManager).

The AnimatingActivityManager needs a few things to do his job:
  * an instance of AnimatableDisplay - which will handle DOM Transistions
  * an instance of ActivityMapper - the mapping from place to activity
  * an instance of AnimationMapper - the mapping (lastPlace, newPlace) -> Animation

## Animation Mapper ##
The MGWT ActivityManager relies on an AnimationMapper to provide the animation it needs to execute on a place change. For every possible combination of places you can provide different animations.
Here is a quick example:
```
public class PhoneAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE;
		}
		return Animation.FADE;

	}
}
```


## Animation Display ##
Animations are handled differently on different platforms by mgwt. To ensure you don´t get any overhead mgwt uses deferred binding. To get an instance of AnimatableDisplay simply use GWT create:
```
AnimatableDisplay display = GWT.create(AnimatableDisplay.class);
```

## Basic Example ##

```

//create an instance of AnimatableDisplay
AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

//instanciate your activitymapper
PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

//instanciate your animationMapper
PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

//setup an activitymanager for the display
AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory.getEventBus());

//pass the display to the activity manager
activityManager.setDisplay(display);

//add the display to the DOM
RootPanel.get().add(display);

```



# MGWT Variables #

If you want to turn off the css obfuscation of mgwt (for debug pruproses) you can put this into your gwt.xml file:
```
<set-configuration-property name="mgwt.css" value="pretty" />
```


If you want to limit the computation to one specific plattform (or test a specific plattform in dev mode) you can set the mgwt.os variable:
```
<set-property name="mgwt.os" value="iphone" />	
```

Valid values are:
  * iphone
  * retina (for iPhone 4 and 4S)
  * ipad
  * ipad\_retina
  * desktop
  * android
  * android\_tablet
  * blackberry