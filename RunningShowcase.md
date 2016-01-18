**This wiki is outdated. Please use [the new wiki on github](https://github.com/mgwt/mgwt/wiki)**

#summary how to run the showcase project


# Running showcase on your machine #

<a href='http://www.youtube.com/watch?feature=player_embedded&v=ZpXnZNjPDlU' target='_blank'><img src='http://img.youtube.com/vi/ZpXnZNjPDlU/0.jpg' width='425' height=344 /></a>

## Prerequisites ##
This assumes that you have maven and eclipse with the google eclipse plugin installed.


## Step 1 - Create project from archetype ##
Create the project **inside** an eclipse workspace.

Go inside the workspace folder and run the following maven command:
```
git clone https://code.google.com/p/mgwt.showcase/
```

You will be asked to supply a groupId, an artifactId, a version and a package.
Your groupId should be something like com.yourcompany.project. Your artifact id should be the some name which only consists of letters (no minus, no whitespaces, etc.). The version can be left as default and the package should be the same then your groupId.

## Step 2 - Configure the workspace ##
You only need to do this **once**. Make sure that your eclipse is **not** running. This will create a variable called M2\_REPO pointing to your local maven repository, so that dependency resolution will work inside eclipse.
In the folder of your workspace run the following:
```
mvn eclipse:configure-workspace -Declipse.workspace="/path/toyourworkspace"
```
The parameter on your system should be something like "C:\workspace" on windows or /somepath/workspace on linux / mac.

## Step 3 - Create eclipse project from maven ##
In the next step we will use maven to create the project and classpath file for eclipse from the maven pom.xml. Any time your dependencies change you need to rerun this. You need to **change the directory** into the generated project and run:

```
mvn eclipse:eclipse
```

## Step 4 - Copy web resources into target ##
In this step we will copy the web app parts from src/main/webapp into your target folder. Everytime you change something in the files in src/main/webapp you need to rerun this.
```
mvn war:exploded
```


## Step 5 - Import the project into eclipse ##
In Eclipse do the following Steps

### Import Project into Eclipse ###
Choose File -> Import
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/file_import.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/file_import.png)

Choose General -> Existing Project into Workspace -> Next
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/import_existing.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/import_existing.png)

Navigate to the created project folder and choose open. Eclipse should now find the project and you can import it.
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/import_project_screen.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/import_project_screen.png)

### Configure google eclipse plugin ###
Right click on your project -> Properties
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/project_properties.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/project_properties.png)

Select Google and expand the node -> Select "Web Application"


Check the box "This project has a WAR directory" and choose src/main/webapp
**Uncheck the box "Launch and deploy from this directory"
Click Ok
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/webapp_config.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/webapp_config.png)**

### Start the project ###
Right click on the project -> Run As -> "Web Application"
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/run_as.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/run_as.png)


The GWT Dev Mode is now starting and you will be asked to select the war directory:


You need to choose **target/"artifactId"-"version"** as your war directory.
(Note: artifactId and version you chose when you created the project)
![http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/select_war.png](http://wiki.mgwt.googlecode.com/git/screenshots/getting_started/select_war.png)

After a successful launch you will see the url that you can paste into your browser to see the project

You need to checkout the project from version control: