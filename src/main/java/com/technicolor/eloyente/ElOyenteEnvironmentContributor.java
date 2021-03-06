/*
   Copyright 2012 Technicolor

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.technicolor.eloyente;

import hudson.model.EnvironmentContributor;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.EnvVars;
import hudson.Extension;


/**
 * @author Frank Vanderhallen
 */

@Extension
public final class ElOyenteEnvironmentContributor extends EnvironmentContributor {

	@Override
	public void buildEnvironmentFor(Run run, EnvVars envs, TaskListener listener) {
		ElOyenteTriggerCause cause = (ElOyenteTriggerCause)run.getCause(ElOyenteTriggerCause.class);
		if (null != cause) {
			envs.overrideAll(cause.getEnvVars());
		}
	}

}

// vim: set tabstop=4 softtabstop=4 shiftwidth=4 noexpandtab :
