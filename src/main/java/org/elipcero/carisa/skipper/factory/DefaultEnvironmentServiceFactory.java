/*
 * Copyright 2019-2022 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.elipcero.carisa.skipper.factory;

import org.elipcero.carisa.skipper.service.EnvironmentService;
import org.elipcero.carisa.skipper.service.KubernetesEnvironmentService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Build the environment service factory
 *
 * @author David Suárez
 */
public class DefaultEnvironmentServiceFactory implements EnvironmentServiceFactory {

    private final Map<String, Object[]> environmentServices = new HashMap<>();

    public DefaultEnvironmentServiceFactory registerEnvironment(String type, Object[] environmentServices) {
        this.environmentServices.put(type, environmentServices);
        return this;
    }

    @Override
    public boolean isImplementedEnvironment(String type) {
        return environmentServices.containsKey(type);
    }

    @Override
    public EnvironmentService getEnvironmentService(String type) {
        return this.getEnvironment(type, KubernetesEnvironmentService.class);
    }

    @Override
    public DeployerFactory getDeployerFactory(String type) {
        return this.getEnvironment(type, KubernetesAppDeployerFactory.class);
    }

    private <T> T getEnvironment(String platformType, Class<T> serviceType) {

        Object[] environmentServices = this.environmentServices.get(platformType);
        if (environmentServices == null) {
            throw new IllegalArgumentException(
                    String.format("Getting '%s' service. The platform: '%s' is not implemented",
                            serviceType.getName(), platformType));
        }
        else {
            return (T)Arrays.stream(environmentServices)
                    .filter(e -> serviceType.isAssignableFrom(e.getClass()))
                    .findFirst()
                    .get();
        }
    }
}
