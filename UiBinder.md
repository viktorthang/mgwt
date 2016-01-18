# Basics #

mgwt works with the gwt ui binder framework. To use the UiBinder support of gwt you have to import the mgwt namespace in your ui.xml files like this:

```
xmlns:mgwt="urn:import:com.googlecode.mgwt.ui.client.widget"
```

Simple Example:

```
<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g="urn:import:com.google.gwt.user.client.ui" xmlns:mgwt="urn:import:com.googlecode.mgwt.ui.client.widget">

	<mgwt:LayoutPanel>
		<mgwt:HeaderPanel>
			<mgwt:center>
				<g:HTML ui:field="center"></g:HTML>
			</mgwt:center>
		</mgwt:HeaderPanel>

		<mgwt:ScrollPanel scrollingEnabledX="false">
			<g:FlowPanel>


				<mgwt:RoundPanel>
					<mgwt:MTextBox ui:field="name"></mgwt:MTextBox>
				</mgwt:RoundPanel>
				<mgwt:Button ui:field="editButton" text="edit"></mgwt:Button>

			</g:FlowPanel>

		</mgwt:ScrollPanel>

	</mgwt:LayoutPanel>

</ui:UiBinder> 

```


# Supported Widgets #

Here is a list of the widgets that work with ui binder and a quick example for each Widget.