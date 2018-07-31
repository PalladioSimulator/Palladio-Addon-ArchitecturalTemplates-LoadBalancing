/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.loadbalancingaction.loadbalancing.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadbalancingFactoryImpl extends EFactoryImpl implements LoadbalancingFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static LoadbalancingFactory init() {
        try {
            LoadbalancingFactory theLoadbalancingFactory = (LoadbalancingFactory) EPackage.Registry.INSTANCE
                    .getEFactory(LoadbalancingPackage.eNS_URI);
            if (theLoadbalancingFactory != null) {
                return theLoadbalancingFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new LoadbalancingFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case LoadbalancingPackage.LOADBALANCING_ACTION:
            return createLoadbalancingAction();
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION:
            return createLoadbalancingBranchTransition();
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR:
            return createLoadbalancingResourceDemandingBehaviour();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case LoadbalancingPackage.LOADBALANCING_STRATEGY:
            return createLoadbalancingStrategyFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case LoadbalancingPackage.LOADBALANCING_STRATEGY:
            return convertLoadbalancingStrategyToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingAction createLoadbalancingAction() {
        LoadbalancingActionImpl loadbalancingAction = new LoadbalancingActionImpl();
        return loadbalancingAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingBranchTransition createLoadbalancingBranchTransition() {
        LoadbalancingBranchTransitionImpl loadbalancingBranchTransition = new LoadbalancingBranchTransitionImpl();
        return loadbalancingBranchTransition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingResourceDemandingBehaviour createLoadbalancingResourceDemandingBehaviour() {
        LoadbalancingResourceDemandingBehaviourImpl loadbalancingResourceDemandingBehaviour = new LoadbalancingResourceDemandingBehaviourImpl();
        return loadbalancingResourceDemandingBehaviour;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingStrategy createLoadbalancingStrategyFromString(EDataType eDataType, String initialValue) {
        LoadbalancingStrategy result = LoadbalancingStrategy.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException(
                    "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertLoadbalancingStrategyToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingPackage getLoadbalancingPackage() {
        return (LoadbalancingPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static LoadbalancingPackage getPackage() {
        return LoadbalancingPackage.eINSTANCE;
    }

} //LoadbalancingFactoryImpl
