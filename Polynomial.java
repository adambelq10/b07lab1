public class Polynomial {
    double[] coefficients;

    public Polynomial() {
        coefficients = new double[]{0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial add (Polynomial p2) {
        int highestOrder = Math.max(this.coefficients.length, p2.coefficients.length);
        int lowestOrder = Math.min(this.coefficients.length, p2.coefficients.length);
        double[] res = new double[highestOrder];

        for (int i = 0; i < lowestOrder; i++) {
            res[i] = this.coefficients[i] + p2.coefficients[i];
        }
	
	//case 1 where calling object polynomial is higher order
        if (this.coefficients.length > p2.coefficients.length) {
            for (int i = lowestOrder; i < this.coefficients.length; i++) {
                res[i] = this.coefficients[i];
            }
        } 
	//case 2 where argument polynomial is higher order 
        else {
            for (int i = lowestOrder; i < p2.coefficients.length; i++) {
                res[i] = p2.coefficients[i];
            }
        }

        return new Polynomial(res);
    }

    public double evaluate(double x) {
        double res = 0;
        int i = 0;
        while (i < coefficients.length) {
            res += coefficients[i] * Math.pow(x, i);
            i += 1;
        }
        return res;
    }

    public boolean hasRoot(double x) {
     
        if (evaluate(x) == 0) {
            return true;
        }
        
        else {
            return false;
        }
    }
}

    

    	



	



		