/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getBranches_Loadbalancing <em>Branches Loadbalancing</em>}</li>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getLoadbalancingStrategy <em>Loadbalancing Strategy</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingAction()
 * @model
 * @generated
 */
public interface LoadbalancingAction extends EObject, AbstractInternalControlFlowAction {
    /**
     * Returns the value of the '<em><b>Branches Loadbalancing</b></em>' containment reference list.
     * The list contents are of type {@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition}.
     * It is bidirectional and its opposite is '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition <em>Loadbalancing Action Loadbalancing Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Branches Loadbalancing</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Branches Loadbalancing</em>' containment reference list.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingAction_Branches_Loadbalancing()
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition
     * @model opposite="loadbalancingAction_LoadbalancingBranchTransition" containment="true" ordered="false"
     * @generated
     */
    EList<LoadbalancingBranchTransition> getBranches_Loadbalancing();

    /**
     * Returns the value of the '<em><b>Loadbalancing Strategy</b></em>' attribute.
     * The default value is <code>"RANDOM"</code>.
     * The literals are from the enumeration {@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loadbalancing Strategy</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loadbalancing Strategy</em>' attribute.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy
     * @see #setLoadbalancingStrategy(LoadbalancingStrategy)
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingAction_LoadbalancingStrategy()
     * @model default="RANDOM" required="true"
     * @generated
     */
    LoadbalancingStrategy getLoadbalancingStrategy();

    /**
     * Sets the value of the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getLoadbalancingStrategy <em>Loadbalancing Strategy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loadbalancing Strategy</em>' attribute.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy
     * @see #getLoadbalancingStrategy()
     * @generated
     */
    void setLoadbalancingStrategy(LoadbalancingStrategy value);

} // LoadbalancingAction
