/**
 */
package org.palladiosimulator.loadbalancingaction.loadbalancing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Strategy</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.loadbalancingaction.loadbalancing.LoadbalancingPackage#getLoadbalancingStrategy()
 * @model
 * @generated
 */
public enum LoadbalancingStrategy implements Enumerator {
    /**
     * The '<em><b>RANDOM</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RANDOM_VALUE
     * @generated
     * @ordered
     */
    RANDOM(0, "RANDOM", "RANDOM"),

    /**
     * The '<em><b>JOBSLOT FIRSTFIT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JOBSLOT_FIRSTFIT_VALUE
     * @generated
     * @ordered
     */
    JOBSLOT_FIRSTFIT(1, "JOBSLOT_FIRSTFIT", "JOBSLOT_FIRSTFIT");

    /**
     * The '<em><b>RANDOM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>RANDOM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RANDOM
     * @model
     * @generated
     * @ordered
     */
    public static final int RANDOM_VALUE = 0;

    /**
     * The '<em><b>JOBSLOT FIRSTFIT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JOBSLOT FIRSTFIT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JOBSLOT_FIRSTFIT
     * @model
     * @generated
     * @ordered
     */
    public static final int JOBSLOT_FIRSTFIT_VALUE = 1;

    /**
     * An array of all the '<em><b>Strategy</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final LoadbalancingStrategy[] VALUES_ARRAY = new LoadbalancingStrategy[] { RANDOM,
            JOBSLOT_FIRSTFIT, };

    /**
     * A public read-only list of all the '<em><b>Strategy</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<LoadbalancingStrategy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Strategy</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static LoadbalancingStrategy get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            LoadbalancingStrategy result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Strategy</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static LoadbalancingStrategy getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            LoadbalancingStrategy result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Strategy</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static LoadbalancingStrategy get(int value) {
        switch (value) {
        case RANDOM_VALUE:
            return RANDOM;
        case JOBSLOT_FIRSTFIT_VALUE:
            return JOBSLOT_FIRSTFIT;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private LoadbalancingStrategy(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} //LoadbalancingStrategy
