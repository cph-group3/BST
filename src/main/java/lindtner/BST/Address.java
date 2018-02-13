package lindtner.BST;

public class Address
{
	String street;
	Address(String st){
		street = st;
	}
	@Override
	public String toString() {
		return "" + street;
	}
}
