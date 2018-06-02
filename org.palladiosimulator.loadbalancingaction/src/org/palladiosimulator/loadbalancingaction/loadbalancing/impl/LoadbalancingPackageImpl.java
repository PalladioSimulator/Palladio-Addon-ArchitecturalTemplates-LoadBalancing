/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingAction;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingBranchTransition;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingFactory;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingResourceDemandingBehaviour;
import org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingStrategy;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadbalancingPackageImpl extends EPackageImpl implements LoadbalancingPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass loadbalancingActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass loadbalancingBranchTransitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass loadbalancingResourceDemandingBehaviourEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum loadbalancingStrategyEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private LoadbalancingPackageImpl() {
        super(eNS_URI, LoadbalancingFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link LoadbalancingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static LoadbalancingPackage init() {
        if (isInited)
            return (LoadbalancingPackage) EPackage.Registry.INSTANCE.getEPackage(LoadbalancingPackage.eNS_URI);

        // Obtain or create and register package
        final LoadbalancingPackageImpl theLoadbalancingPackage = (LoadbalancingPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof LoadbalancingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new LoadbalancingPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        IdentifierPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();
        ProbfunctionPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        UnitsPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theLoadbalancingPackage.createPackageContents();

        // Initialize created meta-data
        theLoadbalancingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theLoadbalancingPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(LoadbalancingPackage.eNS_URI, theLoadbalancingPackage);
        return theLoadbalancingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLoadbalancingAction() {
        return this.loadbalancingActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLoadbalancingAction_Branches_Loadbalancing() {
        return (EReference) this.loadbalancingActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLoadbalancingAction_LoadbalancingStrategy() {
        return (EAttribute) this.loadbalancingActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLoadbalancingBranchTransition() {
        return this.loadbalancingBranchTransitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition() {
        return (EReference) this.loadbalancingBranchTransitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition() {
        return (EReference) this.loadbalancingBranchTransitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLoadbalancingResourceDemandingBehaviour() {
        return this.loadbalancingResourceDemandingBehaviourEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour() {
        return (EReference) this.loadbalancingResourceDemandingBehaviourEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getLoadbalancingStrategy() {
        return this.loadbalancingStrategyEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadbalancingFactory getLoadbalancingFactory() {
        return (LoadbalancingFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated)
            return;
        this.isCreated = true;

        // Create classes and their features
        this.loadbalancingActionEClass = this.createEClass(LOADBALANCING_ACTION);
        this.createEReference(this.loadbalancingActionEClass, LOADBALANCING_ACTION__BRANCHES_LOADBALANCING);
        this.createEAttribute(this.loadbalancingActionEClass, LOADBALANCING_ACTION__LOADBALANCING_STRATEGY);

        this.loadbalancingBranchTransitionEClass = this.createEClass(LOADBALANCING_BRANCH_TRANSITION);
        this.createEReference(this.loadbalancingBranchTransitionEClass,
                LOADBALANCING_BRANCH_TRANSITION__LOADBALANCING_ACTION_LOADBALANCING_BRANCH_TRANSITION);
        this.createEReference(this.loadbalancingBranchTransitionEClass,
                LOADBALANCING_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_LOADBALANCING_BRANCH_TRANSITION);

        this.loadbalancingResourceDemandingBehaviourEClass = this.createEClass(LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR);
        this.createEReference(this.loadbalancingResourceDemandingBehaviourEClass,
                LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR__LOADBALANCING_BRANCH_TRANSITION_LOADBALANCING_RESOURCE_DEMANDING_BEHAVIOUR);

        // Create enums
        this.loadbalancingStrategyEEnum = this.createEEnum(LOADBALANCING_STRATEGY);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized)
            return;
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.loadbalancingActionEClass.getESuperTypes().add(theSeffPackage.getAbstractInternalControlFlowAction());
        this.loadbalancingBranchTransitionEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.loadbalancingResourceDemandingBehaviourEClass.getESuperTypes()
                .add(theSeffPackage.getResourceDemandingBehaviour());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.loadbalancingActionEClass, LoadbalancingAction.class, "LoadbalancingAction", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getLoadbalancingAction_Branches_Loadbalancing(), this.getLoadbalancingBranchTransition(),
                this.getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition(),
                "branches_Loadbalancing", null, 0, -1, LoadbalancingAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getLoadbalancingAction_LoadbalancingStrategy(), this.getLoadbalancingStrategy(),
                "loadbalancingStrategy", "RANDOM", 1, 1, LoadbalancingAction.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.loadbalancingBranchTransitionEClass, LoadbalancingBranchTransition.class,
                "LoadbalancingBranchTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getLoadbalancingBranchTransition_LoadbalancingAction_LoadbalancingBranchTransition(),
                this.getLoadbalancingAction(), this.getLoadbalancingAction_Branches_Loadbalancing(),
                "loadbalancingAction_LoadbalancingBranchTransition", null, 1, 1, LoadbalancingBranchTransition.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition(),
                this.getLoadbalancingResourceDemandingBehaviour(),
                this.getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(),
                "branchBehaviour_LoadbalancingBranchTransition", null, 1, 1, LoadbalancingBranchTransition.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.loadbalancingResourceDemandingBehaviourEClass, LoadbalancingResourceDemandingBehaviour.class,
                "LoadbalancingResourceDemandingBehaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(
                this.getLoadbalancingResourceDemandingBehaviour_LoadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour(),
                this.getLoadbalancingBranchTransition(),
                this.getLoadbalancingBranchTransition_BranchBehaviour_LoadbalancingBranchTransition(),
                "loadbalancingBranchTransition_LoadbalancingResourceDemandingBehaviour", null, 0, 1,
                LoadbalancingResourceDemandingBehaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        this.initEEnum(this.loadbalancingStrategyEEnum, LoadbalancingStrategy.class, "LoadbalancingStrategy");
        this.addEEnumLiteral(this.loadbalancingStrategyEEnum, LoadbalancingStrategy.RANDOM);
        this.addEEnumLiteral(this.loadbalancingStrategyEEnum, LoadbalancingStrategy.JOBSLOT_FIRSTFIT);

        // Create resource
        this.createResource(eNS_URI);
    }

} //LoadbalancingPackageImpl
