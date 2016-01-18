**Note: This is only a draft, it is not implemented yet!**

# Gesture Recognition #
mgwt provides easy access to touch input. Most mgwt widgets directly support registration as a TouchHandler, such as (TouchWidget, TouchPanel). If a widget does not directly support touch input (like the gwt canvas element), you can use [TouchDelegate](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/ui/client/widget/touch/TouchDelegate.html) to get touch input from it.

However those methods would require you to handle every single touch and aggregate them to a complete gesture. This is why mgwt offers several gesture recognizers that you can add to widgets that support [HasTouchHandlers](http://docs.mgwt.googlecode.com/git/javadoc/latest/com/googlecode/mgwt/dom/client/event/touch/HasTouchHandlers.html).

## Tap Recognizer ##
This recognizer tracks a single touch, that should not move (wihtin a certain distance)

## Double Tap Recognizer ##
This recognizer detects a double tap: Two taps followed within a certain amount of time.

## Long Tap Recognizer ##
This recognizer tracks a touch, that should not move and should be held for a certain amount of time.

## Swipe Recognizer ##
This recognizer detects a swipe. A swipte is a distinct movement into mostly one direction.

## Pinch Recognizer ##
This recognizer detect a pinch gesture.