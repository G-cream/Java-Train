
class Order {
	public int id;
	// 0: New, 1: Fulfilled
	public int state;
	
	public Order() {}
	
	public Order(int id, int state) {
		this.id = id;
		this.state = state;
	}
}
