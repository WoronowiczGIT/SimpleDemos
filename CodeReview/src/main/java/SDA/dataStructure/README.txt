Zadania struktury danych:
1. Napisać aplikację, której zadaniem jest wygenerowanie tablicy int 10 elementowej.
Na podstawie tablicy powinna powstać struktura typu List , która powinna zawierać dokładnie takie same elementy jak tablica.
- na podstawie listy napisać dwie metody:
* do szukania wartości max
* do szukania wartości min

2. Napisz aplikację która będzie realizować symulację kolejki sklepowej. Na potrzeby zadania stwórz 3 klasy:
*. Klasa Client, która będzie zawierać informację o tym, co dana osoba chce kupić (np. String)
*. Klasa Shop, która będzie obsługiwać kolejkę oraz przyjmować nowe osoby oczekujące
- dodawanie klientów do kolejki
- obsługa klientów kolejki
public class Shop {
			private Queue<Client> clientsQueue;

			public addToShopQueue() {
					//dodawanie elementu do kolejki
			}

			public doShoping() {
					//usuwanie elementu z kolejki
			}
}
*. Klasa Main - symulacja działa kolejki

3. Napisz własną przeglądarkę internetową, która będzie mieć możliwość wejścia na strony internetowe, oraz będzie zapewniać prosty mechanizm cofania. Na potrzeby aplikacji zaimplementuj
- klasę WebSite reprezentującą daną stronę internetową, np. www.onet.pl
- klasę Browser która będzie zapewniać mechanizm nawigacji pomiędzy odwiedzanymi stronami
- klasę Main, która będzie odpowiedzialna za prezentację funckjonalności

4. Napisz aplikację, która na podstawie poniżej listy:
1,2,3,2,1,5,5,6,2,1,5,6,7,9,7,1

List<Integer> list = Arrays.asList(1,2,3,2,1,5,5,6,2,1,5,6,7,9,7,1);

zwróci nam informację ile w liście znajduje się elementów unikalnych, w tym celu wykorzystaj strukturę Set.

5. Napisz aplikację, która ma na celu kolekcjonowanie programistów, przy czym każdy programista musi pisać w unikalnym języku. Na potrzeby zadania napisz klasę:

Developer zawierającą pola: imię, nazwisko, wiek, język programowania (dla chętnych enum)
oraz klasę zawierającą adekwatną strukturę danych:
- HashSet (value->programista)
- HashMap (key->język programowania,value->programista)