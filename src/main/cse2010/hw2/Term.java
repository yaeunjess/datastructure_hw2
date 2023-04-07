package cse2010.hw2;

import java.util.Objects;

/**
 * A class that defines a term inside a polynomial.
 * DO NOT MODIFY!!
 */
public class Term {
    public int coef; //계수
    public int exp; //지수

    /**
     * Constructs a term with the given coefficient and exponent.
     * @param coef the coefficient
     * @param exp the exponent
     */
    public Term(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    /**
     * Returns a string representation of this term.
     * @return a string representation of this term
     */
    @Override
    public String toString() {
        return coef + "x^" + exp;
    }
}
