**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary Quirks regarding mgwt

# Touch events on Android #

Some android browser do have a serious bug regarding the touchmove event. The touchmove event only fires once and again **only** at the end of the touch if you don't call prevent default.
in mgwt this would look like:

```
if (MGWT.getOsDetection().isAndroid()) {
	touchDelegate.addTouchMoveHandler(new TouchMoveHandler() {

	@Override
	public void onTouchMove(TouchMoveEvent event) {
		event.preventDefault();

	}
	});
}
```

MGWT Widgets know about this and take appropriate actions.

# Input fields behave weird on Android inside ScrollPanel #
For some reasons the browser on android can not calculate the position of input fields that have been moved with CSS3 translate.  This causes them to jump around when used inside a ScrollPanel.

So if you need input fields inside a scrollpanel, you need to tell the scroll panel not to use hardware acceleration on android like this:

```
scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());

```


# App not launching #
With some apps there seem to be a problem with the standard iframe linker (so far android devices). If you are having trouble starting your app on a device consider using the cross site linker. Place this in your gwt.xml file:
```
    <add-linker name="xsiframe" />		
```