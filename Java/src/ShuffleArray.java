/**
 * Shuffle an integer array
 * Shuffle deck of cards
 * Shuffle list of songs
 */
// no matter what object you shuffle, we can always use an array to hold all objects, and shuffle every elements based on index
class Card {
	public String suit;
	public String card;
	public Card(String suit, String card){
		this.suit = suit;
		this.card = card;
	}
}

class Deck {
	public final int DECK_SIZE = 52;
	public Card[] CARDS = new Card[DECK_SIZE];
	String[] suits = {"spades", "hearts", "clovers", "diamonds"};
	String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Joker", "Queen", "King"};
	public Deck(){
		int cardIndex = 0;
		for(String suit : suits){
			for(String card : cards){
				CARDS[cardIndex] = new Card(suit, card);
				cardIndex++;
			}
		}
	}
	public void shuffle(){
		for(int i=DECK_SIZE-1; i>0; i--){
			int random = (int)(Math.random()*i);
			swap(random,i);
		}
	}
	public void printCard(){
		for(Card c : CARDS){
			System.out.println(c.suit + "\t" + c.card);
		}
	}
	private void swap(int x, int y) {
		Card temp = CARDS[x];
		CARDS[x] = CARDS[y];
		CARDS[y] = temp;
	}
}

public class ShuffleArray {
	public void shuffle(int [] arr){
		if(arr == null) return;
		for(int i=arr.length-1; i>0; i--){
			//get random index before i
			//If you want to generate a number from 0 to 100 then your code would look like this:
			//(int)(Math.random() * 101);
			//solution use i+1, I personally think using i is better because we always swap two nodes exclude itself
			int random = (int)(Math.random()*i);
			swap(arr,random,i);
		}
	}
	private void swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	private void printArray(int [] arr){
		if(arr == null) return;
		System.out.println();
		for(int i=0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6,7,8};
		ShuffleArray sa = new ShuffleArray();
		sa.shuffle(arr);
		sa.printArray(arr);

		//for deck
		Deck deck = new Deck();
		deck.printCard();
		deck.shuffle();
		deck.printCard();
	}
}
