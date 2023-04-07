package cse2010.hw2;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * An array implementation of the polynomial API.
 */
public class Poly implements Polynomial {

    private Term[] terms; // array of terms, not sorted
    private int next = 0; // denotes next available slot & (term count)

    /**
     * Creates a new polynomial which can hold up to `maxCount` Term`s.
     *
     * @param maxCount number of terms
     */
    public Poly(int maxCount) {
        //젤 높은 차수를 확인하여 term을 maxcount만큼 생성하는 함수.
        // you code goes here
        terms = new Term[maxCount];
    }

    /**
     * Creates a new polynomial with given terms as parameters.
     *
     * @param terms array of terms to be added.
     */
    public Poly(Term... terms) { //terms 배열 보고 polynomial 만드는 함수.
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
        // 지수가 제일 큰걸 return
        // your code goes here
        int degree = 0;
        for(int i=0; i<next; i++){
            if(terms[i].exp > degree){
                degree = terms[i].exp;
            }
        }
        return degree;
    }

    /**
     * Returns the number of terms in this polynomial.
     *
     * @return the number of terms
     */
    @Override
    public int getTermCount() { //다항식의 항 수를 return

        return next;
    }

    /**
     * Returns the coefficient of the term with the given exponent.
     *
     * @param exponent exponent
     * @return coefficient of the term with the given exponent
     */
    @Override
    public int getCoefficient(int exponent) { //주어진 지수에 대한 계수 return
        for(int i=0; i<next; i++){
            if(terms[i].exp == exponent){
                return terms[i].coef;
            }
        }
        return 0; //지수에 해당하는 항이 없으면 0을 return
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
        /* //maxCount보다 지수가 더 큰걸 요구했을 경우
        if(exponent >= terms.length){
            Term[] newTerms = new Term[terms.length*2]; //maxCount의 2배인 배열을 만들어준다.
            for(int i=0; i<next; i++){
                newTerms[i] = terms[i]; //newTerms 배열에 기존 terms 배열을 복사한다.
            }
            terms = newTerms; //terms에 newTerms를 덮어씌운다.
        }*/

        //지수가 겹칠때
        for(int i=0; i<next; i++){
            if(terms[i].exp == exponent){
                terms[i].coef += coef;
                return;
            }
        }

        //terms 배열에 Term 객체 항 넣기
        terms[next] = new Term(coef, exponent);
        next++;
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
        //주어진 다항식과 rhs 다항식의 합인 다항식을 return
        //주어진 다항식은 변경되어서는 안된다.

        // you code goes here
        Poly other = (Poly) rhs;
        Poly sum = new Poly(this.terms.length + other.terms.length);

        int i=0;
        int j=0;

        while (i < this.next && j < other.next) {
            Term a = this.terms[i];
            Term b = other.terms[j];

            if (a.exp > b.exp) {
                sum.addTerm(a.coef, a.exp);
                i++;
            } else if (a.exp < b.exp) {
                sum.addTerm(b.coef, b.exp);
                j++;
            } else { //지수 같을 경우
                sum.addTerm(a.coef + b.coef, a.exp);
                i++;
                j++;
            }
        }

        while (i < this.next) {
            Term a = this.terms[i];
            sum.addTerm(a.coef, a.exp);
            i++;
        }

        while (j < other.next) {
            Term b = other.terms[j];
            sum.addTerm(b.coef, b.exp);
            j++;
        }

        return sum;
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
        //주어진 다항식과 rhs 다항식의 곱인 다항식을 return
        // you code goes here
        Poly other = (Poly) rhs;
        Poly prod = new Poly(this.next * other.next);

        for (int i = 0; i < this.next; i++) {
            for (int j = 0; j < other.next; j++) {
                int coef = this.terms[i].coef * other.terms[j].coef;
                int exp = this.terms[i].exp + other.terms[j].exp;
                prod.addTerm(coef, exp);
            }
        }

        return prod;
    }

    /**
     * Evaluates the polynomial for a given value of x.
     *
     * @param x a value of x
     * @return the value of the polynomial for the given value of x
     */
    @Override
    public double eval(double x) { //x를 다항식에 넣었을 때 식의 값 return
        double result=0;
        for(int i=0; i<next; i++){
            result += terms[i].coef * Math.pow(x, terms[i].exp);
        }
        return result;
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
