package Accessible;


public class X {

    private Q q;

    // constructor
    public X(int a) { q = new Q(a); }

    // accessor
    public Q getQ() { return q; }

    // toString
    public String toString() { return q.toString(); }
}
    
