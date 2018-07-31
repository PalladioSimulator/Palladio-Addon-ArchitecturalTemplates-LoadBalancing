/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy;

import org.palladiosimulator.pcm.seff.impl.AbstractInternalControlFlowActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl#getBranches_Loadbalancing <em>Branches Loadbalancing</em>}</li>
 *   <li>{@link org.palladiosimulator.loadbalancingaction.loadbalancing.impl.LoadbalancingActionImpl#getLoadbalancingStrategy <em>Loadbalancing Strategy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadbalancingActionImpl extends AbstractInternalControlFlowActionImpl implements LoadbalancingAction {
    /**
     * The default value of the '{@link #getLoadbalancingStrategy() <em>Loadbalancing Strategy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoadbalancingStrategy()
     * @generated
     * @ordered
     */
    protected static final LoadbalancingStrategy LOADBALANCING_STRATEGY_EDEFAULT = LoadbalancingStrategy.RANDOM;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LoadbalancingPackage.Literals.LOADBALANCING_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<LoadbalancingBranchTransition> getBranches_Loadbalancing() {
        return (EList<LoadbalancingBranchTransition>) this.eDynamicGet(
                LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING,
                LoadbalancingPackage.Literals.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingStrategy getLoadbalancingStrategy() {
        return (LoadbalancingStrategy) this.eDynamicGet(LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY,
                LoadbalancingPackage.Literals.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoadbalancingStrategy(final LoadbalancingStrategy newLoadbalancingStrategy) {
        this.eDynamicSet(LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY,
                LoadbalancingPackage.Literals.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY, newLoadbalancingStrategy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getBranches_Loadbalancing()).basicAdd(otherEnd,
                    msgs);
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
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            return ((InternalEList<?>) this.getBranches_Loadbalancing()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            return this.getBranches_Loadbalancing();
        case LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY:
            return this.getLoadbalancingStrategy();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            this.getBranches_Loadbalancing().clear();
            this.getBranches_Loadbalancing().addAll((Collection<? extends LoadbalancingBranchTransition>) newValue);
            return;
        case LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY:
            this.setLoadbalancingStrategy((LoadbalancingStrategy) newValue);
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
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            this.getBranches_Loadbalancing().clear();
            return;
        case LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY:
            this.setLoadbalancingStrategy(LOADBALANCING_STRATEGY_EDEFAULT);
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
        case LoadbalancingPackage.LOADBALANCING_ACTION__BRANCHES_LOADBALANCING:
            return !this.getBranches_Loadbalancing().isEmpty();
        case LoadbalancingPackage.LOADBALANCING_ACTION__LOADBALANCING_STRATEGY:
            return this.getLoadbalancingStrategy() != LOADBALANCING_STRATEGY_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //LoadbalancingActionImpl
