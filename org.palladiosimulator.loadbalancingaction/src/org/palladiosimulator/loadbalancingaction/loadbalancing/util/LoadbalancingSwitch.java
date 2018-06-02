/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.loadbalancingaction.loadbalancing.*;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage
 * @generated
 */
public class LoadbalancingSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static LoadbalancingPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingSwitch() {
        if (modelPackage == null) {
            modelPackage = LoadbalancingPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case LoadbalancingPackage.LOADBALANCING_ACTION: {
            LoadbalancingAction loadbalancingAction = (LoadbalancingAction) theEObject;
            T result = caseLoadbalancingAction(loadbalancingAction);
            if (result == null)
                result = caseAbstractInternalControlFlowAction(loadbalancingAction);
            if (result == null)
                result = caseAbstractAction(loadbalancingAction);
            if (result == null)
                result = caseEntity(loadbalancingAction);
            if (result == null)
                result = caseIdentifier(loadbalancingAction);
            if (result == null)
                result = caseNamedElement(loadbalancingAction);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case LoadbalancingPackage.LOADBALANCING_BRANCH_TRANSITION: {
            LoadbalancingBranchTransition loadbalancingBranchTransition = (LoadbalancingBranchTransition) theEObject;
            T result = caseLoadbalancingBranchTransition(loadbalancingBranchTransition);
            if (result == null)
                result = caseEntity(loadbalancingBranchTransition);
            if (result == null)
                result = caseIdentifier(loadbalancingBranchTransition);
            if (result == null)
                result = caseNamedElement(loadbalancingBranchTransition);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case LoadbalancingPackage.LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR: {
            LoadbalancingResourceDemandingBehaviour loadbalancingResourceDemandingBehaviour = (LoadbalancingResourceDemandingBehaviour) theEObject;
            T result = caseLoadbalancingResourceDemandingBehaviour(loadbalancingResourceDemandingBehaviour);
            if (result == null)
                result = caseResourceDemandingBehaviour(loadbalancingResourceDemandingBehaviour);
            if (result == null)
                result = caseIdentifier(loadbalancingResourceDemandingBehaviour);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoadbalancingAction(LoadbalancingAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Branch Transition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Branch Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoadbalancingBranchTransition(LoadbalancingBranchTransition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoadbalancingResourceDemandingBehaviour(LoadbalancingResourceDemandingBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractAction(AbstractAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Internal Control Flow Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Internal Control Flow Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractInternalControlFlowAction(AbstractInternalControlFlowAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //LoadbalancingSwitch
