/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.ui.client.theme.base;

public interface HeaderCss extends ButtonBaseCss {

	@ClassName("mgwt-HeaderButton")
	public String headerButton();

	public String active();

	public String back();

	public String forward();

	public String round();

	@ClassName("mgwt-HeaderPanel")
	String headerPanel();

	@ClassName("mgwt-HeaderPanel-left")
	String left();

	@ClassName("mgwt-HeaderPanel-center")
	String center();

	@ClassName("mgwt-HeaderPanel-right")
	String right();

	@ClassName("mgwt-DropDownMenu")
	public String main();

	@ClassName("mgwt-DropDownMenu-content")
	public String content();

	@ClassName("mgwt-DropDownMenu-arrow")
	public String arrow();
}
