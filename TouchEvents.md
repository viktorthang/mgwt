mgwt provides an abstraction Layer for possible input devices such as Touch or MouseInput. Therefor it is possible to develop an mgwt application in your desktop browser. The mouse input will be treated as a single finger.

The mouse down event will be dispatched as a touch start event, the mouse move event (after mouse down) will be dispatched as touch move and the mouse up will be dispatched as touch end.

If mgwt is executed in a browser with real touch support such as mobile safari or the android browser, it extends the DOMImpl to natively capture the events and dispatch them as normal GWT events are dispatched.

mgwt widgets that offer touch events implement HasTouchHandlers (like HasClickHandlers in gwt), therefore the MVP pattern can be implemented very easily with mgwt.
