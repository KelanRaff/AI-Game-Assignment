package aiControllers;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class FuzzyLogic {
	
	private static final String FCL_FILE = "./fcl/playerspeed.txt";
	private FIS fis;
	private FunctionBlock fb;
	
	public FuzzyLogic() {
		fis = FIS.load(FCL_FILE, true);
		fb = fis.getFunctionBlock("getPlayerSpeed"); 
		JFuzzyChart.get().chart(fis); 
	}
	
	public double getPlayerSpeed(int coverPercentage, int tempCelcius) { 
		fis.setVariable("cover", coverPercentage); 
		fis.setVariable("temp", tempCelcius);
		fis.evaluate();
	
		var speed = fb.getVariable("speed"); 
		
		JFuzzyChart.get().chart(speed.getDefuzzifier(), "Player Speed", true);
		return speed.getValue(); 
	}
	
}
