package cse2010.hw2;

/**
 * A Polynomial ADT
 * DO NOT MODIFY!!
 */
public interface Polynomial {
    /**
     * Returns the degree of this polynomial.
     * @return the degree of this polynomial
     */
    int degree(); //다항식의 차수 return

    /**
     * Returns the number of terms in this polynomial.
     * @return the number of terms in this polynomial
     */
    int getTermCount(); //차수 다른게 몇개인지 return

    /**
     * Returns the coefficient of the term with the given exponent.
     * @param exponent the exponent
     * @return the coefficient of the term with the given exponent
     */
    int getCoefficient(int exponent); //주어진 지수에 대한 계수 return

    /**
     * Insert a new term into a given polynomial.
     * @param coef the coefficient
     * @param exponent the exponent
     */
    void addTerm(int coef, int exponent); //다항식 추가하기

    /**
     * Returns a new polynomial that is the sum of this polynomial and the given polynomial.
     * @param rhs the given polynomial
     * @return a new polynomial that is the sum of this polynomial and the given polynomial
     */
    Polynomial add(Polynomial rhs); //주어진 다항식과 rhs 다항식의 합인 다항식을 return

    /**
     * Returns a new polynomial that is the product of this polynomial and the given polynomial.
     * @param rhs the given polynomial
     * @return a new polynomial that is the product of this polynomial and the given polynomial
     */
    Polynomial mult(Polynomial rhs);  //주어진 다항식과 rhs 다항식의 곱인 다항식을 return

    /**
     * Returns the value of this polynomial for the given value of x.
     * @param x the value of x
     * @return the value of this polynomial for the given value of x
     */
    double eval(double x); //x를 다항식에 넣었을 때 식의 값 return
}
