1. Napisz mechanizm umożliwiający sekwencyje poruszanie  się po kolekcji Pokemonów, wykorzystaj w tym celu wzorzez Iterator, który będzie realizować poniższe funkcjonalności:
a. boolean hasNext();
b. Pokemon next();
*c. boolean hasPrev();
*d. Pokemon prev();

Kolekcja pokemonów powinna być agregatem dla pojedynczych obiektów typu Pokemon.
* zadania rozszerzające

2. Napisz mechanizm rozszerzający możliwości samochodu bazowego, wykorzystaj w tym celu wzorzec dekorator, który będzie realizować poniższe funkcjonalności:
Samochód bazowy będziemy mogli rozszerzyć dodatkowo o:
- kolor karoseri
- spojler
- koła w różnych rozmiarze
Ważne, by użytkownik konfigurujący auto mógł dynamicznie dobierać sobie usprawnienia dla swojego samochodu.


3. Napisz mechanizm realizujący strukturę drzewiastą przedstawiającą sturkturę korporacji IT. Do tego celu wykorzystaj wzorzec projektowy kompozyt:
Pojedynczym element (leaf) będzie w tym przypadku developer
Kompozytem będzie natomiast manager który może koordynowac pracę wielu developerów oraz managerów. Zaimplementuj mechanizm któr pozwoli wyświetlić listę zarobków każdego pracownika w firmie.


4. Napisz aplikację symulującą wypłatę z bankomatu. Wykorzystaj do tego łańuch zobowiązań. Pojedynczym ogniwem powinno być w tym przypadku wypłata określonego nominału, np jak poniżej:
200
 |
\_/
100
 |
\_/
50
 |
\_/
20

Algorytm powinien działać tak by na początku sprawdzał czy jak dużo rządanych pieniędzy jesteśmy w stanie wypłacić za pomocą największego nominału, a ewenetualnie brakującej reszty poszukać dla niższego nominału. Rozważmy następujący przykład:
Kwotoa do wypłaty: 750 zł
Banknoty dostępne w bankomacie
200x2
100x10
50x3
20x10

750 zł rozbijamy na -> 200x2 + 100x3 + 50x1: bierzemy maksymalną dopuszczalną liczbę każdego z banknotów a to kolejnego ogniwa przekazujemy reszte kwoty którą chcemy wypłacić.

5. Napisz aplikację realizującą wzorzec projektowy mediator realizującą działanie firmy kurierskiej
- dyspozytor powinien posiadać listę kurierów dostępnych do rozwożenia przesyłek
- dyspozytor powinien do każdej paczki wysyłać nowego kuriera
- każdy kurier powien rozwozić paczkę w 20s.
- w przypadku braku dostępnych kurierów, dyzpozytor powinen poczekać, aż obecnie zajęci zrobią zaplanowny kurs

6. Napisz aplikację wykorzystującą metodę szablonową w oparciu o alogrytm robienia szekja owocowego.
Napisz 3 przykładowe własne realizacje szejka w oparciu o zaproponowany algorytm.

7. Napisz program realizujący wzorzec projektowy Polecenie zgodnie z poniższymi wymaganiami:
- napisz klasy Polecenie dla operacji, zapisu, odczytania, stworzenia pliku
- receiverem powininien być dowolny javowy plik

8. Napisz aplikację realizującą wzorzec projektowy stan realizującą funkcjonalność kawomatu. Kawomat może być w stanie:
- czeka na zamówinie
- konfiguracja zamówienia
- płatność
- przygotowanie kawy
- wydawanie reszty

9. Napisz aplikację realizującą wzorzec projektowy stan realizującą funkcjonalność symulatora laptopa. Laptop może być w stanie
- włączony,
- wyłączony,
- uśpiony,
- hibernacja

10. Napisz mechanizm rozszerzający możliwości samochodu bazowego, wykorzystaj w tym celu wzorzec dekorator, który będzie realizować poniższe funkcjonalności:
Samochód bazowy będziemy mogli rozszerzyć dodatkowo o:
- kolor karoseri
- spojler
- koła w różnych rozmiarze
Ważne, by użytkownik konfigurujący auto mógł dynamicznie dobierać sobie usprawnienia dla swojego samochodu.

11. Napisz mechanizm urozmaicający burgera, wykorzystaj w tym celu wzorzec dekorator, który będzie realizować poniższe funkcjonalności:
Burger podstawowy będziemy mogli wzbogacić o:
- nachos
- sos barbecue
- ser pleśniowy
Ważne, by użytkownik konfigurujący mógł wybrać sobie takiego burgera na jakiego ma ochotę.

12. Napisz mechanizm umożliwiający sekwencyjne poruszanie  się po kolekcji samochodów w garażu (CarsInGarage), wykorzystaj w tym celu wzorzez Iterator, który będzie realizować poniższe funkcjonalności:
a. boolean hasNext();
b. Car next();
Struktura Cars w środku powinna operować na Stosie. Ostani samochód wjeżdżający do garażu wyjedzie jako pierwszy.

13. Napisz mechanizm umożliwiający sekwencyje poruszanie  się po kolekcji Książek na półce (Books), wykorzystaj w tym celu wzorzez Iterator, który będzie realizować poniższe funkcjonalności:
a. boolean hasNext();
b. Book next();
*c. boolean hasPrev();
*d. Book prev();
Struktura Books w środku powinna operować na Kolejce. Pierwsza książka na półce będzie obsługiwana jako pierwsza.

14. Napisz mechanizm umożliwiający ściąganie aplikacji ze sklepu Google. Dostawca telewizyjny posiada 3 aplikację różniące się tylko szatą graficzną i zawartością, np.
HboHistory - programy historyczny
HboKids - programy dla dzieci
HboSeries - seriale produkcji Hbo
Użytkownik na podstawie wskazanego typu powinien móc pobierać aplikację.
*zadbaj o realizację zasady O - Open/Closed

15. Napisz mechanizm umożliwiający tworzenie okien dialogowych w zależności od systemu operacyjnego, np.
WindowsDialog - okno dialogowe systemu Windows
LinuxDialog - okno dialogowe systemu Linux
OsxDialog - okno dialogowe systemu OSX
AndroidDialog - okno dialogowe systemu Android
Użytkownik na podstawie zainstalowanego sytemu powinen widzieć dane okno systemowe.

16. Napisz fasadę umożliwiającą odtwarzanie video, w tym celu zintegruj poniższe systemy
- strumieniowanie video na podstawie url:
* playVideoByUrl(String url);
- logowanie do systemu:
* login(String login, String password)
* logout(String login, String password);
- obsługa napisów
* enableCC();
* disableCC();
Tylko zalogowany użytkownik może obejrzeć video. Każdy użytkownik może w dowolnej chwili włączyć/wyłączyć napisy

17. Napisz fasadę sklepu telefonów komórkowych umożliwiający sprzedaż telefonów marki: Apple, Samsung, Google
Sklep powinien korzystać z usług autoryzowanych dostawców tych urządzeń. Jako przykład wykorzystaj załączony diagram UML.