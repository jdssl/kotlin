/*
 * Copyright 2000-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.spring.tests.inspections;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("ultimate/testData/inspections/spring")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class SpringInspectionTestGenerated extends AbstractSpringInspectionTest {
    public void testAllFilesPresentInSpring() throws Exception {
        KotlinTestUtils.assertAllTestsPresentInSingleGeneratedClass(this.getClass(), new File("ultimate/testData/inspections/spring"), Pattern.compile("^(inspections\\.test)$"), TargetBackend.ANY);
    }

    @TestMetadata("autowiredMembersInInvalidClass/inspectionData/inspections.test")
    public void testAutowiredMembersInInvalidClass_inspectionData_Inspections_test() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("ultimate/testData/inspections/spring/autowiredMembersInInvalidClass/inspectionData/inspections.test");
        doTest(fileName);
    }

    @TestMetadata("autowiring/inspectionData/inspections.test")
    public void testAutowiring_inspectionData_Inspections_test() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("ultimate/testData/inspections/spring/autowiring/inspectionData/inspections.test");
        doTest(fileName);
    }

    @TestMetadata("componentScan/inspectionData/inspections.test")
    public void testComponentScan_inspectionData_Inspections_test() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("ultimate/testData/inspections/spring/componentScan/inspectionData/inspections.test");
        doTest(fileName);
    }

    @TestMetadata("unconfiguredFacet/inspectionData/inspections.test")
    public void testUnconfiguredFacet_inspectionData_Inspections_test() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("ultimate/testData/inspections/spring/unconfiguredFacet/inspectionData/inspections.test");
        doTest(fileName);
    }
}
