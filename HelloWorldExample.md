**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki/Getting-started-with-mgwt)**

#summary A very simple example for mgwt usage


This is based on mgwt 1.1-SNAPSHOT, which you can download here:[MGWT-SNAPSHOT](https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=com.googlecode.mgwt&a=mgwt&e=jar&v=LATEST).
You need to place the jar file into your projects build path.


In your gwt xml file add this line:
```
   <inherits name='com.googlecode.mgwt.MGWT'/>
```

Your EntryPoint should look like this:
```
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

public class MGWTEntryPoint implements EntryPoint {

  public void onModuleLoad() {
    // set viewport and other settings for mobile
    MGWT.applySettings(MGWTSettings.getAppSetting());

    // build animation helper and attach it
    AnimationHelper animationHelper = new AnimationHelper();
    RootPanel.get().add(animationHelper);

    // build some UI
    LayoutPanel layoutPanel = new LayoutPanel();
    Button button = new Button("Hello mgwt");
    layoutPanel.add(button);

    // animate
    animationHelper.goTo(layoutPanel, Animation.SLIDE);

  }

}
```