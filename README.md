Prime
=====
Enunt pe scurt:

Fisier de intrare: un numar "lung"

Fisier de iesire: cel mai mare numar pitiprim care se poate forma din aranjamentele
  cifrelor(prin numar pitiprim se intelege un numar prim, care are si toate "prefixele" 
  prime ex: 719 e pitiprim pentru ce 719 e prim, 71 e prim si 7 e prim)

Am folosit: 
		
		- o functie care imi spune daca un numar este prim sau 
nu(complexitate O(sqrt(n))
		- o functie care imi spune daca un numar este pitiprim 
sau nu(verificand toate prefixele)
		- o functie de actualizare a numarului cautat(trebuie returnat
cel mai mare numar pitiprim)
		- o functie de backtracking care genereaza permutarile "utile" ale 
numarului dar ca parametru si actualizeaza numarul pitiprim.
