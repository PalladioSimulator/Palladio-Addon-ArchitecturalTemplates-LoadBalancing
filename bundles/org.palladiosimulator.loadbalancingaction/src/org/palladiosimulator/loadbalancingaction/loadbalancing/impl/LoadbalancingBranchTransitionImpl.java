/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl#getLoadbalancingAction_LoadbalancingBranchTransition <em>Loadbalancing Action Loadbalancing Branch Transition</em>}</li>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingBranchTransitionImpl#getBranchBehaviour_LoadbalancingBranchTransition <em>Branch Behaviour Loadbalancing Branch Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadbalancingBranchTransitionImpl extends EntityImpl implements LoadbalancingBranchTransition {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingBranchTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LoadbalancingPackage.Literals.LOADBALANCING_BRANCH_TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingAction getLoadbalancingAction_LoadbalancingBranchTransition() {
        return (LoadbalancingAction) this.eDynamicGet(
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION,
                LoadbalancingPackage.Literals.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLoadbalancingAction_LoadbalancingBranchTransition(
            final LoadbalancingAction newLoadbalancingAction_LoadbalancingBranchTransition, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newLoadbalancingAction_LoadbalancingBranchTransition,
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoadbalancingAction_LoadbalancingBranchTransition(
            final LoadbalancingAction newLoadbalancingAction_LoadbalancingBranchTransition) {
        this.eDynamicSet(
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION,
                LoadbalancingPackage.Literals.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION,
                newLoadbalancingAction_LoadbalancingBranchTransition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingResourceDemandingBehaviour getBranchBehaviour_LoadbalancingBranchTransition() {
        return (LoadbalancingResourceDemandingBehaviour) this.eDynamicGet(
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                LoadbalancingPackage.Literals.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBranchBehaviour_LoadbalancingBranchTransition(
            final LoadbalancingResourceDemandingBehaviour newBranchBehaviour_LoadbalancingBranchTransition,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newBranchBehaviour_LoadbalancingBranchTransition,
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBranchBehaviour_LoadbalancingBranchTransition(
            final LoadbalancingResourceDemandingBehaviour newBranchBehaviour_LoadbalancingBranchTransition) {
        this.eDynamicSet(
                LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                LoadbalancingPackage.Literals.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                newBranchBehaviour_LoadbalancingBranchTransition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            if (this.eInternalContainer() != null)
                msgs = this.eBasicRemoveFromContainer(msgs);
            return this.basicSetLoadbalancingAction_LoadbalancingBranchTransition((LoadbalancingAction) otherEnd, msgs);
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            final LoadbalancingResourceDemandingBehaviour branchBehaviour_LoadbalancingBranchTransition = this.getBranchBehaviour_LoadbalancingBranchTransition();
            if (branchBehaviour_LoadbalancingBranchTransition != null)
                msgs = ((InternalEObject) branchBehaviour_LoadbalancingBranchTransition).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                        null, msgs);
            return this.basicSetBranchBehaviour_LoadbalancingBranchTransition(
                    (LoadbalancingResourceDemandingBehaviour) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            return this.basicSetLoadbalancingAction_LoadbalancingBranchTransition(null, msgs);
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            return this.basicSetBranchBehaviour_LoadbalancingBranchTransition(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            return this.eInternalContainer().eInverseRemove(this,
                    LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING, LoadbalancingAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            return this.getLoadbalancingAction_LoadbalancingBranchTransition();
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            return this.getBranchBehaviour_LoadbalancingBranchTransition();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            this.setLoadbalancingAction_LoadbalancingBranchTransition((LoadbalancingAction) newValue);
            return;
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            this.setBranchBehaviour_LoadbalancingBranchTransition((LoadbalancingResourceDemandingBehaviour) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            this.setLoadbalancingAction_LoadbalancingBranchTransition((LoadbalancingAction) null);
            return;
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            this.setBranchBehaviour_LoadbalancingBranchTransition((LoadbalancingResourceDemandingBehaviour) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION:
            return this.getLoadbalancingAction_LoadbalancingBranchTransition() != null;
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION:
            return this.getBranchBehaviour_LoadbalancingBranchTransition() != null;
        }
        return super.eIsSet(featureID);
    }

} //LoadbalancingBranchTransitionImpl
