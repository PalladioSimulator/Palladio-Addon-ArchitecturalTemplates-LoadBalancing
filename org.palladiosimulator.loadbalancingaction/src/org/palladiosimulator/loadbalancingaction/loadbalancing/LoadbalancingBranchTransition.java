/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition <em>Loadbalancing Action Loadbalancing Branch Transition</em>}</li>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition <em>Branch Behaviour Loadbalancing Branch Transition</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingBranchTransition()
 * @model
 * @generated
 */
public interface LoadbalancingBranchTransition extends EObject, Entity {
    /**
     * Returns the value of the '<em><b>Loadbalancing Action Loadbalancing Branch Transition</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getBranches_Loadbalancing <em>Branches Loadbalancing</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loadbalancing Action Loadbalancing Branch Transition</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loadbalancing Action Loadbalancing Branch Transition</em>' container reference.
     * @see #setLoadbalancingAction_LoadbalancingBranchTransition(LoadbalancingAction)
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition()
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getBranches_Loadbalancing
     * @model opposite="branches_Loadbalancing" required="true" transient="false"
     * @generated
     */
    LoadbalancingAction getLoadbalancingAction_LoadbalancingBranchTransition();

    /**
     * Sets the value of the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition <em>Loadbalancing Action Loadbalancing Branch Transition</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loadbalancing Action Loadbalancing Branch Transition</em>' container reference.
     * @see #getLoadbalancingAction_LoadbalancingBranchTransition()
     * @generated
     */
    void setLoadbalancingAction_LoadbalancingBranchTransition(LoadbalancingAction value);

    /**
     * Returns the value of the '<em><b>Branch Behaviour Loadbalancing Branch Transition</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour <em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Branch Behaviour Loadbalancing Branch Transition</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Branch Behaviour Loadbalancing Branch Transition</em>' containment reference.
     * @see #setBranchBehaviour_LoadbalancingBranchTransition(LoadbalancingResourceDemandingBehaviour)
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition()
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour
     * @model opposite="loadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour" containment="true" required="true"
     * @generated
     */
    LoadbalancingResourceDemandingBehaviour getBranchBehaviour_LoadbalancingBranchTransition();

    /**
     * Sets the value of the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition <em>Branch Behaviour Loadbalancing Branch Transition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Branch Behaviour Loadbalancing Branch Transition</em>' containment reference.
     * @see #getBranchBehaviour_LoadbalancingBranchTransition()
     * @generated
     */
    void setBranchBehaviour_LoadbalancingBranchTransition(LoadbalancingResourceDemandingBehaviour value);

} // LoadbalancingBranchTransition
