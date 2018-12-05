/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.config

import org.jetbrains.jps.model.ex.JpsElementTypeBase
import org.jetbrains.jps.model.java.JavaResourceRootProperties
import org.jetbrains.jps.model.java.JavaResourceRootType
import org.jetbrains.jps.model.java.JpsJavaExtensionService
import org.jetbrains.jps.model.module.JpsModuleSourceRootType

sealed class KotlinResourceRootType(val isTest: Boolean) : JpsElementTypeBase<JavaResourceRootProperties>(),
        JpsModuleSourceRootType<JavaResourceRootProperties>, KotlinRootType {
    object Resource : KotlinResourceRootType(false)
    object TestResource : KotlinResourceRootType(true)

    override fun createDefaultProperties() =
        JpsJavaExtensionService.getInstance().createResourceRootProperties("", false)

    override fun isTestRoot() = isTest

    override fun equals(other: Any?) = if (super.equals(other)) true else isSameRootType(this, other)
}