import java.util.ArrayList;



public class Chromosome implements Comparable<Chromosome> {
	
	
	private int size;
	
	private int fitness; //numero de rainhas em check
	
	private ArrayList<Integer> genes = new ArrayList<Integer>();
	
	public Chromosome(int size) {
		setSize(size);
		while(genes.size() < getSize()) {
			Integer gene = (int) (Math.random() * getSize());
			gene++;
			if(!genes.contains(gene)){
				genes.add(gene);
			}
		}
		setFitness();
	}
	
	public Chromosome(){
		
	}

	public ArrayList<Integer> getGenes() {
		return genes;
	}

	public void setGenes(ArrayList<Integer> genes) {
		this.genes = genes;
		setFitness();
	}

	public int getSize() {
		return size;
	}
	
	public int getFitness(){
		return fitness;
	}
	
	public void setFitness(){

        int fitness = 0;
        
        for (int i = 0; i < getGenes().size(); i++) {
			if(isCheck(getGenes(), i)){
				fitness++;
			}
		}

		this.fitness = fitness;
	}
	
	public static boolean isCheck(ArrayList<Integer> array, int index){
		if(index == 0 || index == (array.size() - 1)) return false;
		if(array.get(index) == 1 || array.get(index) == array.size()) return false;
		for (Integer integer : array) {
			if(integer == array.get(index)) continue;
			if(Math.abs(array.indexOf(integer) - index) == Math.abs(integer - array.get(index))) return true;
		}
		return false;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Chromosome o) {
		if(this.getFitness() < o.getFitness()){
			return -1;
		} 
		if (this.getFitness() > o.getFitness()){
			return 1;
		}
		return 0;
	}
	
	
}
