/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage
 * @generated
 */
public interface LoadbalancingFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LoadbalancingFactory eINSTANCE = org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Action</em>'.
     * @generated
     */
    LoadbalancingAction createLoadbalancingAction();

    /**
     * Returns a new object of class '<em>Branch Transition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Branch Transition</em>'.
     * @generated
     */
    LoadbalancingBranchTransition createLoadbalancingBranchTransition();

    /**
     * Returns a new object of class '<em>Resource Demanding Behaviour</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Demanding Behaviour</em>'.
     * @generated
     */
    LoadbalancingResourceDemandingBehaviour createLoadbalancingResourceDemandingBehaviour();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    LoadbalancingPackage getLoadbalancingPackage();

} //LoadbalancingFactory
