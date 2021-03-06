/*
 * Copyright 2000-2016 Vaadin Ltd.
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
package com.vaadin.tests.components.javascriptcomponent;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

@JavaScript({ "notfound.js", "notfound.js" })
@Widgetset("com.vaadin.DefaultWidgetSet")
public class DuplicateJavascriptDependencies extends AbstractTestUIWithLog {

    @JavaScript({ "notfound2.js", "notfound2.js" })
    public static class ResultLabel extends Label {

        public ResultLabel(String text) {
            super(text);
            setId("result");
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Button("Test",
                e -> addComponent(new ResultLabel("It works"))));
    }

}
