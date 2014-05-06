import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Attempt {
	static int pitiprim = 0;

	// Functie pentru actualizarea numberului pitiprim
	boolean newPit(int k, int digits[]) {

		int nr = 0;

		if (digits[0] == 1) {
			return false;
		}

		for (int i = 0; i < k; i++) {

			nr = nr * 10 + digits[i];

		}

		if ((k != 0) && (isPitiprim(nr)) && (nr > pitiprim)) {

			pitiprim = nr;
			return true;

		}

		return false;

	}

	// Functie care returneaza daca un number este prim sau nu
	boolean isPrime(int number) {
		int finish = (int) (Math.sqrt(number) + 1);
		if (number == 2) {
			return true;
		}

		for (int i = 2; i < finish; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;

	}

	// Functie care returneaza daca un number este pitiprim sau nu
	boolean isPitiprim(int number) {

		while (number > 0) {

			if (!isPrime(number)) {

				return false;

			}
			number = number / 10;

		}

		return true;

	}

	// Functie de backtracking care imi gerereaza permutari in functie de
	// cifrele numarului
	// si imi actualizeaza numarul pitiprim
	void back(int k, int digits[], int nrCifre, int newVect[], boolean used[]) {

		boolean viz[] = new boolean[12];
		if (k <= nrCifre + 1) {

			newPit(k, newVect);

		}

		if (k < nrCifre + 1) {

			for (int i = 0; i < nrCifre; i++) {

				if (!used[i] && !viz[digits[i]]) {

					newVect[k] = digits[i];

					viz[digits[i]] = true;

					used[i] = true;
					int number = 0;

					for (int j = 0; j < k; j++) {

						number = number * 10 + newVect[j];

					}
					if (!isPitiprim(number)) {
						viz[digits[i]] = false;

					} else {

						back(k + 1, digits, nrCifre, newVect, used);

					}

					used[i] = false;

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		BufferedWriter bufwriter = null;
		try {
			bufwriter = new BufferedWriter(new FileWriter("pitiprim.out"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		long n;
		int size;
		int digits[] = new int[12];
		int newVect[] = new int[12];
		boolean used[] = new boolean[12];
		try {
			scanner = new Scanner(new File("pitiprim.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		size = scanner.nextInt();
		for (int i = 0; i < size; i++) {
			n = scanner.nextLong();
			pitiprim = 0;
			int index = 0;
			boolean flag = false;

			while (n != 0) {

				if ((n % 10 == 2) || ((n % 10) % 2 != 0)) {

					digits[index++] = (int) (n % 10);

				}

				if ((n % 10) == 2) {

					flag = true;

				}

				n = n / 10;

			}

			if (flag && index == 0) {

				digits[index++] = 2;

			}
			Attempt a = new Attempt();
			a.back(0, digits, index, newVect, used);

			//System.out.println(pitiprim);

			bufwriter.write(pitiprim + "\n");

		}
		bufwriter.close();
	}
}
