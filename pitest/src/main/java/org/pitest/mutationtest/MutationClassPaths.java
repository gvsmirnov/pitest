/*
 * Copyright 2011 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.mutationtest;

import org.pitest.functional.FCollection;
import org.pitest.internal.ClassPath;

public class MutationClassPaths {

  private final ClassPath   classPath;
  private final ClassFilter classFilter;
  private final PathFilter  pathFilter;

  public MutationClassPaths(final ClassPath classPath,
      final ClassFilter classFilter, final PathFilter pathFilter) {
    this.classPath = classPath;
    this.classFilter = classFilter;
    this.pathFilter = pathFilter;
  }

  public Iterable<String> code() {
    return FCollection.filter(
        this.classPath.getComponent(this.pathFilter.getCodeFilter())
            .findClasses(this.classFilter.getCode()), this.classFilter.getCode());
  }

  public Iterable<String> test() {
    return FCollection.filter(
        this.classPath.getComponent(this.pathFilter.getTestFilter())
            .findClasses(this.classFilter.getTest()), this.classFilter.getTest());
  }

  public ClassPath getClassPath() {
    return this.classPath;
  }

}