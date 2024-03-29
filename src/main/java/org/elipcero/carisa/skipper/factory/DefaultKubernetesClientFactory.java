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

import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.cloud.deployer.spi.kubernetes.KubernetesClientFactory;
import org.springframework.cloud.deployer.spi.kubernetes.KubernetesDeployerProperties;

/**
 * Kubernetes client factory. Support mocks
 *
 * @author David Suárez
 */
public class DefaultKubernetesClientFactory implements KubernetesClientFactoryInterface {

    @Override
    public KubernetesClient create(final KubernetesDeployerProperties properties) {
        return KubernetesClientFactory.getKubernetesClient(properties);
    }
}
