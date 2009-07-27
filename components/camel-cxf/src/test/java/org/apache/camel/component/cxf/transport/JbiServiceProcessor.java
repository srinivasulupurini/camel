/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.component.cxf.transport;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.converter.IOConverter;

public class JbiServiceProcessor implements Processor {
    private static final String ECHO_RESPONSE = "<jbi:message xmlns:jbi=\"http://java.sun.com/xml/ns/jbi/wsdl-11-wrapper\"" 
        + " xmlns:msg=\"http://cxf.component.camel.apache.org\" type=\"msg:echoResponse\"><jbi:part>"
        + "<ns1:return xmlns:ns1=\"http://cxf.component.camel.apache.org\">echo Hello World!</ns1:return>"
        + "</jbi:part></jbi:message>";
    /*private static final String ECHO_BOOLEAN_RESPONSE = "<ns1:echoBooleanResponse xmlns:ns1=\"http://cxf.component.camel.apache.org/\">"
        + "<return xmlns=\"http://cxf.component.camel.apache.org/\">true</return>"
        + "</ns1:echoBooleanResponse>";*/

    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        System.out.println("print out the request " + in.getBody(String.class));
        System.out.println("The message exchange pattern is " + exchange.getPattern());
        
        exchange.getOut().setBody(ECHO_RESPONSE);
        
    }

}
