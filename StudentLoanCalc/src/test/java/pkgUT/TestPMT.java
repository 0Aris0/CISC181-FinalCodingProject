package pkgUT;

import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

import app.controller.calHelper;

public class TestPMT {

	@Test
	public void Test() {
		double PMT;
		
		double r = 0.08 / 12;
		double n = 20 * 12;
		double p = 200000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1672.88;
		assertEquals(PMTExpected, PMT, 0.01);
		System.out.println(Math.abs(FinanceLib.pmt(r, n, p, f, t)));
		
	}
	
	@Test
	public void TpTest(){
		double PMT;
		double r = 0.08 / 12;
		double n = 20 * 12;
		
		double p = 200000;
		double f = 0;
		
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1672.88;
		assertEquals(PMTExpected, PMT, 0.01);

	}

	@Test
	public void TInterestTest(){
		double Loan = 300000;
		int years = 20;
		double interest = .06;
		double additionalAmount = 0;
		
		
		
		calHelper lc = new calHelper(Loan, additionalAmount, years, interest);
	
		double interest1 = lc.CalculateTotalInterest();
		
		
		System.out.println(interest1);
		assertEquals(interest1, 215830.36, .01);
		
	}
}


