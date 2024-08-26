package aiControllers;


import gameObjects.Nouns;
import jhealy.aicme4j.NetworkBuilderFactory;
import jhealy.aicme4j.net.Activation;
import jhealy.aicme4j.net.Aicme4jUtils;
import jhealy.aicme4j.net.LayerSize;
import jhealy.aicme4j.net.Loss;
import jhealy.aicme4j.net.NeuralNetwork;
import jhealy.aicme4j.net.Output;

public class NetworkModels {
	
	private NeuralNetwork fight;
	private NeuralNetwork rest;
	
	public void load() throws Exception {
		fight = Aicme4jUtils.load("./fight.data");
		rest = Aicme4jUtils.load("./rest.data");
	}
	
	public NeuralNetwork getNetwork(Nouns mod) {
		return switch (mod) {
			case FIGHT -> fight;
			case REST -> rest;
			default -> throw new IllegalStateException("Unexpected value: " + mod);
		};
	}
	
public void TrainFightNetwork() throws Exception{
		
		Aicme4jUtils.standardise(fightData); 
		
		NeuralNetwork net = NetworkBuilderFactory.getInstance()
				.newNetworkBuilder()
				.inputLayer("Input", 3)
				.hiddenLayer("Hidden1", Activation.TANH, LayerSize.SUM)
				.outputLayer("Output", Activation.TANH, 3, false)
				.train(fightData, fightExpected, 0.01, 0.95, 100000, 0.00001, Loss.SSE)
				.save("./fight.data")
				.build();
			System.out.println(net);
			
			
		double[] test1 = {2, 0, 1}; //Attack
		System.out.println("2,0,1=>" + net.process(test1, Output.LABEL_INDEX));
		System.out.println("0.0 = Attack, 1.0 = Hide, 2.0 = Run");
	}
	
	double[][] fightData = { //Health, Sword, Gun
			{ 2, 0, 0 }, { 2, 0, 0 }, { 2, 0, 1 }, { 2, 0, 1 }, { 2, 1, 0 },
			{ 2, 1, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 1 }, { 1, 0, 1 }, 
			{ 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 }, 
			{ 0, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 } };

	double[][] fightExpected = { //Attack, Hide, Run
			{ 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0 }, 
			{ 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, 
			{ 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, 
			{ 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0 }, 
			{ 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 } };
	
public void TrainRestNetwork() throws Exception{
		
		Aicme4jUtils.standardise(restData); 
		
		NeuralNetwork net = NetworkBuilderFactory.getInstance()
				.newNetworkBuilder()
				.inputLayer("Input", 3)
				.hiddenLayer("Hidden1", Activation.TANH, LayerSize.SUM)
				.outputLayer("Output", Activation.TANH, 3, false)
				.train(restData, restExpected, 0.01, 0.95, 100000, 0.00001, Loss.SSE)
				.save("./rest.data")
				.build();
			System.out.println(net);
			
			
		double[] test1 = {2, 2, 0}; //Moderate Sleep
		System.out.println("2,2,0=>" + net.process(test1, Output.LABEL_INDEX));
		System.out.println("0.0 = Good Sleep/Regen, 1.0 = Moderate Sleep/Regen, 2.0 = Poor Sleep/Regen");
	}

double[][] restData = { //Safe, Health, Armed
		{ 2, 1, 0 }, { 2, 2, 0 }, { 2, 1, 1 }, { 2, 2, 1 }, { 2, 1, 0 },
		{ 2, 2, 0 }, { 1, 2, 0 }, { 1, 1, 0 }, { 1, 2, 1 }, { 1, 1, 1 }, 
		{ 1, 1, 0 }, { 1, 2, 0 }, { 0, 1, 0 }, { 0, 2, 0 }, { 0, 1, 1 }, 
		{ 0, 2, 1 }, { 0, 1, 0 }, { 0, 2, 0 } };

double[][] restExpected = { //SleepLevel/Health Regeneration: Good, Moderate, Poor
		{ 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0 }, 
		{ 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, 
		{ 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, 
		{ 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0 }, 
		{ 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 } };

}
