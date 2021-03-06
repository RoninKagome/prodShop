package services;

import entities.Product;

import java.util.Calendar;
import java.util.Date;

public final class ShopService {

    private final ProductService storage;
    private final Date currentDate;

    public ShopService(ProductService storage) {
        this.storage = storage;
        Calendar calendar = Calendar.getInstance();
        this.currentDate = calendar.getTime();
    }

    public void filterExpiredProducts(){
        System.out.println("Checking products for expiration");
        storage.getProductList().removeIf(p -> {
            if(p.getExpireDate().before(this.currentDate)){
                System.out.println("There is an expired product: " + p + ". \n It will be disposed of!");
                return true;
            }
            else
                return false;
        });
    }
}
