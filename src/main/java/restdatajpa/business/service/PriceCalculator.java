package restdatajpa.business.service;

public class PriceCalculator {
    public Double calculatePrice(restdatajpa.domain.entity.BookEntity bookEntity) {
        double price = bookEntity.getPrice();

        if (bookEntity.getPages() > 50) {
            price += 5;
        }
        price += 12.99;

        return price;
    }
}
