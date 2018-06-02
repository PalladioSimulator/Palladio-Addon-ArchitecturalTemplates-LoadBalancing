/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>loadbalancing</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadbalancingTests extends TestSuite {

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
        final TestSuite suite = new LoadbalancingTests("loadbalancing Tests");
        suite.addTestSuite(LoadbalancingResourceDemandingBehaviourTest.class);
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingTests(final String name) {
        super(name);
    }

} //LoadbalancingTests
