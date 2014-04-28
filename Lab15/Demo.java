public class Demo {

    private String target;
    private int loc;
    private int a_count, b_count;

    public Demo(String t) {
	target = t;
	loc = 0;
	a_count = 0;
	b_count = 0;
    }

    public boolean hasMoreChars() {
	return (target != null) && (loc < target.length());
    }

    public char peekChar() throws Exception {
	if (!hasMoreChars())
	    throw new Exception("No characters available");
	return target.charAt(loc);
    }

    public char nextChar() throws Exception {
	char ch = peekChar();
	loc++;
	// System.out.println("... next char is " + ch);
	return ch;
    }

    public void match(char want) throws Exception {
	char got = nextChar();
	if (want != got)
	    throw new Exception("Wanted "+want+" but got "+got);
    }

    public void parse() throws Exception {
	char ch;
	while (hasMoreChars()) {
	    ch = nextChar();
	    if (ch == 'a') {
		if (b_count > 0)
		    throw new Exception("a's occur after b's");
		a_count++;
	    } else if (ch == 'b') {
		b_count++;
	    } else {
		throw new Exception("encountered something other than a or b");
	    }
	}
    }
	
    public void checkAB() {
	try {
	    parse();
	    if (hasMoreChars() || (a_count != b_count))
		System.out.println(target + ": Parse error");
	    else
		System.out.println(target + ": OK");
	} catch (Exception e) {
	    System.out.println(target + ": " + e);
	}
    }
	
    public static void main(String [] args) {
    	Demo a,b,c,d,e,f,g,h;
    	a = new Demo("a");
    	b = new Demo("ab");
    	c = new Demo("abb");
    	d = new Demo("abba");
    	e = new Demo("abab");
    	f = new Demo("aaaaaaaabbbbbbbb");
    	g = new Demo("abc");
    	h = new Demo("cab");
    	a.checkAB();
    	b.checkAB();
    	c.checkAB();
    	d.checkAB();
    	e.checkAB();
    	f.checkAB();
    	g.checkAB();
    	h.checkAB();
    	
	}
    }

	
