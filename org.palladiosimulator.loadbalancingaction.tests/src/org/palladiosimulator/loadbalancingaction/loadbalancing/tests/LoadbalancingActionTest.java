/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadbalancingActionTest extends TestCase {

    /**
     * The fixture for this Action test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingAction fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(LoadbalancingActionTest.class);
    }

    /**
     * Constructs a new Action test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingActionTest(final String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Action test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(final LoadbalancingAction fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Action test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingAction getFixture() {
        return this.fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(LoadbalancingFactory.eINSTANCE.createLoadbalancingAction());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        this.setFixture(null);
    }

} //LoadbalancingActionTest
