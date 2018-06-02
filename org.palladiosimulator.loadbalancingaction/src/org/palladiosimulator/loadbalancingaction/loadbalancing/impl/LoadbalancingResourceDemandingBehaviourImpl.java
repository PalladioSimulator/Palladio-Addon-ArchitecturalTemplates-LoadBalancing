/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour;

import org.palladiosimulator.pcm.seff.impl.ResourceDemandingBehaviourImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Demanding Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingResourceDemandingBehaviourImpl#getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour <em>Loadbalancing Branch Transition Loadbalancing Resource Demanding Behaviour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadbalancingResourceDemandingBehaviourImpl extends ResourceDemandingBehaviourImpl
        implements LoadbalancingResourceDemandingBehaviour {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingResourceDemandingBehaviourImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LoadbalancingPackage.Literals.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingBranchTransition getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour() {
        return (LoadbalancingBranchTransition) this.eDynamicGet(
                LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR,
                LoadbalancingPackage.Literals.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(
            final LoadbalancingBranchTransition newLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer(
                (InternalEObject) newLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour,
                LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(
            final LoadbalancingBranchTransition newLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour) {
        this.eDynamicSet(
                LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR,
                LoadbalancingPackage.Literals.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR,
                newLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            if (this.eInternalContainer() != null)
                msgs = this.eBasicRemoveFromContainer(msgs);
            return this.basicSetLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(
                    (LoadbalancingBranchTransition) otherEnd, msgs);
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.basicSetLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(null, msgs);
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this,
                    LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION,
                    LoadbalancingBranchTransition.class, msgs);
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour();
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(
                    (LoadbalancingBranchTransition) newValue);
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(
                    (LoadbalancingBranchTransition) null);
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
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getLoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour() != null;
        }
        return super.eIsSet(featureID);
    }

} //LoadbalancingResourceDemandingBehaviourImpl
