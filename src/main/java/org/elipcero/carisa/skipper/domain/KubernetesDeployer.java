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

package org.elipcero.carisa.skipper.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This contain kubernenetes information
 *
 * @author David Suárez
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carisa_skipper_deployer")
public class KubernetesDeployer extends Deployer {

    public static final String PLATFORM_TYPE_KUBERNETES = "Kubernetes";

    private String namespace;

    @Builder
    public KubernetesDeployer(String id, String name, String namespace) {
        super(id, name);
        this.namespace = namespace;
    }
}
