import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;


public class Population {
	
	public static void main(String[] args) {
		Population p = new Population(10, 8);
		p.SortByFitness();
		for (Chromosome c : p.getIndividuos()) {
			System.out.println(c.getFitness());
		}
	}
	private double probMutation;
	
	private int size;
	
	private ArrayList<Chromosome> individuos = new ArrayList<Chromosome>();
	
	public Population(int size, int sizeChromosome) {
		setSize(size);
		for (int i = 0; i < getSize(); i++) {
			individuos.add(new Chromosome(sizeChromosome));
		}
	}
	
	public Population(){
		
	}

	public ArrayList<Chromosome> getIndividuos() {
		return individuos;
	}
	
	public void newUsingCrossover(){
		Chromosome bestOne = new Chromosome();
		Chromosome bestTwo = new Chromosome();
		this.SortByFitness();
		bestOne.setGenes(this.getIndividuos().get(0).getGenes());
		bestTwo.setGenes(this.getIndividuos().get(1).getGenes());
	}
	
	public void newUsingMutation(){
		ArrayList<Chromosome> ind = new ArrayList<Chromosome>();
		for (Chromosome c : getIndividuos()) {
			Chromosome newChromo = new Chromosome();
			newChromo.setGenes(Genetic.mutation(c.getGenes(), getProbMutation()));
			ind.add(newChromo);
		}
		this.setIndividuos(ind);
	}
	
	public void SortByFitness(){
		Collections.sort(getIndividuos());
	}

	public void setIndividuos(ArrayList<Chromosome> individuos) {
		this.individuos = individuos;
	}

	public double getProbMutation() {
		return probMutation;
	}

	public void setProbMutation(double probMutation) {
		this.probMutation = probMutation;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
