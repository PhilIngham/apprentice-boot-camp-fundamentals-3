package tax;

public class DefaultTaxCalculator extends TaxCalculator {
    @Override
    int calculateTax(Vehicle vehicle) {
        int co2Emissions = vehicle.getCo2Emissions();
        if (co2Emissions == 0) {
            return 0;
        } else if (co2Emissions >= 1 && co2Emissions <= 50){
            return 10;
        } else if (co2Emissions >= 51 && co2Emissions <= 75) {
            return 25;
        } else if (co2Emissions >= 76 && co2Emissions <= 90) {
            return 105;
        } else if (co2Emissions >= 91 && co2Emissions <= 100) {
            return 125;
        } else if (co2Emissions >= 101 && co2Emissions <= 110) {
            return 145;
        } else if (co2Emissions >= 111 && co2Emissions <= 130) {
            return 165;
        } else if (co2Emissions >= 131 && co2Emissions <= 150) {
            return 205;
        } else if (co2Emissions >= 151 && co2Emissions <= 170) {
            return 515;
        } else if (co2Emissions >= 171 && co2Emissions <= 190) {
            return 830;
        } else if (co2Emissions >= 191 && co2Emissions <= 225) {
            return 1240;
        } else if (co2Emissions >= 226 && co2Emissions <= 255) {
            return 1760;
        } else {
            return 2070;
        }
    }
}
