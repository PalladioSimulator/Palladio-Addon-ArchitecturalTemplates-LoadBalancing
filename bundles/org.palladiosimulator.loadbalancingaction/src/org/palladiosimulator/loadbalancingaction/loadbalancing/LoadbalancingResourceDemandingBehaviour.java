/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Demanding Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour <em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingResourceDemandingBehaviour()
 * @model
 * @generated
 */
public interface LoadbalancingResourceDemandingBehaviour extends EObject, ResourceDemandingBehaviour {
    /**
     * Returns the value of the '<em><b>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition <em>Branch Behaviour Loadbalancing Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>' container reference.
     * @see #setLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(LoadbalancingBranchTransition)
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour()
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition
     * @model opposite="branchBehaviour_LoadbalancingBranchTransition" transient="false"
     * @generated
     */
    LoadbalancingBranchTransition getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour();

    /**
     * Sets the value of the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour <em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>' container reference.
     * @see #getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour()
     * @generated
     */
    void setLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(LoadbalancingBranchTransition value);

} // LoadbalancingResourceDemandingBehaviour
