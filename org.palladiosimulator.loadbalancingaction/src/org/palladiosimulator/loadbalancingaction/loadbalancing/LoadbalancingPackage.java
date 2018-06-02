/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingFactory
 * @model kind="package"
 * @generated
 */
public interface LoadbalancingPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "loadbalancing";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://org.palladiosimulator/loadbalancingaction";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "loadbalancing";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LoadbalancingPackage eINSTANCE = org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl
            .init();

    /**
     * The meta object id for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingAction()
     * @generated
     */
    int LOADBALANCING_ACTION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__ID = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__PREDECESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__SUCCESSOR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

    /**
     * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__RESOURCE_DEMAND_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION;

    /**
     * The feature id for the '<em><b>Infrastructure Call Action</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__INFRASTRUCTURE_CALL_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION;

    /**
     * The feature id for the '<em><b>Resource Call Action</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__RESOURCE_CALL_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION;

    /**
     * The feature id for the '<em><b>Branches Loadbalancing</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__BRANCHES_LOADBALANCING = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Loadbalancing Strategy</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION__LOADBALANCING_STRATEGY = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION_FEATURE_COUNT
            + 1;

    /**
     * The number of structural features of the '<em>Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl <em>Branch Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingBranchTransition()
     * @generated
     */
    int LOADBALANCING_BRANCH_TRANSITION = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_BRANCH_TRANSITION__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_BRANCH_TRANSITION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Loadbalancing Action Loadbalancing Branch Transition</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION = EntityPackage.ENTITY_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Branch Behaviour Loadbalancing Branch Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION = EntityPackage.ENTITY_FEATURE_COUNT
            + 1;

    /**
     * The number of structural features of the '<em>Branch Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_BRANCH_TRANSITION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingResourceDemandingBehaviourImpl <em>Resource Demanding Behaviour</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingResourceDemandingBehaviourImpl
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingResourceDemandingBehaviour()
     * @generated
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__ID = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ID;

    /**
     * The feature id for the '<em><b>Abstract Loop Action Resource Demanding Behaviour</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;

    /**
     * The feature id for the '<em><b>Abstract Branch Transition Resource Demanding Behaviour</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;

    /**
     * The feature id for the '<em><b>Steps Behaviour</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR;

    /**
     * The feature id for the '<em><b>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Resource Demanding Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR_FEATURE_COUNT = SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR_FEATURE_COUNT
            + 1;

    /**
     * The meta object id for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy <em>Strategy</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingStrategy()
     * @generated
     */
    int LOADBALANCING_STRATEGY = 3;

    /**
     * Returns the meta object for class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Action</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction
     * @generated
     */
    EClass getLoadbalancingAction();

    /**
     * Returns the meta object for the containment reference list '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getBranches_Loadbalancing <em>Branches Loadbalancing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Branches Loadbalancing</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getBranches_Loadbalancing()
     * @see #getLoadbalancingAction()
     * @generated
     */
    EReference getLoadbalancingAction_Branches_Loadbalancing();

    /**
     * Returns the meta object for the attribute '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getLoadbalancingStrategy <em>Loadbalancing Strategy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Loadbalancing Strategy</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction#getLoadbalancingStrategy()
     * @see #getLoadbalancingAction()
     * @generated
     */
    EAttribute getLoadbalancingAction_LoadbalancingStrategy();

    /**
     * Returns the meta object for class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition <em>Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Branch Transition</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition
     * @generated
     */
    EClass getLoadbalancingBranchTransition();

    /**
     * Returns the meta object for the container reference '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition <em>Loadbalancing Action Loadbalancing Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Loadbalancing Action Loadbalancing Branch Transition</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getLoadbalancingAction_LoadbalancingBranchTransition()
     * @see #getLoadbalancingBranchTransition()
     * @generated
     */
    EReference getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition();

    /**
     * Returns the meta object for the containment reference '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition <em>Branch Behaviour Loadbalancing Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Branch Behaviour Loadbalancing Branch Transition</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition#getBranchBehaviour_LoadbalancingBranchTransition()
     * @see #getLoadbalancingBranchTransition()
     * @generated
     */
    EReference getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition();

    /**
     * Returns the meta object for class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Demanding Behaviour</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour
     * @generated
     */
    EClass getLoadbalancingResourceDemandingBehaviour();

    /**
     * Returns the meta object for the container reference '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour <em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour()
     * @see #getLoadbalancingResourceDemandingBehaviour()
     * @generated
     */
    EReference getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour();

    /**
     * Returns the meta object for enum '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy <em>Strategy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Strategy</em>'.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy
     * @generated
     */
    EEnum getLoadbalancingStrategy();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    LoadbalancingFactory getLoadbalancingFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl <em>Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingAction()
         * @generated
         */
        EClass LOADBALANCING_ACTION = eINSTANCE.getLoadbalancingAction();

        /**
         * The meta object literal for the '<em><b>Branches Loadbalancing</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOADBALANCING_ACTION__BRANCHES_LOADBALANCING = eINSTANCE
                .getLoadbalancingAction_Branches_Loadbalancing();

        /**
         * The meta object literal for the '<em><b>Loadbalancing Strategy</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOADBALANCING_ACTION__LOADBALANCING_STRATEGY = eINSTANCE
                .getLoadbalancingAction_LoadbalancingStrategy();

        /**
         * The meta object literal for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl <em>Branch Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingBranchTransition()
         * @generated
         */
        EClass LOADBALANCING_BRANCH_TRANSITION = eINSTANCE.getLoadbalancingBranchTransition();

        /**
         * The meta object literal for the '<em><b>Loadbalancing Action Loadbalancing Branch Transition</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION = eINSTANCE
                .getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition();

        /**
         * The meta object literal for the '<em><b>Branch Behaviour Loadbalancing Branch Transition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION = eINSTANCE
                .getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition();

        /**
         * The meta object literal for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingResourceDemandingBehaviourImpl <em>Resource Demanding Behaviour</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingResourceDemandingBehaviourImpl
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingResourceDemandingBehaviour()
         * @generated
         */
        EClass LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR = eINSTANCE.getLoadbalancingResourceDemandingBehaviour();

        /**
         * The meta object literal for the '<em><b>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR = eINSTANCE
                .getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour();

        /**
         * The meta object literal for the '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy <em>Strategy</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy
         * @see org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingPackageImpl#getLoadbalancingStrategy()
         * @generated
         */
        EEnum LOADBALANCING_STRATEGY = eINSTANCE.getLoadbalancingStrategy();

    }

} //LoadbalancingPackage
