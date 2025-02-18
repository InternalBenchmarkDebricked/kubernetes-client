/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Resource;

public class GenericKubernetesResourceOperationsImpl
  extends HasMetadataOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> {

  private final boolean resourceNamespaced;

  public GenericKubernetesResourceOperationsImpl(OperationContext context, boolean resourceNamespaced) {
    super(context, GenericKubernetesResource.class, GenericKubernetesResourceList.class);
    this.resourceNamespaced = resourceNamespaced;
  }
  
  @Override
  protected void validateOperation(Class<GenericKubernetesResource> type) {
    // don't validate generic
  }

  @Override
  public HasMetadataOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> newInstance(OperationContext context) {
    return new GenericKubernetesResourceOperationsImpl(context, resourceNamespaced);
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }
}
