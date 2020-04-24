package polymorphism;

//상품 객체들의 상위클래스
public class Product {
	final int price;// 제품 가격
	final int bonusPoint;// 제품의 포인트

	Product(int price) {
		this.price = price;
		bonusPoint = this.price/10;
	}
}
