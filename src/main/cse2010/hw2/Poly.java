package cse2010.hw2;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * An array implementation of the polynomial API.
 */
public class Poly implements Polynomial {

    private Term[] terms;   // array of terms, not sorted
    private int next = 0;   // denotes next available slot & (term count)

    /**
     * Creates a new polynomial which can hold up to `termCount` `Term`s.
     *
     * @param maxCount number of terms
     */
    public Poly(int maxCount) {

        // you code goes here
    }

    /**
     * Creates a new polynomial with given terms as parameters.
     *
     * @param terms array of terms to be added.
     */
    public Poly(Term... terms) {
        this(terms.length);

        for (Term term : terms) {
            addTerm(term.coef, term.exp);
        }
    }

    /**
     * Returns the degree of this polynomial.
     *
     * @return degree of polynomial
     */
    @Override
    public int degree() {
        // your code goes here
        return 0;
    }

    /**
     * Returns the number of terms in this polynomial.
     *
     * @return the number of terms
     */
    @Override
    public int getTermCount() {
        return next;
    }

    /**
     * Returns the coefficient of the term with the given exponent.
     *
     * @param exponent exponent
     * @return coefficient of the term with the given exponent
     */
    @Override
    public int getCoefficient(int exponent) {
        return 0;
    }

    /**
     * Insert a new term into a given polynomial.
     *
     * @param coef     coefficient
     * @param exponent exponent
     */
    @Override
    public void addTerm(int coef, int exponent) {

        // you code goes here
    }

    /**
     * Adds the target polynomial object with the one given as a parameter.
     * As a result, the returned polynomial object will eventually represent
     * the sum of two polynomials (C = A.add(B). Note that A should not be
     * modified as a result of this operation.
     *
     * @param rhs a polynomial
     * @return a new polynomial (`rhs` + `this`)
     */
    @Override
    public Polynomial add(Polynomial rhs) {

        // you code goes here
        return null;
    }

    /**
     * Multiply the target polynomial object with the one given as a parameter.
     * As a result, the returned polynomial object will eventually represent
     * the product of two polynomials (C = A.mutiply(B). Note that A should not be
     * modified as a result of this operation.
     *
     * @param rhs a polynomial
     * @return a new polynomial (`rhs` * `this`)
     */
    @Override
    public Polynomial mult(Polynomial rhs) {

        // you code goes here
        return null;
    }

    /**
     * Evaluates the polynomial for a given value of x.
     *
     * @param x a value of x
     * @return the value of the polynomial for the given value of x
     */
    @Override
    public double eval(double x) {
        return 0;
    }

    /**
     * Returns a string representation of this polynomial.
     *
     * @return a string representation of this polynomial
     */
    @Override
    public String toString() {
        // Sample code ... you can freely modify this code if necessary
        Arrays.sort(terms, 0, next, (a, b) -> b.exp - a.exp);
        return Arrays.stream(terms)
                .filter(Objects::nonNull)
                .map(Term::toString)
                .collect(Collectors.joining(" + "));
    }

}

