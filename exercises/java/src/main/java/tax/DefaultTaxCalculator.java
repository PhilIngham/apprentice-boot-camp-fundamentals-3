package tax;

public class DefaultTaxCalculator extends TaxCalculator {
    private boolean story4Toggle;
    private boolean story5Toggle;

    public DefaultTaxCalculator() {
        super();
    }

    public DefaultTaxCalculator(int year) {
        super(year);
    }

    public DefaultTaxCalculator(boolean story4Toggle, boolean story5Toggle) {
        super();
        this.story4Toggle = story4Toggle;
        this.story5Toggle = story5Toggle;
    }

    @Override
    int calculateTax(Vehicle vehicle) {

        int tax = 0;
        int co2Emissions = vehicle.getCo2Emissions();
        switch (vehicle.getFuelType()) {
            case PETROL:
                tax += calculateTaxPetrol(co2Emissions);
                if(vehicle.getListPrice() > 40000){
                    tax += 450;
                }
            case DIESEL:
                tax += calculateTaxDiesel(co2Emissions);
                if(vehicle.getListPrice() > 40000){
                    tax += 450;
                }
            case ALTERNATIVE_FUEL:
                tax += calculateTaxAlternativeFuel(co2Emissions);
                if(vehicle.getListPrice() > 40000){
                    tax += 440;
                }
            case ELECTRIC:
                tax += 0;
                if(vehicle.getListPrice() > 40000){
                    tax += 310;
                }
        }
        if(isStory5Toggle() && vehicle.getListPrice() > 40000){
            addYearlyTax(vehicle.getFuelType());
        }

        return tax;
    }

    public int addYearlyTax(FuelType fuelType){
        return 0;
    }

    public int calculateTaxPetrol(int co2Emissions){
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

    public int calculateTaxDiesel(int co2Emissions) {
        if (co2Emissions == 0) {
            return 0;
        } else if (co2Emissions >= 1 && co2Emissions <= 50){
            return 25;
        } else if (co2Emissions >= 51 && co2Emissions <= 75) {
            return 105;
        } else if (co2Emissions >= 76 && co2Emissions <= 90) {
            return 125;
        } else if (co2Emissions >= 91 && co2Emissions <= 100) {
            return 145;
        } else if (co2Emissions >= 101 && co2Emissions <= 110) {
            return 165;
        } else if (co2Emissions >= 111 && co2Emissions <= 130) {
            return 205;
        } else if (co2Emissions >= 131 && co2Emissions <= 150) {
            return 515;
        } else if (co2Emissions >= 151 && co2Emissions <= 170) {
            return 830;
        } else if (co2Emissions >= 171 && co2Emissions <= 190) {
            return 1240;
        } else if (co2Emissions >= 191 && co2Emissions <= 225) {
            return 1760;
        } else if (co2Emissions >= 226 && co2Emissions <= 255) {
            return 2070;
        } else {
            return 2070;
        }
    }

    public int calculateTaxAlternativeFuel(int co2Emissions) {
        int tax;
        if (co2Emissions > 255) {
            tax = 2060;
        } else if (co2Emissions > 225) {
            tax = 1750;
        } else if (co2Emissions > 190) {
            tax = 1230;
        } else if (co2Emissions > 170) {
            tax = 820;
        } else if (co2Emissions > 150) {
            tax = 505;
        } else if (co2Emissions > 130) {
            tax = 195;
        } else if (co2Emissions > 110) {
            tax = 155;
        } else if (co2Emissions > 100) {
            tax = 135;
        } else if (co2Emissions > 90) {
            tax = 115;
        } else if (co2Emissions > 75) {
            tax = 95;
        } else if (co2Emissions > 50) {
            tax = 15;
        } else  {
            tax = 0;
        }

        return tax;
    }

    public boolean isStory4Toggle() {
        return story4Toggle;
    }

    public boolean isStory5Toggle() {
        return story5Toggle;
    }
}
