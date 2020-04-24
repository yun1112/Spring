package inheritance;

class HybridCar extends Car {
	int electronicGauge;

	HybridCar(int gasolinegauge, int electronicGauge) {
		super(gasolinegauge);
		this.electronicGauge = electronicGauge;
	}
}
