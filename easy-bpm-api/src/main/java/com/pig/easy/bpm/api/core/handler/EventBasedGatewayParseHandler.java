/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pig.easy.bpm.api.core.handler;

import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.EventGateway;
import org.flowable.engine.impl.bpmn.parser.BpmnParse;

/**
 * @author Joram Barrez
 */
public class EventBasedGatewayParseHandler extends AbstractActivityBpmnParseHandler<EventGateway> {

    @Override
    public Class<? extends BaseElement> getHandledType() {
        return EventGateway.class;
    }

    @Override
    protected void executeParse(BpmnParse bpmnParse, EventGateway gateway) {
        gateway.setBehavior(bpmnParse.getActivityBehaviorFactory().createEventBasedGatewayActivityBehavior(gateway));
    }

}
