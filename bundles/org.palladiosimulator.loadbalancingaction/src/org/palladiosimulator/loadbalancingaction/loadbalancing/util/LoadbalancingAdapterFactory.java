/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.loadbalancingaction.loadbalancing.*;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage
 * @generated
 */
public class LoadbalancingAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static LoadbalancingPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = LoadbalancingPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadbalancingSwitch<Adapter> modelSwitch = new LoadbalancingSwitch<Adapter>() {
        @Override
        public Adapter caseLoadbalancingAction(LoadbalancingAction object) {
            return createLoadbalancingActionAdapter();
        }

        @Override
        public Adapter caseLoadbalancingBranchTransition(LoadbalancingBranchTransition object) {
            return createLoadbalancingBranchTransitionAdapter();
        }

        @Override
        public Adapter caseLoadbalancingResourceDemandingBehaviour(LoadbalancingResourceDemandingBehaviour object) {
            return createLoadbalancingResourceDemandingBehaviourAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter caseAbstractAction(AbstractAction object) {
            return createAbstractActionAdapter();
        }

        @Override
        public Adapter caseAbstractInternalControlFlowAction(AbstractInternalControlFlowAction object) {
            return createAbstractInternalControlFlowActionAdapter();
        }

        @Override
        public Adapter caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
            return createResourceDemandingBehaviourAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction
     * @generated
     */
    public Adapter createLoadbalancingActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition <em>Branch Transition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition
     * @generated
     */
    public Adapter createLoadbalancingBranchTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour
     * @generated
     */
    public Adapter createLoadbalancingResourceDemandingBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.AbstractAction <em>Abstract Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractAction
     * @generated
     */
    public Adapter createAbstractActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction <em>Abstract Internal Control Flow Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction
     * @generated
     */
    public Adapter createAbstractInternalControlFlowActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour
     * @generated
     */
    public Adapter createResourceDemandingBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //LoadbalancingAdapterFactory
