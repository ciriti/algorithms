
public class SimplePermutator {
	public int elementi[];
	public int len;

	public SimplePermutator(int n) {
		elementi = new int[n];
		for (int a = 0; a < n; a++)elementi[a] = a + 1;
		this.len=n;
	}

	private void swap(int a, int b){
		int t=elementi[a];
		elementi[a]=elementi[b];
		elementi[b]=t;
	}

	public boolean prossima() {
		int i = len - 1;
		while (i>0 && (elementi[i - 1] >= elementi[i])) {
			i--;
		}
		if(i==0)return false;
		int j = len;
		while (elementi[j - 1] <= elementi[i - 1])j--;
		swap(i - 1, j - 1);
		i++;
		j = len;
		while (i < j) {
			swap(i - 1, j - 1);
			i++;
			j--;
		}
		return true;
	}

	@Override
	public String toString(){
		return Array_util.dump(elementi);
	}

	public static class Array_util {
		static public String dump(int[] elementi) {
			StringBuffer e = new StringBuffer();

			if (elementi.length > 0) {
				e.append("[ " + elementi[0]);

				for (int i = 1; i < elementi.length; i++) {
					e.append(",");
					e.append(elementi[i]);
				}
			}
			e.append(" ]");
			return e.toString();
		}

	}

	public static void main(String[] args) {
		SimplePermutator p=new SimplePermutator(5);
		System.out.println("Using "+p.getClass().getName());
		do{
			System.out.println(p.toString());
		}while(p.prossima());
	}
}


