/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Loadbalancing</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadbalancingAllTests extends TestSuite {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(suite());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Test suite() {
        final TestSuite suite = new LoadbalancingAllTests("Loadbalancing Tests");
        suite.addTest(LoadbalancingTests.suite());
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingAllTests(final String name) {
        super(name);
    }

} //LoadbalancingAllTests
